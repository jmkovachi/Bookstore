package org.csci4050.bookstore.Bookstore.scripts;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InsertBooks {

    private BookService bookService;

    @Autowired
    public InsertBooks(final BookService bookService) {
        this.bookService = bookService;
    }

    private static final String CSV_FILE_PATH = "top100books.csv";
    private static final String GOOGLE_API_KEY = "AIzaSyBSN5uG32j8t4zcLiMOa9cfg3QUSlM3FQU";

    public static void main(final String[] args) throws IOException, GeneralSecurityException, ParseException, NumberFormatException {
        final Reader reader = new FileReader(CSV_FILE_PATH);
        final CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());
        final JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
                .setApplicationName("Name")
                .setGoogleClientRequestInitializer(new BooksRequestInitializer(GOOGLE_API_KEY))
                .build();

        final Random random = new Random();
        for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names assigned to each column
            final String isbn = csvRecord.get("ISBN");
            final String query = "isbn:" + isbn;
            final Books.Volumes.List volumesList = books.volumes().list(query);

            final Volumes volumes = volumesList.execute();
            if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
                System.out.println("No matches found for isbn " + isbn);
            } else {
                for (final Volume volume : volumes.getItems()) {
                    try {
                        final String imageUrl = volume.getVolumeInfo().getImageLinks().getThumbnail();
                        final String vendor = volume.getVolumeInfo().getPublisher();
                        final String author = volume.getVolumeInfo().getAuthors().get(0);
                        final String title = volume.getVolumeInfo().getTitle();
                        final String datePublishedString = volume.getVolumeInfo().getPublishedDate();
                        final Date datePublished;
                        if (datePublishedString.length() == 10) {
                            datePublished = new SimpleDateFormat("yyyy-MM-dd").parse(datePublishedString);
                        } else if (datePublishedString.length() == 7) {
                            datePublished = new SimpleDateFormat("yyyy-MM").parse(datePublishedString);
                        } else {
                            datePublished = convertYearToDate(datePublishedString);
                        }
                        final Float rating = new Float(volume.getVolumeInfo().getAverageRating());
                        final String summary = volume.getVolumeInfo().getDescription();
                        final int pages = volume.getVolumeInfo().getPageCount();
                        final List<String> category = volume.getVolumeInfo().getCategories();
                        if (category.size() == 0) {
                            continue;
                        }
                        final Book book = Book.builder()
                                .author(author)
                                .isbn(isbn)
                                .rating(rating)
                                .summary(summary)
                                .title(title)
                                .totalInventory(random.nextInt(1000))
                                .pages(pages)
                                .category(category.get(0))
                                .vUsername(vendor)
                                .imageUrl(imageUrl)
                                .price(Double.parseDouble(String.format("%.2f", 5 + (15 - 5) * random.nextDouble())))
                                .datePublished(datePublished)
                                .build();
                        System.out.println(book.toString());
                    } catch(NullPointerException n) {
                        System.out.println(n);
                    }


                }
            }
        }
    }

    /**
     * Takes a year formatted as a string (e.g. 1998) and creates a random date within that year. (E.g 1998-09-18)
     * This is used so we can get the proper formatting for the date published field in our database.
     * Reference: https://stackoverflow.com/questions/40253332/generating-random-date-in-a-specific-range-in-java
     * @param year four digit year as a string
     * @return a random date within a certain year
     * @throws ParseException simple date format parse exception
     */
    private static Date convertYearToDate(final String year) throws ParseException {
        final Date date1 = new SimpleDateFormat("yyyy").parse(year);
        final Date date2 = new SimpleDateFormat("yyyy").parse(Integer.toString(Integer.parseInt(year)+1));
        return new Date(ThreadLocalRandom.current().nextLong(date1.getTime(), date2.getTime()));
    }
}

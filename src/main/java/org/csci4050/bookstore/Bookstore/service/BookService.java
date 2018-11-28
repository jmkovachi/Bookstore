package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.BookDao;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookService {

    private BookDao bookDao;

    private VendorService vendorService;

    @Autowired
    public BookService(final BookDao bookDao, final VendorService vendorService) {
        this.bookDao = bookDao;
        this.vendorService = vendorService;
    }

    public Optional<Book> getBook(final String isbn) {
        return bookDao.getBook(isbn);
    }

    public void insertBook(final Book book) throws ValidationException {
        this.checkVendorUsernameExists(book.getVUsername());
        bookDao.createBook(book);
    }

    public void deleteBook(final String isbn) throws ValidationException {
        if (!bookDao.getBook(isbn).isPresent()) {
            throw new ValidationException("Book with isbn <%s> does not exist", isbn);
        }
        bookDao.deleteBook(isbn);
    }

    public void deleteBookForVendor(final String isbn, final String vUsername) throws ValidationException {
        final Optional<Book> optionalBook = bookDao.getBook(isbn);
        if (!optionalBook.isPresent()) {
            throw new ValidationException("Book with isbn <%s> does not exist", isbn);
        }
        final Book book = optionalBook.get();
        if (!book.getVUsername().equals(vUsername)) {
            throw new ValidationException("Book with isbn <%s> does not belong to vendor <%s>", isbn, vUsername);
        }
        bookDao.deleteBook(isbn);
    }

    public void updateBook(final Book book) throws ValidationException {
        final Optional<Book> bookOptional = bookDao.getBook(book.getIsbn());
        if (!bookOptional.isPresent()) {
            throw new ValidationException("Book with isbn <%s> does not exist", book.getIsbn());
        }
        final Book retrievedBook = bookOptional.get();
        if (book.getDatePublished() == null) {
            book.setDatePublished(retrievedBook.getDatePublished());
        }
        if (book.getPages() == null) {
            book.setPages(retrievedBook.getPages());
        }
        if (book.getRating() == null) {
            book.setRating(retrievedBook.getRating());
        }
        if (book.getTotalInventory() == null) {
            book.setTotalInventory(retrievedBook.getTotalInventory());
        }
        if (book.getVUsername() == null) {
            book.setVUsername(retrievedBook.getVUsername());
        }

        bookDao.updateBook(book);
    }

    public List<Book> getBooks() {
        return this.bookDao.getBooks();
    }

    public List<Book> queryBooks(final String column, final String value) throws ValidationException {
        final List<String> validColumns = Arrays.asList("isbn", "author", "title");
        if (!validColumns.contains(column)) {
            throw new ValidationException("Value <%s> is not a valid query parameter", column);
        }
        return bookDao.queryBooks(column, value);
    }

    public List<Book> queryBooksInventory(final int intventoryValue) throws ValidationException {
        return bookDao.getBooksWithInventoryLessThanNum(intventoryValue);
    }

    public List<Book> getBooksByColumns(final String column, final String value) {
        return bookDao.queryBooks(column, value);
    }

    public List<String> getCategoryValues() {
        return bookDao.getValuesByColumn("category");
    }

    private void checkVendorUsernameExists(final String vUsername) throws ValidationException {
        if (!vendorService.getVendor(vUsername).isPresent()) {
            throw new ValidationException("Vendor with username <%s> does not exist", vUsername);
        }
    }

    public List<Book> getLowInventoryBooks(){
        return null;
    }
}

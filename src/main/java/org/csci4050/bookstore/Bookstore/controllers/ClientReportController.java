package org.csci4050.bookstore.Bookstore.controllers;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.dao.BookDao;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.model.Order;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientReportController {

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/low-inv-notice", method = RequestMethod.GET)
    public ModelAndView lowinv() {
        final List<Book> lowInventoryBooks = bookService.getLowInventoryBooks(100);
        return new ModelAndView("views/low-inv-notice", "lowinv", lowInventoryBooks);
    }

    @RequestMapping(value = "/end-of-day-sales", method = RequestMethod.GET)
    public ModelAndView endOfDay() {
        final List<Order> allOrders = orderService.getOrdersFromLastDay();
        final int totalOrders = allOrders.size();
        final double total = allOrders.stream().map(Order::getTotal).reduce(0.0, (o1, o2) -> o1 + o2);
        final List<BookDao.IsbnWithCount> isbnWithCounts = bookService.getBestSellingBookFromLastDay();
        final Book book = bookService.getBook(isbnWithCounts.get(0).getIsbn()).get();
        final EndOfDayModel eod = EndOfDayModel.builder()
                .bestSeller(isbnWithCounts.get(0))
                .total(total)
                .totalOrders(totalOrders)
                .bestSellingBook(book)
                .build();
        return new ModelAndView("views/end-of-day-sales", "eod", eod);
    }

    @RequestMapping(value = "/book-sales", method = RequestMethod.GET)
    public ModelAndView bookSales() {
        final List<Order> yearOrders = orderService.getOrdersFromLastYear();
        final List<Order> monthOrders = orderService.getOrdersFromLastMonth();
        final BookSalesModel bookSalesModel = createBookSalesModelFromOrders(monthOrders, yearOrders);
        return new ModelAndView("views/book-sales", "sales", bookSalesModel);
    }

    @RequestMapping(value = "/book-sales/{isbn}", method = RequestMethod.GET)
    public ResponseEntity<Object> bookSalesForBook(@PathVariable final String isbn) throws ValidationException {
        if (!bookService.getBook(isbn).isPresent()) {
            throw new ValidationException("Book with isbn <%s> not present", isbn);
        }

        final List<Order> yearOrders = orderService.getOrdersFromLastYearForBook(isbn);
        final List<Order> monthOrders = orderService.getOrdersFromLastMonthForBook(isbn);
        final BookSalesModel bookSalesModel = createBookSalesModelFromOrders(monthOrders, yearOrders);
        return new ResponseEntity<>(bookSalesModel, new HttpHeaders(), HttpStatus.OK);
    }

    private BookSalesModel createBookSalesModelFromOrders(final List<Order> monthOrders, final List<Order> yearOrders) {
        return BookSalesModel.builder()
                .totalMonthAmount(monthOrders.stream().map(Order::getTotal).reduce(0.0, (o1, o2) -> o1 + o2))
                .totalYearAmount(yearOrders.stream().map(Order::getTotal).reduce(0.0, (o1, o2) -> o1 + o2))
                .totalMonthSales(monthOrders.size())
                .totalYearSales(yearOrders.size())
                .build();
    }

    @Data
    @Builder
    public static class EndOfDayModel {
        private int totalOrders;
        private double total;
        private BookDao.IsbnWithCount bestSeller;
        private Book bestSellingBook;
    }

    @Data
    @Builder
    public static class BookSalesModel {
        private int totalYearSales;
        private int totalMonthSales;
        private double totalYearAmount;
        private double totalMonthAmount;
    }

}
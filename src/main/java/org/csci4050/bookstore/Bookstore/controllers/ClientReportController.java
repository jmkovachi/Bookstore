package org.csci4050.bookstore.Bookstore.controllers;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.dao.BookDao;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.model.Order;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "end-of-day", method = RequestMethod.GET)
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
        
    }

    @Data
    @Builder
    public static class EndOfDayModel {
        private int totalOrders;
        private double total;
        private BookDao.IsbnWithCount bestSeller;
        private Book bestSellingBook;
    }

}
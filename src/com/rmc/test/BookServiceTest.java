package com.rmc.test;

import com.rmc.pojo.Book;
import com.rmc.pojo.Page;
import com.rmc.service.BookService;
import com.rmc.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author rmcgo
 * @create 2020-11-08 14:41
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"看见","柴静",new BigDecimal(90),1000,100,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"看见","柴静",new BigDecimal(90),10000,10,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGE_SIZE));

    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}
package com.rmc.test;

import com.rmc.dao.BookDao;
import com.rmc.dao.impl.BookDaoImpl;
import com.rmc.pojo.Book;
import com.rmc.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author rmcgo
 * @create 2020-11-08 11:54
 */
public class BookDaoTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"人生","rmc",new BigDecimal(9999),1100000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"平凡的世界","路遥",new BigDecimal(9999),1100000,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for(Book book : bookDao.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book item : bookDao.queryForPageItems(1, Page.PAGE_SIZE)) {
            System.out.println(item);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Book item : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50)) {
            System.out.println(item);
        }
    }
}
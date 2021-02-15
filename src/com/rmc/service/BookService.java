package com.rmc.service;

import com.rmc.pojo.Book;
import com.rmc.pojo.Page;

import java.util.List;

/**
 * @author rmcgo
 * @create 2020-11-08 14:31
 */
public interface BookService {

    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}

package com.rmc.dao;

import com.rmc.pojo.Book;

import java.util.List;

/**
 * @author rmcgo
 * @create 2020-11-08 11:18
 */
public interface BookDao {

    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}

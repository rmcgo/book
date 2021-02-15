package com.rmc.dao.impl;

import com.rmc.dao.BookDao;
import com.rmc.pojo.Book;

import java.util.List;

/**
 * @author rmcgo
 * @create 2020-11-08 11:24
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {

        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }


    @Override
    public int updateBook(Book book) {
        System.out.println("BookDaoImpl程序在【"+Thread.currentThread().getName()+"中");

//        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
//        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
        return queryForone(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "SELECT `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath FROM t_book LIMIT ?,?;";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "SELECT`id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath " +
                "FROM t_book where price between ? and ? order by price LIMIT ?,?;";
        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }
}

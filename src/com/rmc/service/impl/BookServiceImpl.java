package com.rmc.service.impl;

import com.rmc.dao.BookDao;
import com.rmc.dao.impl.BookDaoImpl;
import com.rmc.pojo.Book;
import com.rmc.pojo.Page;
import com.rmc.service.BookService;

import java.util.List;

/**
 * @author rmcgo
 * @create 2020-11-08 14:38
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //设置总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        //设置总页码数
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);

        //设置当前页数据
        int begin = (page.getPageNo()-1)*pageSize;
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //设置总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);

        //设置总页码数
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);

        //设置当前页数据
        int begin = (page.getPageNo()-1)*pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);

        return page;
    }
}

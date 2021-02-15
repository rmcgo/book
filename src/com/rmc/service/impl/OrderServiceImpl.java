package com.rmc.service.impl;

import com.rmc.dao.BookDao;
import com.rmc.dao.OrderDao;
import com.rmc.dao.OrderItemDao;
import com.rmc.dao.impl.BookDaoImpl;
import com.rmc.dao.impl.OrderDaoImpl;
import com.rmc.dao.impl.OrderItemImpl;
import com.rmc.pojo.*;
import com.rmc.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author rmcgo
 * @create 2020-11-11 19:46
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单唯一性
        String orderId = System.currentTimeMillis() + "" + userId;
        //创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单
        orderDao.saveOrder(order);

        //遍历购物车中每一个商品项转换成为订单保存到数据库
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            //获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            //转换为每一个订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            //保存订单到数据库
            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return orderId;
    }
}

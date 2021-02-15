package com.rmc.dao;

import com.rmc.pojo.Order;

import java.util.List;

/**
 * @author rmcgo
 * @create 2020-11-11 19:10
 */
public interface OrderDao {

    int saveOrder(Order order);

    List<Order> queryOrderByUserId();

}

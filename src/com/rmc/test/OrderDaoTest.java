package com.rmc.test;

import com.rmc.dao.OrderDao;
import com.rmc.dao.impl.OrderDaoImpl;
import com.rmc.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author rmcgo
 * @create 2020-11-11 19:35
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(new Order("123",new Date(),new BigDecimal(100),0,1));

    }


    @Test
    public void queryOrderByUserId() {

        OrderDao orderDao = new OrderDaoImpl();

        List<Order> orderList = orderDao.queryOrderByUserId();

        for (Order order : orderList) {
            System.out.println(order);
        }

    }
}
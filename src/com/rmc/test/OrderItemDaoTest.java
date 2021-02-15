package com.rmc.test;

import com.rmc.dao.OrderItemDao;
import com.rmc.dao.impl.OrderItemImpl;
import com.rmc.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author rmcgo
 * @create 2020-11-11 19:38
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),
                new BigDecimal(100),"123456789"));
        orderItemDao.saveOrderItem(new OrderItem(null,"javaScript从入门到精通",2,new BigDecimal(100),
                new BigDecimal(100),"123456789"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Netty从入门到精通",1,new BigDecimal(100),
                new BigDecimal(100),"123456789"));
    }
}
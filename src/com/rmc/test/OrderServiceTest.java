package com.rmc.test;

import com.rmc.pojo.Cart;
import com.rmc.pojo.CartItem;
import com.rmc.service.OrderService;
import com.rmc.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author rmcgo
 * @create 2020-11-11 20:02
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println("订单号是：" + orderService.createOrder(cart,1));

    }
}
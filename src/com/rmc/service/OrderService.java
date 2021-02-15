package com.rmc.service;

import com.rmc.pojo.Cart;

/**
 * @author rmcgo
 * @create 2020-11-11 19:46
 */
public interface OrderService {

    String createOrder(Cart cart,Integer userId);

}

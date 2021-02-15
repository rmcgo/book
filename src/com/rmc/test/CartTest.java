package com.rmc.test;

import com.rmc.pojo.Cart;
import com.rmc.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author rmcgo
 * @create 2020-11-11 10:19
 */
public class CartTest {

    Cart cart = new Cart();

    @Test
    public void addItem() {

        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"计算机网络",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"计算机网络",1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"计算机网络",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"计算机网络",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);

        System.out.println(cart);

    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"计算机网络",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"计算机网络",1,new BigDecimal(100),new BigDecimal(100)));

        cart.clear();

        System.out.println(cart);

    }

    @Test
    public void updateCount() {

        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"计算机网络",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"计算机网络",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(2);
        cart.updateCount(1,10);


        System.out.println(cart);

    }
}
package com.rmc.web;

import com.rmc.pojo.Cart;
import com.rmc.pojo.User;
import com.rmc.service.OrderService;
import com.rmc.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rmcgo
 * @create 2020-11-11 20:05
 */
public class OrderServlet extends BaseServlet{

    OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer userId = loginUser.getId();

        //调用orderService.createOrder(Cart,Userid):生成订单
        String orderId = orderService.createOrder(cart, userId);

//        req.setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);
        //请求转发到http:/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);

        //重定向回结算页面
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");

    }
}

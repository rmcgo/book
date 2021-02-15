package com.rmc.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author rmcgo
 * @create 2020-11-07 21:21
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post请求中文乱码问题
        //要求在获取请求参数之前调用才有效
        req.setCharacterEncoding("utf-8");
        //解决响应中文乱码问题
        resp.setContentType("text/html;charset=utf-8");
        String action = req.getParameter("action");
        try {
            // 获取action业务鉴别字符串，获取相应的业方法反射对象
            //通过反射获取当前类的某个Method（不包括父类），前面是方法名，后面是参数类型
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 调用目标业务方法
            //invoke的第一个参数是对象实例，即在哪个实例上调用该方法，后面的可变参数要与方法参数一致，否则将报错。
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Filter过滤器
        }
    }
}

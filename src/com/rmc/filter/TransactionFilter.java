package com.rmc.filter;

import com.rmc.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author rmcgo
 * @create 2020-11-12 16:37
 */
public class TransactionFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request,response);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException();//把异常抛给tomcat管理展示有好的页面
        }
    }

    @Override
    public void destroy() {

    }
}

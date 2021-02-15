package com.rmc.web;

import com.rmc.pojo.User;
import com.rmc.service.UserService;
import com.rmc.service.impl.UserServiceImpl;
import com.rmc.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author rmcgo
 * @create 2020-11-07 20:24
 */
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数username
        String username = req.getParameter("username");
        //调用userService.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装成为map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);

    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁Seesion中用户登陆的信息（或者销毁Session)
        req.getSession().invalidate();
        //2.重定向到首页（或登陆页面)
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");

        User user = WebUtils.copyParamToBean(new User(),req.getParameterMap() );

        //2.调用userService.login处理业务
        User loginUser = userService.login(user);
        //如果等于null，说明登录失败
        if (loginUser == null) {
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);

            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //保存用户登录的信息到Session域中
            req.getSession().setAttribute("user",loginUser);
            //登录成功，跳到成功页面login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取Session中的验证码
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1.获取请求参数
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(new User(), req.getParameterMap());

        //2.检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            //正确
            if (userService.existsUsername(username)) {
                //把回显信息，保存到Request域中
                req.setAttribute("msg", "用户名已存在！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                //用户名不可用
                System.out.println("用户名" + username + "已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //用户名可用
                userService.registUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            //不正确,跳回注册页面
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}

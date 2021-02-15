package com.rmc.test;

import com.rmc.pojo.User;
import com.rmc.service.UserService;
import com.rmc.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author rmcgo
 * @create 2020-11-05 20:53
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"abc123","abc123","abc123@qq.com"));
    }

    @Test
    public void login() {

        System.out.println(userService.login(new User(null,"admin","admin",null)));

    }

    @Test
    public void existsUsername() {

        if(userService.existsUsername("admin")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }

    }
}
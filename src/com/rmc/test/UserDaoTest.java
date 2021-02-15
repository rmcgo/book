package com.rmc.test;

import com.rmc.dao.UserDao;
import com.rmc.dao.impl.UserDaoImpl;
import com.rmc.pojo.User;
import org.junit.Test;

/**
 * @author rmcgo
 * @create 2020-11-05 20:32
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        if(userDao.queryUserByUsername("admin1") == null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登录失败！");
        }else {
            System.out.println("查询成功");
        }

    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"rmc123","123456","admin@126.com")));
    }
}
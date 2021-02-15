package com.rmc.service.impl;

import com.rmc.dao.UserDao;
import com.rmc.dao.impl.UserDaoImpl;
import com.rmc.pojo.User;
import com.rmc.service.UserService;

/**
 * @author rmcgo
 * @create 2020-11-05 20:44
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username)==null){
            //等于null表示没查到，表示可用
            return false;
        }else{
            return true;
        }
    }
}

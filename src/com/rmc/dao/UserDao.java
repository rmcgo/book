package com.rmc.dao;

import com.rmc.pojo.User;

/**
 * @author rmcgo
 * @create 2020-11-05 20:22
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 如果返回null，说明没有这个用户。
     */
    public User queryUserByUsername(String username);


    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @return 如果返回null，说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);


    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败，其他表示sql语句影响的行数
     */
    public int saveUser(User user);




}

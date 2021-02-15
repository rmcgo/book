package com.rmc.test;

import com.rmc.utils.JdbcUtils;

/**
 * @author rmcgo
 * @create 2020-11-05 20:07
 */
public class JdbcUtilsTest {

    @org.junit.Test
    public void getConnection() {

        System.out.println(JdbcUtils.getConnection());

    }
}
package com.rmc.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author rmcgo
 * @create 2020-11-08 9:34
 */
public class WebUtils {

    /**
     * 把Map中的值注入到对应的JavaBean属性中
     *
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(T bean, Map value) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
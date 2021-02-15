package com.rmc.dao.impl;

import com.rmc.dao.OrderDao;
import com.rmc.pojo.Order;

import java.util.List;

/**
 * @author rmcgo
 * @create 2020-11-11 19:12
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`total_money`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getTotalMoney(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrderByUserId() {
        String sql = "select `order_id`,`create_time`,`total_money`,`status`,`user_id` from `t_order`";
        return queryForList(Order.class,sql);
    }
}

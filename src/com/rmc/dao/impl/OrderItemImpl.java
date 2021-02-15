package com.rmc.dao.impl;

import com.rmc.dao.OrderItemDao;
import com.rmc.pojo.OrderItem;

/**
 * @author rmcgo
 * @create 2020-11-11 19:15
 */
public class OrderItemImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {

        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_money`,`order_id`) values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getTotalMoney(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}

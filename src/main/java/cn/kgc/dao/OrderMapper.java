package cn.kgc.dao;

import cn.kgc.entity.Order;
import cn.kgc.entity.Page;

import java.util.List;

public interface OrderMapper {
    //增加订单方法
    void saveOrder(Order order);
    //删除订单
    void delOrderById(String id);
    //修改订单
    void updateOrder(Order order);
    //根据uid查询订单
    List<Order> getOrderByUid(String uid);
    //查询所有订单
    List<Order> getAll();
    //使用分页查询当前页面的订单信息
    List<Order> getOrderByPage(Page<Order> page);
}

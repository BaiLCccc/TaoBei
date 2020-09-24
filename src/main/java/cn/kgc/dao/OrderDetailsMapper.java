package cn.kgc.dao;

import cn.kgc.entity.OrderDetails;
import cn.kgc.entity.Page;

import java.util.List;

public interface OrderDetailsMapper {
    //增加
    void saveOrderDetails(OrderDetails orderDetails);
    //删除
    void delOrderDetails(int oid);
    //修改
    void updateOrderDetails(OrderDetails orderDetails);
    //查询一个
    OrderDetails getOrderDetailsByOid(int oid);
    //查询所有的订单
    List<OrderDetails> getOrderDetails();
    //使用分页查询当前页面的订单信息
    List<OrderDetails> getOrderDetailsByPage(Page<OrderDetails> page);
}

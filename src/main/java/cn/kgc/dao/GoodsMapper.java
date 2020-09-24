package cn.kgc.dao;


import cn.kgc.entity.Goods;
import cn.kgc.entity.Page;

import java.util.List;

public interface GoodsMapper {
    //增加商品
    void addGoods(Goods goods);
    //删除商品
    void delGoods(int gid);
    //修改商品
    void updateGoods(Goods goods);
    //查询一个商品
    Goods getGoodsByGid(int gid);
    //查询所有商品
    List<Goods> getGoods();
    //查询总记录数
    int getCount();
    //分页查询当前页面商品
    List<Goods> getGoodsByPage(Page<Goods> page);
}

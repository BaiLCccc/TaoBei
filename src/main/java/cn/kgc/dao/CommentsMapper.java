package cn.kgc.dao;


import cn.kgc.entity.Comments;
import cn.kgc.entity.Page;

import java.util.List;

public interface CommentsMapper {
    //增加评论方法
    void saveComments(Comments comments);
    //删除评论
    void delCommentsByCid(String cid);
    //修改评论
    void updateComments(Comments comments);
    //根据评论cid查询评论
    Comments getCommentsByCid(String cid);
    //根据用户uid查询评论
    List<Comments> getCommentsByUid(String uid);
    //根据商品gid查询评论
    List<Comments> getCommentsByGid(String gid);
    //查询所有评论
    List<Comments> getAll();
    //使用分页查询当前商品的所有评论信息
    List<Comments> getCommentsByPage(Page<Comments> page);
}

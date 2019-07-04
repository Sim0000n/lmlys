package team.area237.lmlys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.area237.lmlys.model.entity.Cart;
import team.area237.lmlys.model.request.UpdateCartRequest;

import java.util.List;

@Mapper
@Component
public interface CartDao {
    //购物车的商品ID数量
    Integer amountSelectByUsername(@Param("username")String username);
    //获取购物车内商品的信息Cart:String goodsId,int count
    List<Cart> InfoSelectByUsername(@Param("username")String username);
    //删除当前用户的购物车信息
    int deleteByUsername(@Param("username")String username);
    //上传当前用户的购物车信息
    int insertAllByUsername(@Param("username")String username,@Param("array") UpdateCartRequest[] carts);
    //添加新商品
    int insertByUsername(@Param("username")String username,@Param("goods_id")int id,@Param("count")int count);
}

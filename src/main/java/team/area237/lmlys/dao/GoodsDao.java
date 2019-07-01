package team.area237.lmlys.dao;


import org.apache.ibatis.annotations.Param;
import team.area237.lmlys.model.response.GoodsGeneralResponse;

import java.util.List;

public interface GoodsDao {
    //返回所有商品类型
    List<String> categorySelect();
    //返回商品
    GoodsGeneralResponse selectById(@Param("id")int id);
    //关键词搜索返回商品ID
    List<Integer> idsSelectByWord(@Param("key_word")String KeyWord);
    //返回最热的前几个商品ID
    List<Integer> idsSelectByCount(@Param("amount")int amount);
    //返回分类的商品ID
    List<Integer> idsSelectByCategory(@Param("category")String category);


    //返回最热搜索词
    List<String> wordSelectOrderByFrequency(@Param("amount")int amount);
}

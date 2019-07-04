package team.area237.lmlys.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.area237.lmlys.model.response.GoodsGeneralResponse;
import team.area237.lmlys.utils.ImgUrls;

import java.util.List;
@Mapper
@Component
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

    //根据商品id，返回商品所有图片
    ImgUrls selectUrlsById(@Param("id")int id);
    //根据商品id，返回商品详情
    String selectDescriptionById(@Param("id")int id);

    //返回库存
    Integer selectStorageCountById(@Param("id")int id);
}

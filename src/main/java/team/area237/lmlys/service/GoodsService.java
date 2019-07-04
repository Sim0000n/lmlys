package team.area237.lmlys.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import team.area237.lmlys.model.response.*;
@Service
@Component
public interface GoodsService {
    //返回所有类别的String数组
    public CategoriesResponse getAllCategories();

    //根据word搜索商品，返回商品id的number数组
    public SearchGoodsResponse searchGoods(String word);

    //count为返回热门商品的数量上限，返回热门商品id的数组
    public SearchGoodsResponse getPopularGoods(int count);

    //根据商品id，返回商品概要信息
    public GoodsGeneralResponse getGoodsGeneral(int id);

    //根据分类，返回商品id数组
    public CategoryGoodsResponse getGoodsByCategory(String category);

    //返回count数量上限的热门搜索关键词
    public PopularWordResponse getPopularWords(int count);

    //根据商品id，返回商品详情
    public GoodsDetailResponse getGoodsDetail(int id);

    //返回商品库存
    public int getStorageCount(int id);
}

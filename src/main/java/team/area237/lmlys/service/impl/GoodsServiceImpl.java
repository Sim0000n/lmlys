package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.area237.lmlys.dao.GoodsDao;
import team.area237.lmlys.model.response.*;
import team.area237.lmlys.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    //返回所有类别的String数组
    @Override
    public CategoriesResponse getAllCategories(){
        CategoriesResponse categoriesResponse = new CategoriesResponse();
        List<String> list = goodsDao.categorySelect();
        String[] array=list.toArray(new String[list.size()]);
        categoriesResponse.setCategories(array);
        return categoriesResponse;
    }

    //根据word搜索商品，返回商品id的number数组
    public SearchGoodsResponse searchGoods(String word){
        SearchGoodsResponse searchGoodsResponse = new SearchGoodsResponse();
        List<Integer> nums = goodsDao.idsSelectByWord(word);
        int[] IDs = nums.stream().mapToInt(Integer::valueOf).toArray();
        searchGoodsResponse.setGoodsID(IDs);
        return searchGoodsResponse;
    }

    //count为返回热门商品的数量上限，返回热门商品id的数组
    public SearchGoodsResponse getPopularGoods(int count){
        SearchGoodsResponse searchGoodsResponse = new SearchGoodsResponse();
        List<Integer> nums = goodsDao.idsSelectByCount(count);
        int[] IDs = nums.stream().mapToInt(Integer::valueOf).toArray();
        searchGoodsResponse.setGoodsID(IDs);
        return searchGoodsResponse;
    }
    //根据商品id，返回商品概要信息
    public GoodsGeneralResponse getGoodsGeneral(int id){
        return goodsDao.selectById(id);
    }


    //根据分类，返回商品id数组
    public CategoryGoodsResponse getGoodsByCategory(String category){
        CategoryGoodsResponse categoryGoodsResponse = new CategoryGoodsResponse();
        List<Integer> nums = goodsDao.idsSelectByCategory(category);
        int[] IDs = nums.stream().mapToInt(Integer::valueOf).toArray();
        categoryGoodsResponse.setId(IDs);
        return categoryGoodsResponse;
    }

    //返回count数量上限的热门搜索关键词
    public PopularWordResponse getPopularWords(int count){
        PopularWordResponse popularWordResponse = new PopularWordResponse();
        List<String> list = goodsDao.wordSelectOrderByFrequency(count);
        String[] array=list.toArray(new String[list.size()]);
        popularWordResponse.setWords(array);
        return popularWordResponse;
    }
}

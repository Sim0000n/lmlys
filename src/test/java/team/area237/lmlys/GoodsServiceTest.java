package team.area237.lmlys;

import org.springframework.beans.factory.annotation.Autowired;
import team.area237.lmlys.model.response.*;
import team.area237.lmlys.service.GoodsService;

public class GoodsServiceTest extends LmlysApplicationTests {
    @Autowired
    private GoodsService goodsService;
    @Override
    public void contextLoads() {
        CategoriesResponse categoriesResponse=goodsService.getAllCategories();
        //返回所有类别的String数组
        String s[]=categoriesResponse.getCategories();
        for (int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }

        //根据word搜索商品，返回商品id的number数组
        SearchGoodsResponse searchGoodsResponse=goodsService.searchGoods("test");
        int numbers[]=searchGoodsResponse.getGoodsID();
        for (int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
        //count为返回热门商品的数量上限，返回热门商品id的数组
        int nums[]=goodsService.getPopularGoods(1).getGoodsID();
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        //根据商品id，返回商品概要信息
        GoodsGeneralResponse goodsGeneralResponse= goodsService.getGoodsGeneral(1);

        System.out.println(goodsGeneralResponse.getImg());
        System.out.println(goodsGeneralResponse.getPrice());
        System.out.println(goodsGeneralResponse.getTitle());
        //根据分类，返回商品id数组
        CategoryGoodsResponse categoryGoodsResponse= goodsService.getGoodsByCategory("图书音像");
        int a[]=categoryGoodsResponse.getId();
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        //返回count数量上限的热门搜索关键词
        PopularWordResponse popularWordResponse = goodsService.getPopularWords(1);
        String b[]=popularWordResponse.getWords();
        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}

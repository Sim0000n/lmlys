package team.area237.lmlys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import team.area237.lmlys.model.entity.Good;
import team.area237.lmlys.service.GoodsService;
import team.area237.lmlys.utils.ResponseWrapper;

import static team.area237.lmlys.utils.ResponseStatus.OK;

@EnableWebMvc
@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/api/categories")
    ResponseWrapper getAllCategories() {
        return new ResponseWrapper(OK, goodsService.getAllCategories()) ;
    }

    @GetMapping("/api/search")
    ResponseWrapper searchGoods(@RequestParam("word") String word) {
        return new ResponseWrapper(OK, goodsService.searchGoods(word));
    }

    @GetMapping("/api/hot/goods")
    ResponseWrapper getPopularGoods(@RequestParam("count")int count) {
        return new ResponseWrapper(OK, goodsService.getPopularGoods(count));
    }

    @GetMapping("/api/goods/general")
    ResponseWrapper getGoodsGeneral(@RequestParam("id")int id){
        return new ResponseWrapper(OK, goodsService.getGoodsGeneral(id));
    }

    @GetMapping("/api/category/goods")
    ResponseWrapper getGoodsByCategory(@RequestParam("category")String category) {
        return new ResponseWrapper(OK, goodsService.getGoodsByCategory(category));
    }

    @GetMapping("/api/hot/search")
    ResponseWrapper getPopularWord(@RequestParam("count")int count) {
        return new ResponseWrapper(OK, goodsService.getPopularWords(count));
    }

    @GetMapping("/api/goods/other")
    ResponseWrapper getGoodsDetail(@RequestParam("id")int id) {
        return new ResponseWrapper(OK, goodsService.getGoodsDetail(id));
    }

    @GetMapping("/api/goods/storageCount")
    ResponseWrapper getStorageCount(@RequestParam("id")int id) {
        return new ResponseWrapper(OK, goodsService.getStorageCount(id));
    }
}

package team.area237.lmlys.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import team.area237.lmlys.model.request.NewGoodsToCartRequest;
import team.area237.lmlys.model.request.UpdateCartResquest;
import team.area237.lmlys.model.response.ShoppingCartCountResponse;
import team.area237.lmlys.model.response.ShoppingCartResponse;
import team.area237.lmlys.model.response.UploadCartResponse;
@Service
@Component
public interface ShoppingService {
    //返回用户购物车中的商品数量
    ShoppingCartCountResponse getGoodsNumberInCart(String username);

    //获取购物车内商品的信息
    ShoppingCartResponse getShoppingCart(String username);

    //上传当前用户的购物车信息
    UploadCartResponse uploadShoppingCart(String username, UpdateCartResquest updateCartResquest);

    //将新商品加入购物车
    UploadCartResponse addNewGoodsToCart(String username, NewGoodsToCartRequest newGoodsToCartRequest);
}

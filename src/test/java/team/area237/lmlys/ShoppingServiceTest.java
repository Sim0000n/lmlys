package team.area237.lmlys;

import org.springframework.beans.factory.annotation.Autowired;
import team.area237.lmlys.model.entity.Cart;
import team.area237.lmlys.model.request.NewGoodsToCartRequest;
import team.area237.lmlys.model.request.UpdateCartRequest;
import team.area237.lmlys.model.response.ShoppingCartCountResponse;
import team.area237.lmlys.model.response.ShoppingCartResponse;
import team.area237.lmlys.model.response.UploadCartResponse;
import team.area237.lmlys.service.ShoppingService;

import java.util.ArrayList;
import java.util.List;

public class ShoppingServiceTest extends LmlysApplicationTests {
    @Autowired
    private ShoppingService shoppingService;
    @Override
    public void contextLoads() {
        //返回用户购物车中的商品数量
        ShoppingCartCountResponse shoppingCartCountResponse = shoppingService.getGoodsNumberInCart("sb");
        System.out.println(shoppingCartCountResponse.getNumber());
        //获取购物车内商品的信息
        ShoppingCartResponse shoppingCartResponse=shoppingService.getShoppingCart("Sim0000n");
        Cart[] carts=shoppingCartResponse.getCarts();
        for(int i=0;i<carts.length;i++){
            System.out.println(carts[i].getGoodsId());
        }
        //上传当前用户的购物车信息
        List<UpdateCartRequest> updateCartRequests=new ArrayList<>();
        for(int i=1;i<5;i++){
            UpdateCartRequest updateCartRequest=new UpdateCartRequest();
            updateCartRequest.setId(i);
            updateCartRequest.setCount(i);
            updateCartRequests.add(updateCartRequest);
        }
        UpdateCartRequest[] updateCartRequests1=updateCartRequests.toArray(new UpdateCartRequest[updateCartRequests.size()]);
        UploadCartResponse uploadCartResponse=shoppingService.uploadShoppingCart("testName",updateCartRequests1);
        System.out.println(uploadCartResponse.getStatus());
        //将新商品加入购物车
        NewGoodsToCartRequest newGoodsToCartRequest=new NewGoodsToCartRequest();
        newGoodsToCartRequest.setId(6);
        newGoodsToCartRequest.setCount(5);
        UploadCartResponse uploadCartResponse1=shoppingService.addNewGoodsToCart("testName",newGoodsToCartRequest);
        System.out.println(uploadCartResponse1.getStatus());
    }
}

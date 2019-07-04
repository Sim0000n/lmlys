package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.area237.lmlys.dao.CartDao;
import team.area237.lmlys.model.entity.Cart;
import team.area237.lmlys.model.request.NewGoodsToCartRequest;
import team.area237.lmlys.model.request.UpdateCartResquest;
import team.area237.lmlys.model.response.ShoppingCartCountResponse;
import team.area237.lmlys.model.response.ShoppingCartResponse;
import team.area237.lmlys.model.response.UploadCartResponse;
import team.area237.lmlys.service.ShoppingService;

import java.util.List;

@Service
@Transactional
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private CartDao cartDao;
    //返回用户购物车中的商品数量
    @Override
    public ShoppingCartCountResponse getGoodsNumberInCart(String username) {
        ShoppingCartCountResponse shoppingCartCountResponse = new ShoppingCartCountResponse();
        Integer n =cartDao.amountSelectByUsername(username);
        int num;
        if(n==null){
            num=0;
        }else {
            num=n;
        }
        shoppingCartCountResponse.setNumber(num);
        return shoppingCartCountResponse;
    }

    //获取购物车内商品的信息
    @Override
    public ShoppingCartResponse getShoppingCart(String username) {
        ShoppingCartResponse shoppingCartResponse=new ShoppingCartResponse();
        List<Cart> list=cartDao.InfoSelectByUsername(username);
        Cart[] carts =list.toArray(new Cart[list.size()]);
        shoppingCartResponse.setCarts(carts);
        return shoppingCartResponse;
    }

    //上传当前用户的购物车信息
    @Override
    public UploadCartResponse uploadShoppingCart(String username, UpdateCartResquest[] updateCartResquests) {
        UploadCartResponse uploadCartResponse=new UploadCartResponse();
        cartDao.deleteByUsername(username);
        for (int i = 0; i < updateCartResquests.length - 1; i++) {
            for (int j = updateCartResquests.length - 1; j > i; j--) {
                if (updateCartResquests[i].getId()==updateCartResquests[j].getId()) {
                    uploadCartResponse.setStatus(1);
                    return uploadCartResponse;
                }
            }
        }
        int r=cartDao.insertAllByUsername(username, updateCartResquests);
        if(r>0){
            uploadCartResponse.setStatus(0);
        }else {
            uploadCartResponse.setStatus(1);
        }
        return uploadCartResponse;
    }

    //将新商品加入购物车
    @Override
    public UploadCartResponse addNewGoodsToCart(String username, NewGoodsToCartRequest newGoodsToCartRequest) {
        UploadCartResponse uploadCartResponse=new UploadCartResponse();
        int r=cartDao.insertByUsername(username,newGoodsToCartRequest.getId(),newGoodsToCartRequest.getCount());
        if(r>0){
            uploadCartResponse.setStatus(0);
        }else {
            uploadCartResponse.setStatus(1);
        }
        return uploadCartResponse;
    }
}

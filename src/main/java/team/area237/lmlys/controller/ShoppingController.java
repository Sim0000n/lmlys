package team.area237.lmlys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import team.area237.lmlys.model.request.NewGoodsToCartRequest;
import team.area237.lmlys.model.request.UpdateCartResquest;
import team.area237.lmlys.service.ShoppingService;
import team.area237.lmlys.utils.ResponseStatus;
import team.area237.lmlys.utils.ResponseWrapper;

import javax.servlet.http.HttpSession;

@EnableWebMvc
@RestController
public class ShoppingController {
    @Autowired
    ShoppingService shoppingService;

    @GetMapping("/api/shoppingCart/count")
    ResponseWrapper getNumberOfGoodsInCart(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, shoppingService.getGoodsNumberInCart(username).getNumber());
    }

    @GetMapping("/api/shoppingCart")
    ResponseWrapper getCarts(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, shoppingService.getShoppingCart(username));
    }

    @PostMapping("/api/shoppingCart")
    ResponseWrapper uploadCarts(@RequestBody UpdateCartResquest updateCartResquest, HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, shoppingService.uploadShoppingCart(username, updateCartResquest).getStatus());
    }

    @PostMapping("/api/shoppingCart/new")
    ResponseWrapper addNewGoodsToCart(@RequestBody NewGoodsToCartRequest newGoodsToCartRequest, HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK,shoppingService.addNewGoodsToCart(username, newGoodsToCartRequest).getStatus());
    }


}

package team.area237.lmlys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.request.UploadUserDataRequest;
import team.area237.lmlys.service.UserService;
import team.area237.lmlys.utils.ResponseStatus;
import team.area237.lmlys.utils.ResponseWrapper;

import javax.servlet.http.HttpSession;

@EnableWebMvc
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/userdata")
    ResponseWrapper getUserData(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, userService.getUserData(username));
    }

    @PostMapping("/api/userdata")
    ResponseWrapper uploadUserData(@RequestBody UploadUserDataRequest uploadUserDataRequest, HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, userService.uploadUserData(uploadUserDataRequest, username));
    }

    @GetMapping("/api/address")
    ResponseWrapper getUserAddress(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, userService.getUserAddress(username));
    }

    @PostMapping("/api/address")
    ResponseWrapper uploadUserAddress(@RequestBody UploadUserAddressRequest uploadUserAddressRequest, HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, userService.UploadUserAddress(uploadUserAddressRequest, username));
    }

    @GetMapping("/api/city")
    ResponseWrapper getCityAndProvince() {
        return new ResponseWrapper(ResponseStatus.OK, userService.getProvinceAndCity());
    }

    @GetMapping("/api/finishBill")
    ResponseWrapper finishBill(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, userService.finishBill(username));
    }

    @GetMapping("/api/user/orders")
    ResponseWrapper getAllOrders(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, userService.getAllOrders(username));
    }

    @GetMapping("/api/user/order")
    ResponseWrapper getOrder(@RequestParam("id")int id, HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, userService.getOrder(id));
    }
}

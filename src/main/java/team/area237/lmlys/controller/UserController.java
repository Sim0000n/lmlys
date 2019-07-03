package team.area237.lmlys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.request.UploadUserDataResquest;
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
    ResponseWrapper uploadUserData(@RequestBody UploadUserDataResquest uploadUserDataResquest, HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, userService.uploadUserData(uploadUserDataResquest, username));
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
}

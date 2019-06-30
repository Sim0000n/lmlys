package team.area237.lmlys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import team.area237.lmlys.model.request.LoginRequest;
import team.area237.lmlys.model.response.LoginResponse;
import team.area237.lmlys.model.response.LogoutResponse;
import team.area237.lmlys.service.LoginService;
import team.area237.lmlys.utils.ResponseWrapper;


import javax.servlet.http.HttpSession;

import static team.area237.lmlys.utils.ResponseStatus.OK;

@EnableWebMvc
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/api/login")
    public ResponseWrapper login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        System.out.println("login controller");
        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String ph = "^[1][34578]\\d{9}$";
        LoginResponse loginResponse;
        String loginName = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        //user name login type = 0, email login type = 1, mobile login type = 2
        if(loginName.matches(em)){
            loginResponse = loginService.login(loginName, password, 1);
        } else if(loginName.matches(ph)) {
            loginResponse = loginService.login(loginName, password, 2);
        } else {
            loginResponse = loginService.login(loginName, password, 0);
        }
        if(loginResponse.getStatus() == 0)
            session.setAttribute("username", loginResponse.getUsername());
        return new ResponseWrapper(OK, "success", loginResponse);
    }

    @GetMapping("/api/login")
    public ResponseWrapper isLogin(HttpSession session) {
        Object username = session.getAttribute("username");
        LoginResponse loginResponse = new LoginResponse();
        if(username != null) {
            loginResponse.setStatus(0);
            loginResponse.setUsername((String)username);
        } else {
            loginResponse.setStatus(1);
        }
        return new ResponseWrapper(OK, loginResponse);
    }

    @GetMapping("/api/logout")
    public ResponseWrapper logout(HttpSession session) {
        LogoutResponse logoutResponse = new LogoutResponse();
        session.removeAttribute("username");
        if(session.getAttribute("username") == null)
            logoutResponse.setStatus(0);
        else
            logoutResponse.setStatus(1);
        return new ResponseWrapper(OK, logoutResponse);
    }

}

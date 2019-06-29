package team.area237.lmlys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.area237.lmlys.model.request.RegisterRequest;
import team.area237.lmlys.model.response.RegisterResponse;
import team.area237.lmlys.service.RegisterService;
import team.area237.lmlys.utils.ResponseWrapper;

import javax.servlet.http.HttpSession;

import static team.area237.lmlys.utils.ResponseStatus.OK;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    ResponseWrapper register(@RequestBody RegisterRequest registerRequest, HttpSession session) {
        RegisterResponse registerResponse;
        registerResponse = registerService.register(registerRequest);
        if(registerResponse.getStatus() == 0)
            session.setAttribute("username", registerResponse.getUsername());
        return new ResponseWrapper(OK, registerResponse);
    }

    @GetMapping("/exist/username")
    ResponseWrapper existUsername(@RequestParam("username") String name){
        int exist = registerService.existUsername(name);
        return new ResponseWrapper(OK,exist);
    }
}

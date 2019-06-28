package team.area237.lmlys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("/posts/register")
    ResponseWrapper register(@RequestBody RegisterRequest registerRequest, HttpSession session) {
        RegisterResponse registerResponse;
        registerResponse = registerService.register(registerRequest);
        if(registerResponse.getStatus() == 0)
            session.setAttribute("username", registerResponse.getUsername());
        return new ResponseWrapper(OK, registerResponse);
    }

    @RequestMapping("/posts/exist/username")
    ResponseWrapper existUsername(@RequestBody RegisterRequest registerRequest){
        int exist = registerService.existUsername(registerRequest.getUsername());
        return new ResponseWrapper(OK,exist);
    }
}

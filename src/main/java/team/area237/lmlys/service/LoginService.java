package team.area237.lmlys.service;

import org.springframework.stereotype.Component;
import team.area237.lmlys.model.response.LoginResponse;
@Component
public interface LoginService {
    //type = 0 user name login, type = 1 email login, type = 2 mobile login
    LoginResponse login(String loginName, String password, int type);
}

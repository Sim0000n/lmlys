package team.area237.lmlys.service;

import org.springframework.stereotype.Component;
import team.area237.lmlys.model.response.LoginResponse;

@Component
public interface LoginService {
    public LoginResponse login(String loginName, String password, int type);
}

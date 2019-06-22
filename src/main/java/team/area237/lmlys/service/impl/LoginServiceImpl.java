package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.area237.lmlys.dao.LoginDao;
import team.area237.lmlys.model.response.LoginResponse;
import team.area237.lmlys.service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public LoginResponse login(String loginName, String password, int type) {
        LoginResponse loginResponse = null;
        if(type == 0) {
            loginResponse = loginDao.loginByUserName(loginName, password);
        } else if(type == 1) {
            loginResponse = loginDao.loginByEmail(loginName, password);
        } else {
            loginResponse = loginDao.loginByMobile(loginName, password);
        }
        return loginResponse;
    }
}

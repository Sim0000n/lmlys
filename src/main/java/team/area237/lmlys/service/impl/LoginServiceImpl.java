package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.area237.lmlys.dao.LoginDao;
import team.area237.lmlys.model.response.LoginResponse;
import team.area237.lmlys.service.LoginService;
import team.area237.lmlys.utils.Aes;

//type = 0 user name login, type = 1 email login, type = 2 mobile login
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public LoginResponse login(String loginName, String password, int type){
        //AES加密password
        try {
            password = Aes.encryptAes(password);
        }catch (Exception e){
            //待处理
        }
        LoginResponse loginResponse = null;
        if(type == 0) {
            loginResponse = loginDao.loginByColumn("username",loginName, password);
        } else if(type == 1) {
            loginResponse = loginDao.loginByColumn("email",loginName, password);
        } else {
            loginResponse = loginDao.loginByColumn("mobile",loginName, password);
        }
        return loginResponse;
    }
}

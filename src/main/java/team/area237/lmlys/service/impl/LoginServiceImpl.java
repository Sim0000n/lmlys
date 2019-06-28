package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.area237.lmlys.dao.LoginDao;
import team.area237.lmlys.model.entity.Customer;
import team.area237.lmlys.model.response.LoginResponse;
import team.area237.lmlys.service.LoginService;
import team.area237.lmlys.utils.Aes;

//type = 0 user name login, type = 1 email login, type = 2 mobile login
@Service
@Transactional
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
        Customer user = null;
        if(type == 0) {
            user = loginDao.loginByColumn("username",loginName);
        } else if(type == 1) {
            user = loginDao.loginByColumn("email",loginName);
        } else {
            user = loginDao.loginByColumn("mobile",loginName);
        }
        LoginResponse loginResponse = new LoginResponse();
        if(user == null){
            loginResponse.setStatus(2);
        }else if(user.getPassword().equals(password)){
            loginResponse.setStatus(0);
        }else{
            loginResponse.setStatus(1);
        }
        return loginResponse;
    }
}

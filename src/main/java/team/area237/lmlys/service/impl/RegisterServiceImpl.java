package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.area237.lmlys.dao.RegisterDao;
import team.area237.lmlys.model.request.RegisterRequest;
import team.area237.lmlys.model.response.ExistUsernameResponse;
import team.area237.lmlys.model.response.RegisterResponse;
import team.area237.lmlys.service.RegisterService;
import team.area237.lmlys.utils.Aes;
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;
    //如果注册成功，需要将用户写入数据库
    @Override
    public RegisterResponse register(RegisterRequest registerRequest){
        RegisterResponse registerResponse = new RegisterResponse();
        String un = "^\\w*[A-z]+\\w*$";
        if(!registerRequest.getUsername().matches(un)) {
            registerResponse.setStatus(1);
            return registerResponse;
        }
        String password = "000000";
        try{
            password = Aes.encryptAes(registerRequest.getPassword());
        }catch (Exception e){
            registerResponse.setStatus(1);
            return registerResponse;
        }
        int i = registerDao.addUser(registerRequest.getUsername(),password);
        if(i == 0){
            registerResponse.setStatus(1);
        } else {
            registerResponse.setStatus(0);
            registerResponse.setUsername(registerRequest.getUsername());
        }
        return registerResponse;
    }

    //注册时检查输入的用户名是否已经存在，存在返回0，不存在返回1
    @Override
    public ExistUsernameResponse existUsername(String username){
        ExistUsernameResponse existUsernameResponse = new ExistUsernameResponse();
        String str = registerDao.selectByUsername(username);
        if(str == null){
            existUsernameResponse.setStatus(1);
        } else {
            existUsernameResponse.setStatus(0);
        }
        return existUsernameResponse;
    }

}

package team.area237.lmlys.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import team.area237.lmlys.model.request.RegisterRequest;
import team.area237.lmlys.model.response.RegisterResponse;

@Service
@Component
public interface RegisterService {
    //如果注册成功，需要将用户写入数据库
    RegisterResponse register(RegisterRequest registerRequest);

    //注册时检查输入的用户名是否已经存在，存在返回0，不存在返回1
    int existUsername(String username);
}

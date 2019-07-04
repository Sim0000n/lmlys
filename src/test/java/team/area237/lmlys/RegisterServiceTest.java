package team.area237.lmlys;

import org.springframework.beans.factory.annotation.Autowired;
import team.area237.lmlys.model.request.RegisterRequest;
import team.area237.lmlys.model.response.RegisterResponse;
import team.area237.lmlys.service.RegisterService;

public class RegisterServiceTest extends LmlysApplicationTests {
    @Autowired
    private RegisterService registerService;
    @Override
    public void contextLoads() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setPassword("123456");
        registerRequest.setUsername("testName");
        //注册时检查输入的用户名是否已经存在，存在返回0，不存在返回1
        int i = registerService.existUsername(registerRequest.getUsername()).getStatus();
        System.out.println(i);
        //如果注册成功，需要将用户写入数据库
        registerService.register(registerRequest);

    }
}

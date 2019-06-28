package team.area237.lmlys;

import org.springframework.beans.factory.annotation.Autowired;
import team.area237.lmlys.model.response.LoginResponse;
import team.area237.lmlys.service.LoginService;

public class LoginServiceTest extends LmlysApplicationTests {
    @Autowired
    private LoginService loginService;
    @Override
    public void contextLoads() {
        LoginResponse loginResponse = loginService.login("oldbra","123",0);
        if(loginResponse.getStatus()==1){
            System.out.println("密码错误");
        }else if(loginResponse.getStatus()==0){
            System.out.println("success");
        }else if(loginResponse.getStatus()==2){
            System.out.println("no user");
        }
    }
}

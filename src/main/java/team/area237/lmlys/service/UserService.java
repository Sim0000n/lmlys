package team.area237.lmlys.service;

import org.springframework.stereotype.Component;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.request.UploadUserDataResquest;
import team.area237.lmlys.model.response.GetUserAddressResponse;
import team.area237.lmlys.model.response.UserDataResponse;

@Component
public interface UserService {
    //获得用户的绑定数据
    UserDataResponse getUserData(String username);

    //上传用户绑定信息，成功返回0，失败返回1
    int uploadUserData(UploadUserDataResquest uploadUserDataResquest, String username);

    //获取用户地址信息
    GetUserAddressResponse getUserAddress(String username);

    //上传用户地址信息
    int UploadUserAddress(UploadUserAddressRequest uploadUserAddressRequest,String username);
}

package team.area237.lmlys.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.request.UploadUserDataResquest;
import team.area237.lmlys.model.response.*;

@Service
@Component
public interface UserService {
    //获得用户的绑定数据
    public UserDataResponse getUserData(String username);

    //上传用户绑定信息，成功返回0，失败返回1
    public int uploadUserData(UploadUserDataResquest uploadUserDataResquest, String username);

    //获取用户地址信息
    public GetUserAddressResponse getUserAddress(String username);

    //上传用户地址信息
    public int UploadUserAddress(UploadUserAddressRequest uploadUserAddressRequest,String username);

    //返回所有合法的省市
    public ProvinceCityResponse getProvinceAndCity();

    //结账,成功返回0，失败返回1
    public FinishBillResponse finishBill(String username);

    //返回用户的所有订单id,按修改时间排序，新的在前，旧的在后
    public int[] getAllOrders(String username);

    //返回订单详细信息
    public GetOrderResponse getOrder(int id);
}

package team.area237.lmlys;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.request.UploadUserDataRequest;
import team.area237.lmlys.model.response.*;
import team.area237.lmlys.service.UserService;

import static org.hamcrest.Matchers.*;

public class UserServiceTest extends LmlysApplicationTests {
    @Autowired
    private UserService userService;
    @Override
    public void contextLoads() {

    }
    @Test
    public void getUserData(){
        UserDataResponse userDataResponse=userService.getUserData("testName");
        Assert.assertThat(userDataResponse.getPhone(),nullValue());
        Assert.assertThat(userDataResponse.getEmail(),nullValue());
        Assert.assertThat(userDataResponse,notNullValue());
    }
    @Test
    public void uploadUserData(){
        UploadUserDataRequest uploadUserDataRequest =new UploadUserDataRequest();
        int i=userService.uploadUserData(uploadUserDataRequest,"testName");
        Assert.assertThat(i,is(1));
    }
    @Test
    public void GetAddress(){
        GetUserAddressResponse getUserAddressResponse=userService.getUserAddress("testName");
        if(getUserAddressResponse.isEmpty())return;
        System.out.println(getUserAddressResponse.getProvince()
                +getUserAddressResponse.getCity()+getUserAddressResponse.getHome());
    }

    @Test
    public void uploadAddress(){
        UploadUserAddressRequest uploadUserAddressRequest=new UploadUserAddressRequest();
        uploadUserAddressRequest.setEmpty(false);
        uploadUserAddressRequest.setProvince("湖北省");
        uploadUserAddressRequest.setCity("武汉市");
        uploadUserAddressRequest.setHome("默认街道");
        int i=userService.UploadUserAddress(uploadUserAddressRequest,"testName");
        Assert.assertThat(i,is(0));
    }
    @Test
    public void getAllAddress(){
        ProvinceCityResponse provinceCityResponse=userService.getProvinceAndCity();
        int num=0;
        for(int i=0;i<provinceCityResponse.getProvinces().length;i++){
            num+=provinceCityResponse.getProvinces()[i].getCity().length;
        }
        Assert.assertThat(num,greaterThan(293));
    }
    @Test
    public void finishBill(){
       FinishBillResponse finishBillResponse=userService.finishBill("testName");
       System.out.println(finishBillResponse.getResult());
    }
//    @Test
//    public void getOrder(){
//        int[] Ids=userService.getAllOrders("sb");
//        Assert.assertThat(Ids.length,greaterThan(0));
//        System.out.println(Ids[0]);
//        GetOrderResponse getOrderResponse=userService.getOrder(Ids[0]);
//        System.out.println(getOrderResponse.getState());
//        System.out.println(getOrderResponse.getGoodsTitle());
//    }
    
}

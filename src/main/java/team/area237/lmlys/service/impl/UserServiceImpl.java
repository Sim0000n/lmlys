package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.area237.lmlys.dao.RegisterDao;
import team.area237.lmlys.model.entity.Province;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.request.UploadUserDataResquest;
import team.area237.lmlys.model.response.*;
import team.area237.lmlys.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private RegisterDao registerDao;
    @Override
    public UserDataResponse getUserData(String username) {
        UserDataResponse userDataResponse=registerDao.dataSelectByUsername(username);
        if(userDataResponse==null){
            userDataResponse=new UserDataResponse();
        }
        return userDataResponse;
    }

    @Override
    public int uploadUserData(UploadUserDataResquest uploadUserDataResquest, String username) {
        String email = uploadUserDataResquest.getEmail();
        String phone=uploadUserDataResquest.getPhone();
        if(email==null&&phone==null){
            return 1;
        }else if(email==null){
            int re=registerDao.insertPhoneByUsername(username,phone);
            if(re>0)return 0;
        }else if(phone==null){
            int re=registerDao.insertEmailByUsername(username,email);
            if(re>0)return 0;
        }else {
            int re=registerDao.insertBothByUsername(username,phone,email);
            if(re>0)return 0;
        }
        return 1;
    }

    @Override
    public GetUserAddressResponse getUserAddress(String username) {
        GetUserAddressResponse getUserAddressResponse=registerDao.selectAddressByUsername(username);
        if(getUserAddressResponse==null){
            getUserAddressResponse=new GetUserAddressResponse();
            getUserAddressResponse.setEmpty(true);
            return getUserAddressResponse;
        }
        String str1=getUserAddressResponse.getCity();
        String str2=getUserAddressResponse.getHome();
        String str3=getUserAddressResponse.getProvince();
        if(str1==null||str2==null||str3==null)getUserAddressResponse.setEmpty(true);
        return getUserAddressResponse;
    }

    @Override
    public int UploadUserAddress(UploadUserAddressRequest uploadUserAddressRequest, String username) {
        if(uploadUserAddressRequest.isEmpty()==true)return 1;
        int re=registerDao.insertAddressByUsername(username,uploadUserAddressRequest);
        if(re>0)return 0;
        return 1;
    }

    @Override
    public ProvinceCityResponse getProvinceAndCity(){
        ProvinceCityResponse provinceCityResponse=new ProvinceCityResponse();
        List<Province> provinces=new ArrayList<>();
        List<String> list=registerDao.selectProvince();
        int l=list.size();
        for(int i=0;i<l;i++){
            Province province=new Province();
            province.setProvinceName(list.get(i));
            List<String> cities=registerDao.citySelectByProvince(list.get(i));
            province.setCity(cities.toArray(new String[cities.size()]));
            provinces.add(province);
        }
        Province[] provinces1=provinces.toArray(new Province[provinces.size()]);
        provinceCityResponse.setProvinces(provinces1);
        return provinceCityResponse;
    }

    @Override
    public int[] getAllOrders(String username){
        List<Integer> list=registerDao.selectOrderByUsername(username);
        int[] re=list.stream().mapToInt(Integer::valueOf).toArray();
        return re;
    }
    @Override
    public GetOrderResponse getOrder(int id){
        GetOrderResponse getOrderResponse=registerDao.selectOrderById(id);
        return getOrderResponse;
    }

    @Override
    public FinishBillResponse finishBill(String username) {
        return null;
    }
}

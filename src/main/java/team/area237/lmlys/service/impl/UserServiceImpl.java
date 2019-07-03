package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.area237.lmlys.dao.RegisterDao;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.request.UploadUserDataResquest;
import team.area237.lmlys.model.response.GetUserAddressResponse;
import team.area237.lmlys.model.response.UserDataResponse;
import team.area237.lmlys.service.UserService;
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
            int re=registerDao.insertPhoneByUsername(username);
            if(re>0)return 0;
        }else if(phone==null){
            int re=registerDao.insertEmailByUsername(username);
            if(re>0)return 0;
        }else {
            int re=registerDao.insertBothByUsername(username);
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
}
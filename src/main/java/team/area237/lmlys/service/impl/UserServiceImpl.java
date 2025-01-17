package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.area237.lmlys.dao.RegisterDao;
import team.area237.lmlys.model.entity.Cart;
import team.area237.lmlys.model.entity.Province;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.request.UploadUserDataRequest;
import team.area237.lmlys.model.response.*;
import team.area237.lmlys.service.UserService;

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
    public int uploadUserData(UploadUserDataRequest uploadUserDataRequest, String username) {
        String email = uploadUserDataRequest.getEmail();
        String phone= uploadUserDataRequest.getPhone();
        if(email!=null && email.length()==0)email=null;
        if(phone!=null && phone.length()==0)phone=null;
        int re=registerDao.updateBothByUsername(username,phone,email);
        if(re>0)return 0;
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
        getUserAddressResponse.setEmpty(false);
        String str1=getUserAddressResponse.getCity();
        String str2=getUserAddressResponse.getHome();
        String str3=getUserAddressResponse.getProvince();
        if(str1==null||str2==null||str3==null)getUserAddressResponse.setEmpty(true);
        return getUserAddressResponse;
    }

    @Override
    public int UploadUserAddress(UploadUserAddressRequest uploadUserAddressRequest, String username) {
        if(uploadUserAddressRequest.isEmpty())return 1;
        String res=registerDao.selectReciver(username);
        int re=0;
        if(res!=null){
            re=registerDao.updateAddressByUsername(username,uploadUserAddressRequest);
        }else {
            re=registerDao.insertAddressByUsername(username,uploadUserAddressRequest);
        }
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

    //结账,成功返回0，库存不足返回1
    @Override
    public FinishBillResponse finishBill(String username) {
        FinishBillResponse finishBillResponse=new FinishBillResponse();
        List<Integer> soldOut=new ArrayList<>();
        List<Cart> list=registerDao.selectStockByUsername(username);
        for(int i=0;i<list.size();i++){
            int remain=list.get(i).getStock()-list.get(i).getCount();
            if(remain<0){
                soldOut.add(list.get(i).getGoodsId());
            }else {
                list.get(i).setStock(remain);
            }
        }
        if(list.size()==0||list==null){
            finishBillResponse.setResult(2);
            return finishBillResponse;
        }
        if(soldOut.size()>0){
            finishBillResponse.setResult(1);
            finishBillResponse.setSoldUpGoods(soldOut.stream().mapToInt(Integer::valueOf).toArray());
            return finishBillResponse;
        }
        int res=registerDao.cartToOrder(username);
        if(res>0){
            Cart[] carts=list.toArray(new Cart[list.size()]);
            //剩余库存
            int re=registerDao.updateStockByGoodsId(carts);
            if(re==list.size()){
                finishBillResponse.setResult(0);
                return finishBillResponse;
            }
        }
        finishBillResponse.setResult(2);
        return finishBillResponse;
    }
}

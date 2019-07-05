package team.area237.lmlys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.area237.lmlys.model.entity.Cart;
import team.area237.lmlys.model.request.RegisterRequest;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.response.GetOrderResponse;
import team.area237.lmlys.model.response.GetUserAddressResponse;
import team.area237.lmlys.model.response.UserDataResponse;

import java.util.List;

@Mapper
@Component
public interface RegisterDao {
    String selectByUsername(@Param("username")String username);
    int addUser(@Param("username")String username, @Param("password")String password);
    //获得用户的email和phone
    UserDataResponse dataSelectByUsername(@Param("username")String username);
    //上传用户phone
    int insertPhoneByUsername(@Param("username")String username,@Param("phone")String phone);
    //上传用户email
    int insertEmailByUsername(@Param("username")String username,@Param("email")String email);
    //同时插入phone和email
    int insertBothByUsername(@Param("username")String username,@Param("phone")String phone,@Param("email")String email);

    int updateBothByUsername(@Param("username")String username,@Param("phone")String phone,@Param("email")String email);
    //获取用户地址信息
    GetUserAddressResponse selectAddressByUsername(@Param("username")String username);
    //上传用户地址信息
    int insertAddressByUsername(@Param("username")String username, @Param("address")UploadUserAddressRequest uploadUserAddressRequest);
    //只返回省名
    List<String> selectProvince();
    //返回市名
    List<String> citySelectByProvince(@Param("province")String province);

    //检查购物车库存,返回goodsId和stock,count
    List<Cart> selectStockByUsername(@Param("username")String username);
    //生成订单
    int cartToOrder(@Param("username")String username);
    //返回用户订单号，按时间排序,新的在前，旧的在后
    List<Integer> selectOrderByUsername(@Param("username")String username);
    //根据订单ID返回商品ID，标题，数量，订单状态，状态最后修改时间
    GetOrderResponse selectOrderById(@Param("id")int id);
    //更新库存
    int updateStockByGoodsId(@Param("array")Cart[] carts);
}

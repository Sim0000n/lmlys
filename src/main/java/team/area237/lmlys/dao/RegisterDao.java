package team.area237.lmlys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.area237.lmlys.model.request.RegisterRequest;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
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
    //获取用户地址信息
    GetUserAddressResponse selectAddressByUsername(@Param("username")String username);

    //上传用户地址信息
    int insertAddressByUsername(@Param("usersname")String username, @Param("address")UploadUserAddressRequest uploadUserAddressRequest);


    //只返回省名
    List<String> selectProvince();
    //返回市名
    List<String> citySelectByProvince(@Param("province")String province);
    }

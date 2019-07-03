package team.area237.lmlys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.area237.lmlys.model.request.RegisterRequest;
import team.area237.lmlys.model.request.UploadUserAddressRequest;
import team.area237.lmlys.model.response.GetUserAddressResponse;
import team.area237.lmlys.model.response.UserDataResponse;

@Mapper
@Component
public interface RegisterDao {
    String selectByUsername(@Param("username")String username);
    int addUser(@Param("username")String username, @Param("password")String password);

    //获得用户的email和phone
    UserDataResponse dataSelectByUsername(@Param("username")String username);

    //上传用户phone
    int insertPhoneByUsername(@Param("username")String username);
    //上传用户email
    int insertEmailByUsername(@Param("username")String username);
    //同时插入phone和email
    int insertBothByUsername(@Param("username")String username);
    //获取用户地址信息
    GetUserAddressResponse selectAddressByUsername(@Param("username")String username);

    //上传用户地址信息
    int insertAddressByUsername(@Param("usersname")String username, @Param("address")UploadUserAddressRequest uploadUserAddressRequest);
}

package team.area237.lmlys.dao;

        import org.apache.ibatis.annotations.Param;
        import org.springframework.stereotype.Component;
        import team.area237.lmlys.model.response.LoginResponse;

@Component
public interface LoginDao {
    public LoginResponse loginByUserName(@Param("user_name")String userName, @Param("password")String password);
    public LoginResponse loginByEmail(@Param("email")String email, @Param("password")String password);
    public LoginResponse loginByMobile(@Param("mobile")String mobile, @Param("password")String password);
}

package team.area237.lmlys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.area237.lmlys.model.response.GetOrderResponse;

@Mapper
@Component
public interface ManagerDao {
    //所有订单ID
    int[] selectAllOrders();
    //根据订单ID返回商品ID，标题，数量，订单状态，状态最后修改时间
    GetOrderResponse selectOrderById(@Param("id")int id);
    //修改某一订单的状态
    int updateStatusById(@Param("id")int id,@Param("status")int status);
    //返回用户权限：1管理员，0普通用户
    int selectLevelByUsername(@Param("username")String username);
}

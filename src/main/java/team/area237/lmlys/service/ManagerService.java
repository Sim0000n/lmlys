package team.area237.lmlys.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import team.area237.lmlys.model.request.UpdateOrderStatusRequest;
import team.area237.lmlys.model.response.GetOrderResponse;
@Service
@Component
public interface ManagerService {
    //返回所有用户的所有订单
    public int[] getAllOrdersFromAllUsers();

    //返回该订单的所有信息
    public GetOrderResponse getOrderById(int id);

    //修改某一订单的状态
    public int updateOrderStatus(UpdateOrderStatusRequest updateOrderStatusRequest);

    //判断当前用户是不是管理员，是返回1，不是返回0
    public boolean isManager(String username);
}

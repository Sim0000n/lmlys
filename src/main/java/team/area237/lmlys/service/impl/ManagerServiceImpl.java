package team.area237.lmlys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.area237.lmlys.dao.ManagerDao;
import team.area237.lmlys.model.request.UpdateOrderStatusRequest;
import team.area237.lmlys.model.response.GetOrderResponse;
import team.area237.lmlys.service.ManagerService;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public int[] getAllOrdersFromAllUsers() {
        return managerDao.selectAllOrders();
    }

    @Override
    public GetOrderResponse getOrderById(int id) {
        return managerDao.selectOrderById(id);
    }

    @Override
    public int updateOrderStatus(UpdateOrderStatusRequest updateOrderStatusRequest) {
        String i = updateOrderStatusRequest.getStatus();
        int re=managerDao.updateStatusById(updateOrderStatusRequest.getId(),i);
        if(re>0)return 0;
        return 1;
    }

    @Override
    public boolean isManager(String username) {
        int re=managerDao.selectLevelByUsername(username);
        return re>0;
    }
}

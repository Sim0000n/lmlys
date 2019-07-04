package team.area237.lmlys;

import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import team.area237.lmlys.model.request.UpdateOrderStatusRequest;
import team.area237.lmlys.model.response.GetOrderResponse;
import team.area237.lmlys.service.ManagerService;

import static org.hamcrest.Matchers.*;
public class ManagerServiceTest extends LmlysApplicationTests {
    @Autowired
    private ManagerService managerService;
    @Test
    public void selectAllOrders(){
        int[] re=managerService.getAllOrdersFromAllUsers();
        for (int i:re) {
            System.out.println(re);
        }
    }
    @Test
    public void selectOrderById(){
        GetOrderResponse getOrderResponse=managerService.getOrderById(65);
        System.out.println(getOrderResponse.getGoodsTitle());
        System.out.println(getOrderResponse.getTime());
    }
    @Test
    public void updateStatusById(){
        UpdateOrderStatusRequest updateOrderStatusRequest=new UpdateOrderStatusRequest();
        updateOrderStatusRequest.setStatus("3");
        updateOrderStatusRequest.setId(1);
        int re=managerService.updateOrderStatus(updateOrderStatusRequest);
        Assert.assertThat(re,is(0));
    }
    @Test
    public void selectLevelByUsername(){
        boolean re=managerService.isManager("testName");
        Assert.assertThat(re,is(false));
    }
}

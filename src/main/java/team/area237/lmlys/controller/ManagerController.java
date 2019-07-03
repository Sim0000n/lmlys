package team.area237.lmlys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import team.area237.lmlys.model.request.UpdateOrderStatusRequest;
import team.area237.lmlys.service.ManagerService;
import team.area237.lmlys.utils.ResponseStatus;
import team.area237.lmlys.utils.ResponseWrapper;

import javax.servlet.http.HttpSession;

@EnableWebMvc
@RestController
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping("/api/orders")
    ResponseWrapper getAllOrdersFromAllUsers() {
        return new ResponseWrapper(ResponseStatus.OK, managerService.getAllOrdersFromAllUsers());
    }

    @GetMapping("/api/order")
    ResponseWrapper getOrderById(@RequestParam("id") int id) {
        return new ResponseWrapper(ResponseStatus.OK, managerService.getOrderById(id));
    }

    @PostMapping("/api/order")
    ResponseWrapper updateOrderStatus(@RequestBody UpdateOrderStatusRequest updateOrderStatusRequest) {
        return new ResponseWrapper(ResponseStatus.OK, managerService.updateOrderStatus(updateOrderStatusRequest));
    }

    @GetMapping("/api/admin")
    ResponseWrapper isManager(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username == null)
            return new ResponseWrapper(ResponseStatus.FAIL_4001, "未登录");
        else
            return new ResponseWrapper(ResponseStatus.OK, managerService.isManager(username));
    }
}

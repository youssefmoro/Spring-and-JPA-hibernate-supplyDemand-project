package dataTransferCommProject.example.RestApis.restController;

import dataTransferCommProject.example.RestApis.business.OrderService;
import dataTransferCommProject.example.RestApis.models.DTOs.orders.OrdersDTO;
import dataTransferCommProject.example.RestApis.models.OrderModel;
import dataTransferCommProject.example.RestApis.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dataTransferCommProject.example.RestApis.utils.ConstantsAndConfig.DONE;

@RestController
@RequestMapping("/ordersApi")
public class OrdersApiController {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderService orderService;
    @GetMapping(value = "/AllOrders")
    public List<OrderModel> getAllOrderRepo() {
        return orderRepo.findAll();
    }
    @PostMapping(value = "/saveOrder")
    public ResponseEntity<String> saveOrder(@RequestBody OrdersDTO orderDTO)
    {
        if(orderService.saveOrders(orderDTO)==DONE) {
            return ResponseEntity.ok("saved");
        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("invalid input");
    }
    @PutMapping(value="/updateOrder/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable long orderId, @RequestBody OrdersDTO ordersDTO)
    {
        if(orderService.updateOrders(ordersDTO,orderId)==DONE)
        {
            return ResponseEntity.ok("updatedSuccessfully");
        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("updatedFailed");
    }
    @DeleteMapping(value = "/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable long orderId)
    {
        OrderModel deleteOrder=orderRepo.findById(orderId).get();
        orderRepo.delete(deleteOrder);
        return "deleted order with id:"+orderId;
    }
    @PostMapping(value = "/saveAllOrders")
    public String createOrders(@RequestBody List<OrdersDTO> orderListDTO) {
        orderService.addListOfOrders(orderListDTO);
        return "saved successfully";
    }
}

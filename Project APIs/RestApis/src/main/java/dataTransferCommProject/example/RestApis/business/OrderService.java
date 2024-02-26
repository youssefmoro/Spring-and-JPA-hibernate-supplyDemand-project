package dataTransferCommProject.example.RestApis.business;

import dataTransferCommProject.example.RestApis.models.DTOs.orders.OrdersDTO;
import dataTransferCommProject.example.RestApis.models.DTOs.orders.OrdersMapper;
import dataTransferCommProject.example.RestApis.models.OrderModel;
import dataTransferCommProject.example.RestApis.repo.OrderRepo;
import dataTransferCommProject.example.RestApis.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static dataTransferCommProject.example.RestApis.utils.ConstantsAndConfig.*;
import static dataTransferCommProject.example.RestApis.utils.ConstantsAndConfig.BATCH_ORDERS;
import static dataTransferCommProject.example.RestApis.Validation.ordersListValidator;

@Service
public class OrderService {
        @Autowired
        private OrderRepo OrdersRepo;
        @Autowired
        private OrdersMapper ordersMapper;
        public OrderModel getOrdersById(long OrdersId)
        {
           OrderModel Orders= OrdersRepo.findById(OrdersId).get();
            return Orders;
        }
        public List<OrderModel> getAllOrdersInsideRepo()
        {
            return OrdersRepo.findAll();
        }
        public int saveOrders(OrdersDTO OrdersDTO)
        {
           OrderModel Orders= ordersMapper.toEntity(OrdersDTO) ;
            OrdersRepo.save(Orders);
            return DONE;
        }
        public int updateOrders(OrdersDTO OrdersDTO, long idToBed)
        {
           OrderModel Orders=ordersMapper.toEntity(OrdersDTO);
            if(Validation.ordersValidator(Orders)) {
                OrderModel updatedOrders = OrdersRepo.findById(idToBed).get();
                updatedOrders.setOrderNumber(Orders.getOrderNumber());
                updatedOrders.setOrderQuantity(Orders.getOrderQuantity());
                updatedOrders.setAccountId(Orders.getAccountId());
                updatedOrders.setItemId(Orders.getItemId());
                OrdersRepo.save(updatedOrders);
                return DONE;
            }
            else return FAILED;
            //(security features)TIME OUT CAN BE ADDED TO RETURN FAILED IF PROCESS NOT DONE WITHIN THIS AMOUNT OF TIME
        }
        public int deleteOrders(long OrdersId)
        {
            OrdersRepo.delete(getOrdersById(OrdersId));
            return DONE;
            //(security features)TIME OUT CAN BE ADDED TO RETURN FAILED IF PROCESS NOT DONE WITHIN THIS AMOUNT OF TIME
        }
        public int deleteAllOrders()
        {
            OrdersRepo.deleteAll();
            return DONE;
            //(security features)TIME OUT CAN BE ADDED TO RETURN FAILED IF PROCESS NOT DONE WITHIN THIS AMOUNT OF TIME
        }
        @Transactional
        public int addListOfOrders(List<OrdersDTO> OrdersDTOs)
        {
            List<OrderModel> orders= ordersMapper.toListOfEntities(OrdersDTOs);

            if (orders.size()>BATCH_ORDERS) {
                List<List<OrderModel>> listOfList = breakingDownAllOrderModelsIntoBatches(orders);
                for (List<OrderModel> invBatch : listOfList) {
                    List<OrderModel> newList=ordersListValidator(invBatch);
                    if(newList!=null) {
                        OrdersRepo.saveAll(newList);
                    }
                }
                return DONE;
            }
            else
            {
                if(ordersListValidator(orders)!=null) {
                    OrdersRepo.saveAll(ordersListValidator(orders));
                }
                return DONE;
            }
        }
        public static List<List<OrderModel>> breakingDownAllOrderModelsIntoBatches(List<OrderModel> allOrders)
        {
            int counter=0;
            List<List<OrderModel>> listOfLists=new ArrayList<>();
            int numOfListsRequired=allOrders.size()/BATCH_ORDERS;
            float diff=(float)((float)allOrders.size()/(float)BATCH_ORDERS)-numOfListsRequired;
            numOfListsRequired=(diff==0)?(numOfListsRequired):(numOfListsRequired+1);
            for(int i=0;i<numOfListsRequired;i++)
            {
                List<OrderModel> innerList = new ArrayList<>();
                for (int j=0;j<BATCH_ORDERS;j++)
                {
                    if (counter < allOrders.size()) {
                        innerList.add(allOrders.get(counter));
                        counter++;
                    } else {
                        break; // Break the loop if all Orders have been processed
                    }
                }
                listOfLists.add(innerList);
            }
            return listOfLists;
        }
    }

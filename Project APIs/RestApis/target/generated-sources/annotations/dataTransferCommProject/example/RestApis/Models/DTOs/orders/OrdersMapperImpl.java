package dataTransferCommProject.example.RestApis.Models.DTOs.orders;

import dataTransferCommProject.example.RestApis.Models.OrderModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T16:31:06+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class OrdersMapperImpl implements OrdersMapper {

    @Override
    public OrdersDTO toDto(OrderModel entity) {
        if ( entity == null ) {
            return null;
        }

        OrdersDTO ordersDTO = new OrdersDTO();

        ordersDTO.setOrderNumber( entity.getOrderNumber() );
        ordersDTO.setAccountId( entity.getAccountId() );
        ordersDTO.setItemId( entity.getItemId() );
        ordersDTO.setOrderQuantity( entity.getOrderQuantity() );

        return ordersDTO;
    }

    @Override
    public OrderModel toEntity(OrdersDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Long orderNumber = null;
        String accountId = null;
        String itemId = null;
        String orderQuantity = null;

        orderNumber = dto.getOrderNumber();
        accountId = dto.getAccountId();
        itemId = dto.getItemId();
        orderQuantity = dto.getOrderQuantity();

        OrderModel orderModel = new OrderModel( orderNumber, accountId, itemId, orderQuantity );

        return orderModel;
    }

    @Override
    public List<OrderModel> toListOfEntities(List<OrdersDTO> listDTOs) {
        if ( listDTOs == null ) {
            return null;
        }

        List<OrderModel> list = new ArrayList<OrderModel>( listDTOs.size() );
        for ( OrdersDTO ordersDTO : listDTOs ) {
            list.add( toEntity( ordersDTO ) );
        }

        return list;
    }
}

package dataTransferCommProject.example.RestApis.models.DTOs.orders;

import dataTransferCommProject.example.RestApis.models.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(uses = OrdersDTO.class,componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrdersMapper {
   OrdersDTO toDto(OrderModel entity);

    OrderModel toEntity(OrdersDTO dto);
    List<OrderModel> toListOfEntities(List<OrdersDTO> listDTOs);
}

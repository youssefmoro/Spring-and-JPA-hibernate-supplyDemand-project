package dataTransferCommProject.example.RestApis.Models.DTOs.orders;

import dataTransferCommProject.example.RestApis.Models.DTOs.Inventory.InventoryCreationDTO;
import dataTransferCommProject.example.RestApis.Models.DTOs.Inventory.InventoryUpdateDTO;
import dataTransferCommProject.example.RestApis.Models.InventoryModel;
import dataTransferCommProject.example.RestApis.Models.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(uses = OrdersDTO.class,componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrdersMapper {
   OrdersDTO toDto(OrderModel entity);

    OrderModel toEntity(OrdersDTO dto);
    List<OrderModel> toListOfEntities(List<OrdersDTO> listDTOs);
}

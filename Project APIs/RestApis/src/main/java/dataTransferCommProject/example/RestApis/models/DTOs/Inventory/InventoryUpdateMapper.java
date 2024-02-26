package dataTransferCommProject.example.RestApis.models.DTOs.Inventory;

import dataTransferCommProject.example.RestApis.models.InventoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(uses = InventoryUpdateDTO.class,componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryUpdateMapper {
    InventoryUpdateDTO toDto(InventoryModel entity);
    InventoryModel toEntity(InventoryUpdateDTO dto);
}

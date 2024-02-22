package dataTransferCommProject.example.RestApis.Models.DTOs.Inventory;

import dataTransferCommProject.example.RestApis.Models.AccountModel;
import dataTransferCommProject.example.RestApis.Models.InventoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(uses = InventoryCreationDTO.class,componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryCreationMapper {
    InventoryCreationDTO toDto(InventoryModel entity);
    //    @Mapping(target = "mobileNumber", source = "entity.getMobileNumber")
//    @Mapping(target = "fullName",source = "entity.getFullName")
//    @Mapping(target = "email",source = "entity.getEmail")
//    @Mapping(target = "address",source = "entity.getAddress")
//    @Mapping(target = "cardNumber",source = "entity.getCardNumber")
    InventoryModel toEntity(InventoryCreationDTO dto);
    List<InventoryModel> toListOfEntities(List<InventoryCreationDTO> listDTOs);
}

package dataTransferCommProject.example.RestApis.models.DTOs.accounts;

import dataTransferCommProject.example.RestApis.models.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(uses = AccountCreationDTO.class,componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountCreationMapper {
//    @Mapping(target = "mobileNumber", source = "entity.getMobileNumber")
//    @Mapping(target = "fullName",source = "entity.getFullName")
//    @Mapping(target = "email",source = "entity.getEmail")
//    @Mapping(target = "address",source = "entity.getAddress")
//    @Mapping(target = "cardNumber",source = "entity.getCardNumber")
    AccountCreationDTO toDto(AccountModel entity);
//    @Mapping(target = "mobileNumber", source = "entity.getMobileNumber")
//    @Mapping(target = "fullName",source = "entity.getFullName")
//    @Mapping(target = "email",source = "entity.getEmail")
//    @Mapping(target = "address",source = "entity.getAddress")
//    @Mapping(target = "cardNumber",source = "entity.getCardNumber")
    AccountModel toEntity(AccountCreationDTO dto);
    List<AccountModel> toListOfEntities(List<AccountCreationDTO> listDTOs);

    List<AccountCreationDTO> toListDto(List<AccountModel> listModels);
}

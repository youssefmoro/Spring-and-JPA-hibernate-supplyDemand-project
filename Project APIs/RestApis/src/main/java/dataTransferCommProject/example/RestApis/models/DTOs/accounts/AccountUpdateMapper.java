package dataTransferCommProject.example.RestApis.models.DTOs.accounts;

import dataTransferCommProject.example.RestApis.models.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(uses = AccountsUpdateDTO.class,componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountUpdateMapper {
//    @Mapping(target = "mobileNumber", source = "entity.getMobileNumber")
//    @Mapping(target = "fullName",source = "entity.getFullName")
//    @Mapping(target = "email",source = "entity.getEmail")
//    @Mapping(target = "address",source = "entity.getAddress")
    AccountsUpdateDTO toDto(AccountModel entity);
//    @Mapping(target = "mobileNumber", source = "dto.mobileNumber")
//    @Mapping(target = "fullName", source = "dto.fullName")
//    @Mapping(target = "email", source = "dto.email")
//    @Mapping(target = "address", source = "dto.address")
//    @Mapping(target = "cardNumber", source = "dto.cardNumber")
    AccountModel toEntity(AccountsUpdateDTO dto);
}

package dataTransferCommProject.example.RestApis.Models.DTOs.accounts;

import dataTransferCommProject.example.RestApis.Models.AccountModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T14:57:55+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AccountUpdateMapperImpl implements AccountUpdateMapper {

    @Override
    public AccountsUpdateDTO toDto(AccountModel entity) {
        if ( entity == null ) {
            return null;
        }

        AccountsUpdateDTO accountsUpdateDTO = new AccountsUpdateDTO();

        accountsUpdateDTO.setMobileNumber( entity.getMobileNumber() );
        accountsUpdateDTO.setFullName( entity.getFullName() );
        accountsUpdateDTO.setEmail( entity.getEmail() );
        accountsUpdateDTO.setAddress( entity.getAddress() );

        return accountsUpdateDTO;
    }

    @Override
    public AccountModel toEntity(AccountsUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AccountModel accountModel = new AccountModel();

        accountModel.setMobileNumber( dto.getMobileNumber() );
        accountModel.setFullName( dto.getFullName() );
        accountModel.setEmail( dto.getEmail() );
        accountModel.setAddress( dto.getAddress() );

        return accountModel;
    }
}

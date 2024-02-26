package dataTransferCommProject.example.RestApis.models.DTOs.accounts;

import dataTransferCommProject.example.RestApis.models.AccountModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-25T20:56:03+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AccountCreationMapperImpl implements AccountCreationMapper {

    @Override
    public AccountCreationDTO toDto(AccountModel entity) {
        if ( entity == null ) {
            return null;
        }

        AccountCreationDTO accountCreationDTO = new AccountCreationDTO();

        accountCreationDTO.setMobileNumber( entity.getMobileNumber() );
        accountCreationDTO.setFullName( entity.getFullName() );
        accountCreationDTO.setEmail( entity.getEmail() );
        accountCreationDTO.setAddress( entity.getAddress() );
        accountCreationDTO.setCardNumber( entity.getCardNumber() );

        return accountCreationDTO;
    }

    @Override
    public AccountModel toEntity(AccountCreationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AccountModel accountModel = new AccountModel();

        accountModel.setMobileNumber( dto.getMobileNumber() );
        accountModel.setFullName( dto.getFullName() );
        accountModel.setEmail( dto.getEmail() );
        accountModel.setAddress( dto.getAddress() );
        accountModel.setCardNumber( dto.getCardNumber() );

        return accountModel;
    }

    @Override
    public List<AccountModel> toListOfEntities(List<AccountCreationDTO> listDTOs) {
        if ( listDTOs == null ) {
            return null;
        }

        List<AccountModel> list = new ArrayList<AccountModel>( listDTOs.size() );
        for ( AccountCreationDTO accountCreationDTO : listDTOs ) {
            list.add( toEntity( accountCreationDTO ) );
        }

        return list;
    }

    @Override
    public List<AccountCreationDTO> toListDto(List<AccountModel> listModels) {
        if ( listModels == null ) {
            return null;
        }

        List<AccountCreationDTO> list = new ArrayList<AccountCreationDTO>( listModels.size() );
        for ( AccountModel accountModel : listModels ) {
            list.add( toDto( accountModel ) );
        }

        return list;
    }
}

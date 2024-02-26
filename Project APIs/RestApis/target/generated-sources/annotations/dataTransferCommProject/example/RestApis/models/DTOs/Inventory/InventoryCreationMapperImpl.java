package dataTransferCommProject.example.RestApis.models.DTOs.Inventory;

import dataTransferCommProject.example.RestApis.models.InventoryModel;
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
public class InventoryCreationMapperImpl implements InventoryCreationMapper {

    @Override
    public InventoryCreationDTO toDto(InventoryModel entity) {
        if ( entity == null ) {
            return null;
        }

        InventoryCreationDTO inventoryCreationDTO = new InventoryCreationDTO();

        inventoryCreationDTO.setItemName( entity.getItemName() );
        inventoryCreationDTO.setItemPrice( entity.getItemPrice() );
        inventoryCreationDTO.setInventoryQuantity( entity.getInventoryQuantity() );

        return inventoryCreationDTO;
    }

    @Override
    public InventoryModel toEntity(InventoryCreationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InventoryModel inventoryModel = new InventoryModel();

        inventoryModel.setItemName( dto.getItemName() );
        inventoryModel.setItemPrice( dto.getItemPrice() );
        inventoryModel.setInventoryQuantity( dto.getInventoryQuantity() );

        return inventoryModel;
    }

    @Override
    public List<InventoryModel> toListOfEntities(List<InventoryCreationDTO> listDTOs) {
        if ( listDTOs == null ) {
            return null;
        }

        List<InventoryModel> list = new ArrayList<InventoryModel>( listDTOs.size() );
        for ( InventoryCreationDTO inventoryCreationDTO : listDTOs ) {
            list.add( toEntity( inventoryCreationDTO ) );
        }

        return list;
    }
}

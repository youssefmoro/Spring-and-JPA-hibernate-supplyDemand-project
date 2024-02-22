package dataTransferCommProject.example.RestApis.Models.DTOs.Inventory;

import dataTransferCommProject.example.RestApis.Models.InventoryModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T14:57:56+0200",
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

        String itemName = null;
        double itemPrice = 0.0d;
        int inventoryQuantity = 0;

        itemName = dto.getItemName();
        itemPrice = dto.getItemPrice();
        inventoryQuantity = dto.getInventoryQuantity();

        long orderId = 0L;

        InventoryModel inventoryModel = new InventoryModel( orderId, itemName, itemPrice, inventoryQuantity );

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

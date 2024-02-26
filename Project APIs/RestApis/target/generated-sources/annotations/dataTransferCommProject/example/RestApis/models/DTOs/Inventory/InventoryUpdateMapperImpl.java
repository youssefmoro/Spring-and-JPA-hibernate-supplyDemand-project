package dataTransferCommProject.example.RestApis.models.DTOs.Inventory;

import dataTransferCommProject.example.RestApis.models.InventoryModel;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-25T20:56:03+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class InventoryUpdateMapperImpl implements InventoryUpdateMapper {

    @Override
    public InventoryUpdateDTO toDto(InventoryModel entity) {
        if ( entity == null ) {
            return null;
        }

        InventoryUpdateDTO inventoryUpdateDTO = new InventoryUpdateDTO();

        inventoryUpdateDTO.setItemPrice( entity.getItemPrice() );
        inventoryUpdateDTO.setInventoryQuantity( entity.getInventoryQuantity() );

        return inventoryUpdateDTO;
    }

    @Override
    public InventoryModel toEntity(InventoryUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InventoryModel inventoryModel = new InventoryModel();

        inventoryModel.setItemPrice( dto.getItemPrice() );
        inventoryModel.setInventoryQuantity( dto.getInventoryQuantity() );

        return inventoryModel;
    }
}

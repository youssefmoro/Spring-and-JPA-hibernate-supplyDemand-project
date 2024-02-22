package dataTransferCommProject.example.RestApis.Models.DTOs.Inventory;

import dataTransferCommProject.example.RestApis.Models.InventoryModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T14:58:16+0200",
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

        double itemPrice = 0.0d;
        int inventoryQuantity = 0;

        itemPrice = dto.getItemPrice();
        inventoryQuantity = dto.getInventoryQuantity();

        long orderId = 0L;
        String itemName = null;

        InventoryModel inventoryModel = new InventoryModel( orderId, itemName, itemPrice, inventoryQuantity );

        return inventoryModel;
    }
}

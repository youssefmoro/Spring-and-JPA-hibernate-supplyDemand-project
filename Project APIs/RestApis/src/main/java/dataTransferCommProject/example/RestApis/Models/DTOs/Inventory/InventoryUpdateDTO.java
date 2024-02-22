package dataTransferCommProject.example.RestApis.Models.DTOs.Inventory;

import jakarta.persistence.Column;
import org.hibernate.validator.constraints.Length;

public class InventoryUpdateDTO {
    @Column(nullable = false)
    private double itemPrice;
    @Column(nullable = false)
    private int inventoryQuantity;

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
}

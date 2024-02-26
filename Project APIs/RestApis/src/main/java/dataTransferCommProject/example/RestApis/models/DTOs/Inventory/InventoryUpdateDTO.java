package dataTransferCommProject.example.RestApis.models.DTOs.Inventory;

import javax.persistence.*;

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

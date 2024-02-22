package dataTransferCommProject.example.RestApis.Models.DTOs.Inventory;

import jakarta.persistence.Column;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

public class InventoryCreationDTO {
    @Column(nullable = false)
    @Length(min = 5,max = 50,message = "invalid item name")
    private String itemName;
    @Column(nullable = false)
    private double itemPrice;
    @Column(nullable = false)
    private int inventoryQuantity;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

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

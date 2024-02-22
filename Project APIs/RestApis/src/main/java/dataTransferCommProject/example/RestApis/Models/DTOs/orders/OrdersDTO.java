package dataTransferCommProject.example.RestApis.Models.DTOs.orders;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
public class OrdersDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    @Column(nullable = false)
    private String accountId;
    @Column(nullable = false)
    private String itemId;
    @Column(nullable = false)
    private String orderQuantity;

    public OrdersDTO() {
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}

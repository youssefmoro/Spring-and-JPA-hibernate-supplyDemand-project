package dataTransferCommProject.example.RestApis.Models.DTOs.accounts;

import jakarta.persistence.Column;
import jdk.jfr.DataAmount;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
@Component
public class AccountCreationDTO {
    @Column(nullable = false)
    @Length(min=11,max = 14)
    private String mobileNumber;
    @Column(nullable = false)
    @Length(min = 5, max = 50)
    private String fullName;
    @Column(nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    @Length(min = 5, max = 100)
    private String address;
    @Column(nullable = false)
    private String cardNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}

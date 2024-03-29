package dataTransferCommProject.example.RestApis.Models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "account_model")

public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    @Column(nullable = false)
    @Length(min=11,max = 14,message = "invalid mobile number")
    //@Pattern(regexp ="^(?:\\+?\\d{2,3}[ -])?\\d{10,11}$",message ="invalid mobile number")
    private String mobileNumber;
    @Column(nullable = false)
    @Length(min = 5, max = 50, message = "invalid name")
    private String fullName;
    @Column(nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    @Length(min = 5, max = 100, message = "invalid address")
    private String address;
    @Column(nullable = false)
    private String cardNumber;

    public AccountModel(long accountId, String mobileNumber, String fullName, String email, String address, String cardNumber) {
        this.accountId = accountId;
        this.mobileNumber = mobileNumber;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.cardNumber = cardNumber;
    }
    public AccountModel() {
        // Default constructor
    }
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

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

    @Override
    public String toString() {
        return "AccountModel{" +
                "accountId=" + accountId +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}

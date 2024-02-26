package dataTransferCommProject.example.RestApis.models.DTOs.accounts;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Component
public class AccountsUpdateDTO {
    @Length(min=11,max = 14)
    private String mobileNumber;
    @Length(min = 5, max = 50)
    private String fullName;
    @Email
    private String email;
    @Length(min = 5, max = 100)
    private String address;

    public AccountsUpdateDTO() {
    }

    public AccountsUpdateDTO(String mobileNumber, String fullName, String email, String address) {
        this.mobileNumber = mobileNumber;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
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
}

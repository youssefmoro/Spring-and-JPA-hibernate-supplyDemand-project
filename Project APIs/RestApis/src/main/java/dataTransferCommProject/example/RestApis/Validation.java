package dataTransferCommProject.example.RestApis;

import dataTransferCommProject.example.RestApis.Models.AccountModel;
import dataTransferCommProject.example.RestApis.Models.InventoryModel;
import dataTransferCommProject.example.RestApis.Models.OrderModel;
import dataTransferCommProject.example.RestApis.Utils.ConstantsAndConfig;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    public static boolean accountsValidator(AccountModel acc) {
        if (acc != null) {
            if (mobileNumberValidatorInString(acc.getMobileNumber()) && emailValidator(acc.getEmail())) {
                return true;
            } else return false;
        }
        return false;
    }

    public static List<AccountModel> accountsListValidator(List<AccountModel> accounts) {
        List<AccountModel> newList=new ArrayList<>();
        for (AccountModel acc : accounts) {
            if(accountsValidator(acc))
            {
                newList.add(acc);
            }
        }
        return newList;
    }
    public static List<InventoryModel> inventoryListValidator(List<InventoryModel> inventoryList) {
        List<InventoryModel> newList=new ArrayList<>();
        for (InventoryModel inv : inventoryList) {
            if(inventoryValidator(inv))
            {
                newList.add(inv);
            }
        }
        return newList;
    }
        public static boolean ordersValidator(OrderModel order)
        {
            if (order != null) {
                if ((allNumericValidatorInString(order.getOrderQuantity())) && (allNumericValidatorInString(order.getAccountId())) && (allNumericValidatorInString(order.getItemId()))) {
                    return true;
                } else return false;
            }
            return false;
        }
    public static List<OrderModel> ordersListValidator(List<OrderModel> orderList) {
        List<OrderModel> newList=new ArrayList<>();
        for (OrderModel order : orderList) {
            if(Validation.ordersValidator(order))
            {
                newList.add(order);
            }
        }
        return newList;
    }
        public static boolean inventoryValidator(InventoryModel inventory)
        {
            if (inventory != null) {
                if ((inventory.getInventoryQuantity() > (0)) && (inventory.getItemPrice() > ((double) 0))) {
                    return true;
                } else return false;
            }
            return false;
        }
        public static boolean stringAllCharValidator (String passedString)
        {
            boolean containsNumber = passedString.matches(".*\\d+.*");
            return containsNumber;
        }
        public static boolean allNumericValidatorInString (String passedString)
        {
            Boolean allNumericApproved = passedString.matches("\\d+");
            return allNumericApproved;
        }
        public static boolean floatingNumberValidatorInString (String passedString)
        {
            String stringPattern = "^\\d+(\\.\\d+)?$";
            Boolean allFloatApproved = passedString.matches(stringPattern);
            return allFloatApproved;
        }
        public static boolean mobileNumberValidatorInString (String passedString)
        {
            if (allNumericValidatorInString(passedString) && (passedString.length() == ConstantsAndConfig.MOBILE11DIGITS)) {
                return true;
            }
            return false;
        }
        public static boolean emailValidator (String passedString)
        {
            String email = "user@example.com";
            String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            boolean isValid = email.matches(regex);
            return isValid;
        }
    }

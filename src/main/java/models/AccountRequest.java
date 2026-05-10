package models;

public class AccountRequest {

    private String customerId;
    private String accountType;
    private double balance;

    public AccountRequest(
            String customerId,
            String accountType,
            double balance) {

        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
}
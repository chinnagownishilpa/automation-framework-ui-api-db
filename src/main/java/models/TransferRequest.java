package models;

public class TransferRequest {

    private String fromAccount;
    private String toAccount;
    private double amount;

    public TransferRequest(
            String fromAccount,
            String toAccount,
            double amount) {

        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public double getAmount() {
        return amount;
    }
}
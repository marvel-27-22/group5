public class Transaction {
    private String transactionId;
    private String date;
    private String time;
    private String type; // SEND, RECEIVE, PAY_BILL, BUY_AIRTIME, WITHDRAW, DEPOSIT
    private double amount;
    private String recipientOrSender;
    private double balance;
    private double transactionCost;

    public Transaction(String id, String date, String time, String type, 
                       double amount, String party, double balance, double cost) {
        this.transactionId = id;
        this.date = date;
        this.time = time;
        this.type = type.toUpperCase();
        this.amount = amount;
        this.recipientOrSender = party;
        this.balance = balance;
        this.transactionCost = cost;
    }

    public boolean isIncoming() {
        return type.equals("RECEIVE") || type.equals("DEPOSIT");
    }

    public boolean isOutgoing() {
        return !isIncoming();
    }

    public double getNetAmount() {
        return isIncoming() ? (amount - transactionCost) : (amount + transactionCost);
    }

    // Getters
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public double getTransactionCost() { return transactionCost; }
    public String getRecipientOrSender() { return recipientOrSender; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return String.format("%-10s | %-12s | %-12s | TSh %,10.0f | Fee: %,.0f", 
                             date, type, recipientOrSender, amount, transactionCost);
    }
}
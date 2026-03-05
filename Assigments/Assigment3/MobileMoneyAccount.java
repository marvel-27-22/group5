import java.util.*;

public class MobileMoneyAccount {
    private String accountHolder;
    private String phoneNumber;
    private String provider;
    private ArrayList<Transaction> transactions;

    public MobileMoneyAccount(String holder, String number, String provider) {
        this.accountHolder = holder;
        this.phoneNumber = number;
        this.provider = provider;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public double getTotalReceived() {
        return transactions.stream().filter(Transaction::isIncoming).mapToDouble(Transaction::getAmount).sum();
    }

    public double getTotalSent() {
        return transactions.stream().filter(Transaction::isOutgoing).mapToDouble(Transaction::getAmount).sum();
    }

    public double getTotalFees() {
        return transactions.stream().mapToDouble(Transaction::getTransactionCost).sum();
    }

    public void generateMonthlyReport() {
        double received = getTotalReceived();
        double sent = getTotalSent();
        double total = received + sent;
        
        int rPerc = (int) ((received / total) * 100);
        int sPerc = (int) ((sent / total) * 100);

        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║         MOBILE MONEY MONTHLY REPORT                    ║");
        System.out.printf("║         %-15s - %-26s ║\n", provider, phoneNumber);
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.printf("║  Account Holder: %-38s║\n", accountHolder);
        System.out.printf("║  Total Transactions: %-34d║\n", transactions.size());
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║                                                        ║");
        System.out.println("║  MONEY FLOW:                                           ║");
        System.out.printf("║  ├── Received: TSh %-10s %-18s (%d%%) ║\n", 
                          String.format("%,.0f", received), "█".repeat(rPerc/5) + "░".repeat(20-rPerc/5), rPerc);
        System.out.printf("║  └── Sent:     TSh %-10s %-18s (%d%%) ║\n", 
                          String.format("%,.0f", sent), "█".repeat(sPerc/5) + "░".repeat(20-sPerc/5), sPerc);
        System.out.println("║                                                        ║");
        System.out.println("║  FEES ANALYSIS:                                        ║");
        System.out.printf("║  Total Fees Paid: TSh %, -30.0f ║\n", getTotalFees());
        System.out.printf("║  Average Fee:     TSh %, -30.0f ║\n", (getTotalFees()/transactions.size()));
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
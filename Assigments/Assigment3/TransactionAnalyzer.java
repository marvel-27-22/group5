public class TransactionAnalyzer {
    public static void main(String[] args) {
        MobileMoneyAccount myAccount = new MobileMoneyAccount(
            "SAID MOHD SAID", 
            "0758247650", 
            "M-Pesa"
        );

       
        myAccount.addTransaction(new Transaction("QC12345", "2026-02-10", "14:20", "RECEIVE", 50000, "Ali Khamis", 150000, 0));
        myAccount.addTransaction(new Transaction("QC12346", "2026-02-12", "09:00", "BUY_AIRTIME", 2000, "Zantel", 148000, 0));
        myAccount.addTransaction(new Transaction("QC12347", "2026-02-15", "18:30", "SEND", 20000, "Fatma Juma", 127500, 500));
        myAccount.addTransaction(new Transaction("QC12348", "2026-02-18", "11:15", "PAY_BILL", 15000, "ZECO", 112500, 0));
    
        myAccount.generateMonthlyReport();
    }
}
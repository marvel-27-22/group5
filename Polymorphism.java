class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Acc No: " + accountNumber + " | Holder: " + accountHolder + " | Balance: " + balance);
    }

    public double calculateInterest() {
        return 0;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 10000) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Error: Must maintain TZS 10,000 minimum balance!");
        }
    }

    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("Interest applied: " + interest);
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }
}

class FixedDepositAccount extends BankAccount {
    private double interestRate;
    private int maturityMonths;
    private boolean isMatured;

    public FixedDepositAccount(String accountNumber, String accountHolder, double balance, double interestRate, int maturityMonths) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        this.maturityMonths = maturityMonths;
        this.isMatured = false;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate * (maturityMonths / 12.0);
    }

    @Override
    public void withdraw(double amount) {
        if (isMatured) {
            super.withdraw(amount);
        } else {
            System.out.println("Error: Account not matured yet!");
        }
    }

    public void checkMaturity(int monthsPassed) {
        if (monthsPassed >= maturityMonths) {
            isMatured = true;
        }
    }

    public double getMaturityAmount() {
        return balance + calculateInterest();
    }
}

class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank(int size) {
        accounts = new BankAccount[size];
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count] = account;
            count++;
        }
    }

    public double getTotalDeposits() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public double getTotalInterest() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].calculateInterest();
        }
        return total;
    }

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            accounts[i].displayAccountInfo();
        }
    }
    
    public BankAccount findAccount(String accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber.equals(accNo)) {
                return accounts[i];
            }
        }
        return null;
    }
}

public class Polymorphism {

    public static void transferMoney(BankAccount from, BankAccount to, double amount) {
        if (from.getBalance() >= amount) {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Transfer successful!");
        }
    }

    public static void transferMoney(BankAccount from, BankAccount to, double amount, String description) {
        System.out.println("Note: " + description);
        transferMoney(from, to, amount);
    }

    public static void transferMoney(BankAccount from, String toAccNo, double amount, Bank bank) {
        BankAccount to = bank.findAccount(toAccNo);
        if (to != null) {
            transferMoney(from, to, amount);
        } else {
            System.out.println("Target account not found!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== BANKING SYSTEM TEST ===\n");

        SavingsAccount savings = new SavingsAccount("SAV001", "Ali Hassan", 500000, 0.05);
        CurrentAccount current = new CurrentAccount("CUR001", "Fatma Said", 1000000, 500000);
        FixedDepositAccount fixed = new FixedDepositAccount("FD001", "Omar Juma", 2000000, 0.08, 12);

        System.out.println("--- Testing Savings ---");
        savings.deposit(100000);
        savings.withdraw(50000);
        savings.applyInterest();

        System.out.println("\n--- Testing Current ---");
        current.withdraw(1200000);
        System.out.println("Overdrawn: " + current.isOverdrawn());

        System.out.println("\n--- Testing Fixed Deposit ---");
        fixed.withdraw(500000);
        System.out.println("Maturity Amount: " + fixed.getMaturityAmount());

        Bank bank = new Bank(10);
        bank.addAccount(savings);
        bank.addAccount(current);
        bank.addAccount(fixed);

        System.out.println("\n--- Bank Summary ---");
        bank.displayAllAccounts();
        System.out.println("Total Deposits: " + bank.getTotalDeposits());
        System.out.println("Total Interest: " + bank.getTotalInterest());

        System.out.println("\n--- Testing Transfers ---");
        transferMoney(savings, current, 50000);
        transferMoney(current, "SAV001", 30000, bank);

        System.out.println("\n=== END OF TEST ===");
    }
}
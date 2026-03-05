
public class Employee {
    private String employeeId;
    private String fullName;
    private String department;
    private double basicSalary;
    private int yearsOfService;

    public Employee() {
        this.employeeId = "TBD";
        this.fullName = "New Hire";
        this.department = "General";
        this.basicSalary = 500000;
        this.yearsOfService = 0;
    }

    public Employee(String id, String name, String dept, double salary) {
        this.employeeId = id;
        this.fullName = name;
        this.department = dept;
        this.yearsOfService = 0; 
        
                if (salary < 500000) {
            System.out.println("Note: " + name + "'s initial salary was bumped to 5000000 minimum.");
            this.basicSalary = 500000;
        } else {
            this.basicSalary = salary;
        }
    }

    public String getEmployeeId() {
         return employeeId; 
         }
    public String getFullName() { 
        return fullName;
         }
    public String getDepartment() { 
        return department;
         }
    public double getBasicSalary() { 
        return basicSalary;
         }
    public int getYearsOfService() { 
        return yearsOfService; 
        }

    public void setBasicSalary(double amount) {
        if (amount >= 500000) {
            this.basicSalary = amount;
        } else {
            System.err.println("Validation Error: Salary must be at least 500,000.");
        }
    }

    public void setYearsOfService(int years) {
        if (years >= 0) {
            this.yearsOfService = years;
        }
    }

    public double calculateBonus() {
        if (yearsOfService <= 0) return 0.0;

        double bonusRate = yearsOfService * 0.10;
        if (bonusRate > 0.50) {
            bonusRate = 0.50;
        }
        
        return basicSalary * bonusRate;
    }

    public double calculateNetSalary() {
        double grossPay = basicSalary + calculateBonus();
        double tax = grossPay * 0.15;
        return grossPay - tax;
    }


    public void promote(String newDept, double raise) {
        this.department = newDept;
        this.basicSalary += raise;
        System.out.println(" UPDATE: " + fullName + " promoted to " + newDept);
    }

    public void printSummary() {
        System.out.println("\n--- [ PAYROLL RECORD ] ---");
        System.out.println("ID: " + employeeId + " | Name: " + fullName);
        System.out.println("Dept: " + department);
        System.out.println("Service: " + yearsOfService + " years");
        System.out.println("--------------------------");
        System.out.printf("Base Salary:    %,.0f\n", basicSalary);
        System.out.printf("Bonus:          %,.0f\n", calculateBonus());
        System.out.printf("Net Salary:     %,.0f (After 15%% Tax)\n", calculateNetSalary());
        System.out.println("--------------------------\n");
    }

    public static void main(String[] args) {   
        Employee ali = new Employee("EMP001","Ali Hassan", "IT", 1500000);
        Employee fatma = new Employee("EMP002", "Fatma Said", "HR", 1200000);
        ali.setYearsOfService(5);
        fatma.setYearsOfService(2);

        ali.printSummary();
        fatma.printSummary();

        ali.promote("Senior IT", 300000);
        ali.printSummary();
    }
}
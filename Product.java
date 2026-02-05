
public class Product {

    private String productCode;
    private String productName;
    private String category;
    private double unitPrice;
    private int quantityInStock;
    private int reorderLevel;

    public Product() {
        this.productCode = "UNKNOWN";
        this.productName = "New Product";
        this.category = "General";
        this.unitPrice = 1.0;
        this.quantityInStock = 0;
        this.reorderLevel = 10; 

    public Product(String code, String name, String cat, double price, int stock) {
        this.productCode = code;
        this.productName = name;
        this.category = cat;
        this.reorderLevel = 10;
        
        setUnitPrice(price);
        setQuantityInStock(stock);
    }

    public String getProductCode() {
         return productCode; 
         }
    public String getProductName() { 
        return productName;
         }
    public String getCategory() { 
        return category; 
        }
    public double getUnitPrice() { 
        return unitPrice;
         }
    public int getQuantityInStock() {
         return quantityInStock;
          }
    public int getReorderLevel() { 
        return reorderLevel;
         }

    public void setUnitPrice(double price) {
        if (price > 0) this.unitPrice = price;
        else System.err.println("Error: Price must be greater than zero.");
    }

    public void setQuantityInStock(int qty) {
        if (qty >= 0) this.quantityInStock = qty;
    }

    public void setReorderLevel(int level) {
        if (level > 0) this.reorderLevel = level;
    }

    public void addStock(int qty) {
        if (qty > 0) {
            this.quantityInStock += qty;
            System.out.println("Added " + qty + " units to " + productName);
        }
    }

    public boolean sellProduct(int qty) {
        if (qty <= quantityInStock) {
            this.quantityInStock -= qty;
            System.out.println("Sold " + qty + " units of " + productName);
            return true;
        } else {
            System.out.println("Not enough stock for " + productName + " (Available: " + quantityInStock + ")");
            return false;
        }
    }

    public double calculateStockValue() {
        return unitPrice * quantityInStock;
    }

    public boolean needsReorder() {
        return quantityInStock <= reorderLevel;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage < 100) {
            double discountAmount = unitPrice * (percentage / 100);
            this.unitPrice -= discountAmount;
            System.out.printf("Applied %.0f%% discount to %s. New price: %,.2f\n", 
                               percentage, productName, unitPrice);
        }
    }


    public void displayProductInfo() {
        System.out.println("------------------------------------");
        System.out.println("Product: [" + productCode + "] " + productName);
        System.out.println("Category: " + category);
        System.out.printf("Price:    %,.2f\n", unitPrice);
        System.out.println("Stock:    " + quantityInStock + " units");
        
        if (needsReorder()) {
            System.out.println("STATUS: REORDER REQUIRED (Min: " + reorderLevel + ")");
        } else {
            System.out.println("STATUS: Stock Level OK");
        }
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== Product Inventory Exercise ===\n");

        Product p1 = new Product("PRD001", "Laptop", "Electronics", 1500000, 25);
        Product p2 = new Product("PRD002", "Office Chair", "Furniture", 350000, 8);
        Product p3 = new Product("PRD003", "Notebook", "Stationery", 5000, 100);

        p1.displayProductInfo();
        p2.displayProductInfo();
        p3.displayProductInfo();

        p1.sellProduct(20);

        if (p2.needsReorder()) {
            System.out.println("(!) Restocking chairs due to low inventory...");
            p2.addStock(50);
        }

        p3.applyDiscount(15);

        System.out.println("\n--- FINAL STOCK VALUES ---");
        System.out.printf("%s: %,.0f\n", p1.getProductName(), p1.calculateStockValue());
        System.out.printf("%s: %,.0f\n", p2.getProductName(), p2.calculateStockValue());
        System.out.printf("%s: %,.0f\n", p3.getProductName(), p3.calculateStockValue());

        System.out.println("\n=== Exercise Complete ===");
    }
}
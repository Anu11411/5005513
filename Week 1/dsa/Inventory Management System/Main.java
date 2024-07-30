import java.util.HashMap;
import java.util.Map;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters(as all variables are private so they cant be accessed
    // directly)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

class Inventory {
    private Map<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Method to update a product
    public void updateProduct(int productId, Product updatedProduct) {
        if (products.containsKey(productId)) {
            products.put(productId, updatedProduct);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    // Method to delete a product
    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    // Method to display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products
        Product product1 = new Product(1, "Laptop", 10, 999.99);
        Product product2 = new Product(2, "Smartphone", 20, 599.99);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Displaying all products
        System.out.println("Inventory after adding products:");
        inventory.displayProducts();

        // Updating a product
        Product updatedProduct1 = new Product(1, "Laptop", 15, 949.99);
        inventory.updateProduct(1, updatedProduct1);

        // Displaying all products after update
        System.out.println("\nInventory after updating product:");
        inventory.displayProducts();

        // Deleting a product
        inventory.deleteProduct(2);

        // Displaying all products after deletion
        System.out.println("\nInventory after deleting product:");
        inventory.displayProducts();
    }
}

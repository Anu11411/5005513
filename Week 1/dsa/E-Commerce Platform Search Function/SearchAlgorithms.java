import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    // Constructor
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class SearchAlgorithms {
    public static void main(String[] args) {
        // Products for linear search
        Product[] productsLinear = {
                new Product(1, "Product A", "Category 1"),
                new Product(2, "Product B", "Category 2"),
                new Product(3, "Product C", "Category 1"),
                new Product(4, "Product D", "Category 3")
        };

        // Products for binary search (sorted by productId)
        Product[] productsBinary = {
                new Product(1, "Product A", "Category 1"),
                new Product(2, "Product B", "Category 2"),
                new Product(3, "Product C", "Category 1"),
                new Product(4, "Product D", "Category 3")
        };
        Arrays.sort(productsBinary, (p1, p2) -> Integer.compare(p1.productId, p2.productId));

        int productIdToSearch = 3;

        System.out.println("Linear Search:");
        int indexLinear = linearSearch(productsLinear, productIdToSearch);
        if (indexLinear != -1) {
            System.out.println("Product found at index: " + indexLinear);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\nBinary Search:");
        int indexBinary = binarySearch(productsBinary, productIdToSearch);
        if (indexBinary != -1) {
            System.out.println("Product found at index: " + indexBinary);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static int linearSearch(Product[] products, int productId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == productId) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == productId) {
                return mid;
            } else if (products[mid].productId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

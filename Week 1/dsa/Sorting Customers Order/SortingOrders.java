import java.util.Arrays;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
}

public class SortingOrders {
    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Customer A", 100.0),
                new Order(2, "Customer B", 250.0),
                new Order(3, "Customer C", 50.0),
                new Order(4, "Customer D", 150.0)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        Order[] ordersForBubbleSort = Arrays.copyOf(orders, orders.length);
        bubbleSort(ordersForBubbleSort);
        System.out.println("\nOrders after Bubble Sort:");
        printOrders(ordersForBubbleSort);

        Order[] ordersForQuickSort = Arrays.copyOf(orders, orders.length);
        quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        printOrders(ordersForQuickSort);
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high]
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.orderId + ", Customer Name: " + order.customerName
                    + ", Total Price: " + order.totalPrice);
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ECommerceApp {
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadProducts();

        int choice;
        do {
            System.out.println("\n=== Welcome to My eShop ===");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID to add to cart: ");
                    int id = scanner.nextInt();
                    addToCart(id);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    static void loadProducts() {
        products.add(new Product(1, "Smartphone", 199.99));
        products.add(new Product(2, "Headphones", 49.99));
        products.add(new Product(3, "Keyboard", 29.99));
        products.add(new Product(4, "Laptop", 599.99));
    }

    static void showProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            System.out.println(p.id + ". " + p.name + " - $" + p.price);
        }
    }

    static void addToCart(int id) {
        for (Product p : products) {
            if (p.id == id) {
                cart.add(p);
                System.out.println(p.name + " added to cart.");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\nYour Cart:");
        double total = 0;
        for (Product p : cart) {
            System.out.println("- " + p.name + " ($" + p.price + ")");
            total += p.price;
        }
        System.out.println("Total: $" + total);
    }
}

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = 0.0;
        int totalItemsCount = 0;
        boolean shopping = true;


        while (shopping) {
            System.out.println("===== SIMPLE STORE =====");
            System.out.println("1. Mouse       - $20");
            System.out.println("2. Keyboard    - $40");
            System.out.println("3. Headphones  - $50");
            System.out.println("4. Laptop Stand- $30");
            System.out.println("5. Checkout");
            System.out.println();
            System.out.print("Choose a product: ");

            int choice = scanner.nextInt();


            if (choice < 1 || choice > 5) {
                System.out.println("\nInvalid option.");
                System.out.println("Please choose a number from 1 to 5.\n");
                continue;
            }


            if (choice == 5) {
                shopping = false;
                break;
            }


            String productName = "";
            double productPrice = 0;

            if (choice == 1) {
                productName = "Mouse";
                productPrice = 20;
            } else if (choice == 2) {
                productName = "Keyboard";
                productPrice = 40;
            } else if (choice == 3) {
                productName = "Headphones";
                productPrice = 50;
            } else if (choice == 4) {
                productName = "Laptop Stand";
                productPrice = 30;
            }


            System.out.println("You selected: " + productName);
            System.out.println("Price: $" + (int)productPrice);
            System.out.print("Enter quantity: ");

            int quantity = scanner.nextInt();


            if (quantity <= 0) {
                System.out.println("\nInvalid quantity.");
                System.out.println("Quantity must be greater than 0.\n");
                continue; // Товар не добавляется в сумму
            }


            double itemCost = quantity * productPrice;
            subtotal += itemCost;
            totalItemsCount += quantity;

            System.out.println(quantity + " x $" + (int)productPrice + " = $" + (int)itemCost);
            System.out.println("Added to cart!");
            System.out.println("Current total: $" + (int)subtotal);
            System.out.println();
        }


        System.out.println("\n===== CHECKOUT =====");
        System.out.println("Subtotal: $" + (int)subtotal);


        double discount = 0.0;
        if (subtotal >= 100) {
            discount = subtotal * 0.10;
        }
        System.out.println("Discount: $" + (int)discount);


        double finalTotal = subtotal - discount;
        System.out.println("Final total: $" + (int)finalTotal);
        System.out.println();


        double payment = 0.0;
        while (true) {
            System.out.print("Enter payment amount: $");
            payment = scanner.nextDouble();

            if (payment >= finalTotal) {
                System.out.println("Payment successful!");
                break;
            } else {
                double needed = finalTotal - payment;
                System.out.println("Insufficient payment.");
                System.out.println("You still need to pay: $" + (int)needed);
                System.out.println();
            }
        }


        double change = payment - finalTotal;
        System.out.println("Change: $" + (int)change);
        System.out.println();


        System.out.println("================================");
        System.out.println("          SIMPLE STORE          ");


        System.out.println("================================");
        System.out.println("Subtotal: $" + (int)subtotal);
        System.out.println("Discount: $" + (int)discount);
        System.out.println("Final total: $" + (int)finalTotal);
        System.out.println("Payment: $" + (int)payment);
        System.out.println("Change: $" + (int)change);
        System.out.println("================================");
        System.out.println("Items purchased: " + totalItemsCount);
        System.out.println("Thank you for shopping!");
        System.out.println("================================");

        scanner.close();
    }
}
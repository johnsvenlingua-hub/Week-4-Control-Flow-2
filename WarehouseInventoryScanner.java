import java.util.Scanner;

public class WarehouseInventoryScanner {

    private static final int CRITICAL_THRESHOLD = 5;

    public static void main(String[] args) {
        int[][] warehouse = {
            {15, -1, 8, 20},
            {12, 3, 10, -1},
            {25, 18, 2, 14}
        };

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== WAREHOUSE INVENTORY MENU ===");
            System.out.println("1. Calculate Total Inventory");
            System.out.println("2. Find First Critically Low Shelf");
            System.out.println("3. Restock Item (with validation)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculateTotalInventory(warehouse);
                    break;
                case 2:
                    findFirstCriticallyLow(warehouse);
                    break;
                case 3:
                    restockItem(warehouse, scanner);
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void calculateTotalInventory(int[][] warehouse) {
        int totalItems = 0;

        for (int aisle = 0; aisle < warehouse.length; aisle++) {
            for (int shelf = 0; shelf < warehouse[aisle].length; shelf++) {
                int count = warehouse[aisle][shelf];
                if (count == -1) {
                    continue; 
                }
                totalItems += count;
            }
        }

        System.out.println("Total inventory count across all non-damaged shelves: " + totalItems);
    }

    public static void findFirstCriticallyLow(int[][] warehouse) {
        boolean found = false;

        searchLoop:
        for (int aisle = 0; aisle < warehouse.length; aisle++) {
            for (int shelf = 0; shelf < warehouse[aisle].length; shelf++) {
                int count = warehouse[aisle][shelf];
                if (count != -1 && count < CRITICAL_THRESHOLD) {
                    System.out.println("First critically low shelf found at Aisle " + aisle + ", Shelf " + shelf + " (Count: " + count + ")");
                    found = true;
                    break searchLoop; 
                }
            }
        }

        if (!found) {
            System.out.println("No critically low shelves found.");
        }
    }

    public static void restockItem(int[][] warehouse, Scanner scanner) {
        int aisle = -1;
        int shelf = -1;

        while (true) {
            System.out.print("Enter Aisle index (0 to " + (warehouse.length - 1) + ", or -1 to cancel): ");
            aisle = scanner.nextInt();
            
            if (aisle == -1) {
                System.out.println("Restock operation canceled.");
                return; 
            }

            if (aisle >= 0 && aisle < warehouse.length) {
                System.out.print("Enter Shelf index (0 to " + (warehouse[aisle].length - 1) + "): ");
                shelf = scanner.nextInt();

                if (shelf >= 0 && shelf < warehouse[aisle].length) {
                    if (warehouse[aisle][shelf] == -1) {
                        System.out.println("Cannot restock: Shelf is damaged (-1). Choose a valid shelf.");
                        continue;
                    }
                    break; 
                }
            }
            System.out.println("Invalid aisle or shelf location. Please enter valid coordinates.");
        }

        int restockQuantity = 0;
        while (true) {
            System.out.print("Enter quantity to add (must be > 0): ");
            restockQuantity = scanner.nextInt();

            if (restockQuantity > 0) {
                break; 
            }
            System.out.println("Invalid quantity. Quantity must be greater than zero.");
        }

        warehouse[aisle][shelf] += restockQuantity;
        System.out.println("Successfully updated Aisle " + aisle + ", Shelf " + shelf + ". New item count: " + warehouse[aisle][shelf]);
        return; 
    }
}

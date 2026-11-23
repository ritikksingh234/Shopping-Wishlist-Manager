package com.ritik.wishlist;

import com.ritik.wishlist.model.WishlistItem;
import com.ritik.wishlist.service.WishlistService;
import com.ritik.wishlist.storage.WishlistRepository;
import com.ritik.wishlist.structure.WishlistLinkedList;
import com.ritik.wishlist.ui.ConsoleInput;

public class Main {
    private static final ConsoleInput input = new ConsoleInput();
    private static final WishlistRepository repository = new WishlistRepository();
    private static WishlistLinkedList wishlist;
    private static WishlistService service;

    public static void main(String[] args) {
        wishlist = repository.load();
        service = new WishlistService(wishlist);
        System.out.println("\n============================================================");
        System.out.println("             SHOPPING WISHLIST MANAGER");
        System.out.println("============================================================");
        System.out.println("Loaded " + wishlist.getSize() + " wishlist items.");
        boolean running = true;
        while (running) {
            showMenu();
            int choice = input.readInt("Enter your choice: ");
            switch (choice) {
                case 1: addItem(); break;
                case 2: wishlist.display(); break;
                case 3: sortItems(true); break;
                case 4: sortItems(false); break;
                case 5: removeItem(); break;
                case 6: searchItem(); break;
                case 7: updateQuantity(); break;
                case 8: filterCategory(); break;
                case 9: showSummary(); break;
                case 0:
                    repository.save(wishlist);
                    System.out.println("Wishlist saved. Thank you for using the application!");
                    running = false;
                    break;
                default: System.out.println("Invalid choice. Please select from the menu.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n----------------------- MAIN MENU --------------------------");
        System.out.println("1. Add a new item");
        System.out.println("2. Display all wishlist items");
        System.out.println("3. Sort by price (Low to High)");
        System.out.println("4. Sort by price (High to Low)");
        System.out.println("5. Remove an item by ID");
        System.out.println("6. Search item by ID or exact name");
        System.out.println("7. Update item quantity");
        System.out.println("8. Filter items by category");
        System.out.println("9. Wishlist summary and total cost");
        System.out.println("0. Save and Exit");
        System.out.println("------------------------------------------------------------");
    }

    private static void addItem() {
        try {
            String name = input.readText("Item name: ");
            double price = input.readDouble("Unit price (Rs.): ");
            String category = input.readText("Category (e.g. Electronics, Fashion, Books): ");
            if (category.isEmpty()) category = "Other";
            int quantity = input.readInt("Quantity: ");
            WishlistItem item = service.add(name, price, category, quantity);
            repository.save(wishlist);
            System.out.println("Added successfully. Your item ID is " + item.getId());
        } catch (IllegalArgumentException e) { System.out.println("Unable to add item: " + e.getMessage()); }
    }

    private static void sortItems(boolean ascending) {
        wishlist.sortByPrice(ascending);
        System.out.println(ascending ? "Sorted from low to high." : "Sorted from high to low.");
        wishlist.display();
        repository.save(wishlist);
    }

    private static void removeItem() {
        String id = input.readText("Enter item ID to remove (e.g. W101): ");
        if (wishlist.remove(id)) { repository.save(wishlist); System.out.println("Item removed successfully."); }
        else System.out.println("Item not found. Check the ID and try again.");
    }

    private static void searchItem() {
        String key = input.readText("Enter item ID or exact item name: ");
        WishlistItem item = key.matches("(?i)W\\d+") ? wishlist.findById(key) : wishlist.findByName(key);
        if (item == null) System.out.println("No matching item found.");
        else {
            System.out.println("ID     | ITEM                     | UNIT PRICE         | CATEGORY       | QTY | LINE TOTAL");
            System.out.println(item);
        }
    }

    private static void updateQuantity() {
        String id = input.readText("Enter item ID: ");
        WishlistItem item = wishlist.findById(id);
        if (item == null) { System.out.println("Item not found."); return; }
        int quantity = input.readInt("Enter new quantity: ");
        if (quantity <= 0) { System.out.println("Quantity must be greater than zero."); return; }
        item.setQuantity(quantity);
        repository.save(wishlist);
        System.out.println("Quantity updated successfully.");
    }

    private static void filterCategory() {
        String category = input.readText("Enter category: ");
        wishlist.displayCategory(category);
    }

    private static void showSummary() {
        System.out.println("\n================ WISHLIST SUMMARY =================");
        System.out.println("Number of unique items : " + wishlist.getSize());
        System.out.printf("Total wishlist cost    : Rs. %.2f%n", wishlist.getTotalCost());
        System.out.println("===================================================");
    }
}

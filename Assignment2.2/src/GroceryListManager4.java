import java.util.HashMap;

public class GroceryListManager4 {
    static class Item {
        double cost;
        String category;
        int quantity;

        Item(double cost, String category, int quantity) {
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }
    }

    private HashMap<String, Item> groceryList = new HashMap<>();

    // add item with cost, category, quantity
    public void addItem(String item, double cost, String category, int quantity) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " already exists.");
        } else {
            groceryList.put(item, new Item(cost, category, quantity));
            System.out.println(item + " added.");
        }
    }

    // update quantity
    public void updateQuantity(String item, int newQuantity) {
        if (groceryList.containsKey(item)) {
            groceryList.get(item).quantity = newQuantity;
            System.out.println(item + " updated to " + newQuantity);
        } else {
            System.out.println(item + " not found.");
        }
    }

    // display available items
    public void displayAvailableItems() {
        System.out.println("Available items:");
        int i = 1;
        for (String item : groceryList.keySet()) {
            Item it = groceryList.get(item);
            if (it.quantity > 0) {
                System.out.println(i + ". " + item + " - $" + it.cost + " (" + it.category + "), Qty: " + it.quantity);
                i++;
            }
        }
        if (i == 1) {
            System.out.println("No available items.");
        }
    }

    // display by category
    public void displayByCategory(String category) {
        System.out.println("Items in category " + category + ":");
        int i = 1;
        for (String item : groceryList.keySet()) {
            Item it = groceryList.get(item);
            if (it.category.equalsIgnoreCase(category) && it.quantity > 0) {
                System.out.println(i + ". " + item + " - $" + it.cost + ", Qty: " + it.quantity);
                i++;
            }
        }
        if (i == 1) {
            System.out.println("No items found.");
        }
    }

    // calculate total cost (price * quantity)
    public double calculateTotalCost() {
        double total = 0;
        for (Item it : groceryList.values()) {
            total += it.cost * it.quantity;
        }
        System.out.println("Total cost = $" + total);
        return total;
    }
}
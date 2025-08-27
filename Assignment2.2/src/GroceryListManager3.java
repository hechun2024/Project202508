import java.util.HashMap;

public class GroceryListManager3 {
    private HashMap<String, Double> costs = new HashMap<>();
    private HashMap<String, String> categories = new HashMap<>();

    public void addItem(String item, double cost, String category) {
        if (costs.containsKey(item)) {
            System.out.println(item + " already exists.");
        } else {
            costs.put(item, cost);
            categories.put(item, category);
            System.out.println(item + " added.");
        }
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category " + category + ":");
        int i = 1;
        for (String item : costs.keySet()) {
            if (categories.get(item).equalsIgnoreCase(category)) {
                System.out.println(i + ". " + item + " - $" + costs.get(item));
                i++;
            }
        }
        if (i == 1) {
            System.out.println("No items found.");
        }
    }

    // main for testing
    public static void main(String[] args) {
        GroceryListManager3 manager = new GroceryListManager3();
        manager.addItem("Apples", 3.5, "Fruits");
        manager.addItem("Milk", 2.0, "Dairy");
        manager.addItem("Bread", 2.5, "Bakery");
        manager.displayByCategory("Dairy");
        manager.displayByCategory("Fruits");
    }
}
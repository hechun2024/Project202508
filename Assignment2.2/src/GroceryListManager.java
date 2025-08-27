import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    // Add item to the list (avoid duplicates)
    public void addItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println(item + " is already in the list.");
        } else {
            groceryList.add(item);
            System.out.println(item + " added to the list.");
        }
    }

    // Remove item from the list (check existence)
    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
            System.out.println(item + " removed from the list.");
        } else {
            System.out.println(item + " not found in the list.");
        }
    }

    // Show all items in the list
    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Grocery List:");
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    // Check if an item is in the list
    public boolean checkItem(String item) {
        boolean found = groceryList.contains(item);
        System.out.println("Is \"" + item + "\" in the list? " + found);
        return found;
    }

    // Main method for testing
    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Banana");
        manager.addItem("Orange");
        manager.addItem("Maito");
        manager.addItem("Orange"); // test duplicate

        manager.displayList();

        manager.checkItem("Banana");
        manager.checkItem("Orange");

        manager.removeItem("Maito");
        manager.removeItem("Orange"); // test remove non-existent

        manager.displayList();
    }
}
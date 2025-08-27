import java.util.ArrayList;

public class GroceryListManager1 {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println(item + " is already in the list.");
        } else {
            groceryList.add(item);
            System.out.println(item + " added.");
        }
    }

    public void removeItem(String item) {
        if (groceryList.remove(item)) {
            System.out.println(item + " removed.");
        } else {
            System.out.println(item + " not found.");
        }
    }

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

    public boolean checkItem(String item) {
        boolean found = groceryList.contains(item);
        System.out.println("Is " + item + " in the list? " + found);
        return found;
    }

    // main for testing
    public static void main(String[] args) {
        GroceryListManager1 manager = new GroceryListManager1();
        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.displayList();
        manager.checkItem("Bread");
        manager.removeItem("Milk");
        manager.displayList();
    }
}
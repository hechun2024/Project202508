import java.util.ArrayList;

public class GroceryListManager1 {
    private ArrayList<String> groceryList = new ArrayList<>();

    // add item
    public void addItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println(item + " is already in the list.");
        } else {
            groceryList.add(item);
            System.out.println(item + " added.");
        }
    }

    // remove item
    public void removeItem(String item) {
        if (groceryList.remove(item)) {
            System.out.println(item + " removed.");
        } else {
            System.out.println(item + " not found.");
        }
    }

    // display list
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

    // check item
    public boolean checkItem(String item) {
        boolean found = groceryList.contains(item);
        System.out.println("Is " + item + " in the list? " + found);
        return found;
    }
}
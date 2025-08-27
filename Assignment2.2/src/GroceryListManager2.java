import java.util.HashMap;

public class GroceryListManager2 {
    private HashMap<String, Double> groceryList = new HashMap<>();

    // add item with cost
    public void addItem(String item, double cost) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " already exists.");
        } else {
            groceryList.put(item, cost);
            System.out.println(item + " added with cost $" + cost);
        }
    }

    // display list
    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Grocery List:");
            int i = 1;
            for (String item : groceryList.keySet()) {
                System.out.println(i + ". " + item + " - $" + groceryList.get(item));
                i++;
            }
        }
    }

    // calculate total cost
    public double calculateTotalCost() {
        double total = 0;
        for (double c : groceryList.values()) {
            total += c;
        }
        System.out.println("Total cost = $" + total);
        return total;
    }
}
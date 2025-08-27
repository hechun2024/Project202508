public class GroceryListTester {
    public static void main(String[] args) {
        GroceryListManager4 manager = new GroceryListManager4();

        // add items
        manager.addItem("Apples", 3.5, "Fruits", 5);
        manager.addItem("Milk", 2.0, "Dairy", 2);
        manager.addItem("Bread", 2.5, "Bakery", 3);
        manager.addItem("Cheese", 4.0, "Dairy", 1);

        // display all
        manager.displayAvailableItems();

        // total cost
        manager.calculateTotalCost();

        // display by category
        manager.displayByCategory("Dairy");
        manager.displayByCategory("Fruits");

        // update quantity
        manager.updateQuantity("Milk", 0);
        manager.updateQuantity("Apples", 10);

        // display updated list
        manager.displayAvailableItems();
        manager.calculateTotalCost();
    }
}
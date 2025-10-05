// 8.2_task2 购物车
import java.util.HashMap;
import java.util.Map;

/**
 * ShoppingCart class represents a shopping cart in an e-commerce application.

 */
public class ShoppingCart {
    private Map<String, Double > items;   //我们在声明时用接口（Map）可以方便以后切换其他实现（比如 TreeMap、LinkedHashMap），

/**
     * Constructor to initialize the shopping cart.
     */
    public ShoppingCart() {
        items = new HashMap<>();
    }
    /**
     * Adds an item to the cart.
     * @param itemName The name of the item.
     * @param price The price of the item.
     */
    public void addItem(String itemName, double price) {
        items.put(itemName, price);

    }
    /**
     * Removes an item from the cart.
     * @param itemName The name of the item to be removed.
     */
    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    // ✅ 新增：判断购物车是否包含某个商品
    public boolean hasItem(String itemName) {
        return items.containsKey(itemName);
    }


    public double calculateTotal() {
        double total = 0.0;
        for (double price : items.values()) {      //for (类型 变量名 : 可迭代对象)“把 items.values() 里的每一个价格依次取出来，存进变量 price
            total += price;
        }
        return total;
    }
}

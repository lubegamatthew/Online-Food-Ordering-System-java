import java.util.ArrayList;
import java.util.List;

class Order {
    private String customerName;
    private List<FoodItem> items;
    
    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }
    
    public void addItem(FoodItem item) {
        items.add(item);
    }
    
    public double getTotal() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getFinalPrice();
        }
        return total;
    }
    
    public void printOrder() {
        System.out.println("Order for: " + customerName);
        System.out.println();
        for (FoodItem item : items) {
            System.out.println("  " + item.getDescription());
        }
        System.out.println();
        System.out.println("Total: " + getTotal());
    }
    
    public static void main(String[] args) {
        Order order = new Order("Alice");
        order.addItem(new Burger("Cheeseburger", 300, true));
        order.addItem(new Pizza("Margherita", 400, "Medium"));
        order.addItem(new Drink("Coke", 100, "Large"));
        order.printOrder();
    }
}

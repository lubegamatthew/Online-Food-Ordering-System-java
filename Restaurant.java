import java.util.ArrayList;
import java.util.List;

class Restaurant {
    private String name;
    private List<FoodItem> menu;
    
    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }
    
    public void addToMenu(FoodItem item) {
        menu.add(item);
    }
    
    public void displayMenu() {
        System.out.println("=== " + name + " Menu ===");
        for (FoodItem item : menu) {
            System.out.println("  " + item.getDescription());
        }
        System.out.println();
    }
    
    public Order createOrder(String customerName, List<String> itemNames) {
        Order order = new Order(customerName);
        for (String itemName : itemNames) {
            boolean found = false;
            for (FoodItem item : menu) {
                if (itemName.equals(item.getClass().getSimpleName())) {
                    order.addItem(item);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Item '" + itemName + "' not found on menu, skipping.");
            }
        }
        return order;
    }
}

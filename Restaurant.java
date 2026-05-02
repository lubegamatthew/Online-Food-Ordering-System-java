import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("*** " + name + " Menu ***");
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
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter restaurant name: ");
        String restaurantName = scanner.nextLine();
        Restaurant restaurant = new Restaurant(restaurantName);
        
        restaurant.addToMenu(new Burger("Burger", 300, false));
        restaurant.addToMenu(new Burger("Cheeseburger", 300, true));
        restaurant.addToMenu(new Pizza("Pizza", 400, "Small"));
        restaurant.addToMenu(new Pizza("Pizza", 400, "Medium"));
        restaurant.addToMenu(new Pizza("Pizza", 400, "Large"));
        restaurant.addToMenu(new Drink("Cola", 100, "Regular"));
        restaurant.addToMenu(new Drink("Cola", 100, "Large"));
        
        restaurant.displayMenu();
        
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        
        System.out.println("\nMenu:");
        restaurant.displayMenu();
        
        List<String> orderedItems = new ArrayList<>();
        while (true) {
            System.out.print("Enter item name (or 'done' to finish): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            orderedItems.add(input);
        }
        
        Order order = restaurant.createOrder(customerName, orderedItems);
        System.out.println();
        order.printOrder();
        
        scanner.close();
    }
}

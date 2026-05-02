public class Demo {
    public static void main(String[] args) {
        Order order = new Order("Alice");
        order.addItem(new Burger("Cheeseburger", 300, true));
        order.addItem(new Pizza("Margherita", 400, "Medium"));
        order.addItem(new Drink("Coke", 100, "Large"));
        order.printOrder();
    }
}

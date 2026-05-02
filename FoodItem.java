abstract class FoodItem {
    // FOOD ITEM CLASS
    protected String name;
    protected double basePrice;
    
    public FoodItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }
    
    public abstract double getFinalPrice();
    public abstract String getDescription();
}

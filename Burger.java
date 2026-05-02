class Burger extends FoodItem {
    private boolean hasCheese;
    
    public Burger(String name, double basePrice, boolean hasCheese) {
        super(name, basePrice);
        this.hasCheese = hasCheese;
    }
    
    @Override
    public double getFinalPrice() {
        return hasCheese ? basePrice + 50 : basePrice;
    }
    
    @Override
    public String getDescription() {
        if (hasCheese) {
            return name + " (with cheese): " + getFinalPrice();
        } else {
            return name + ": " + getFinalPrice();
        }
    }
}

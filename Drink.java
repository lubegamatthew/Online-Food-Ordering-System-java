class Drink extends FoodItem {
    private String size; // "Regular", "Large"
    
    public Drink(String name, double basePrice, String size) {
        super(name, basePrice);
        this.size = size;
    }
    
    @Override
    public double getFinalPrice() {
        switch (size.toLowerCase()) {
            case "regular": return basePrice;
            case "large": return basePrice * 1.4;
            default: return basePrice;
        }
    }
    
    @Override
    public String getDescription() {
        return name + " (" + size + "): " + getFinalPrice();
    }
}

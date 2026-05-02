class Pizza extends FoodItem {
    private String size; // "Small", "Medium", "Large"
    
    public Pizza(String name, double basePrice, String size) {
        super(name, basePrice);
        this.size = size;
    }
    
    @Override
    public double getFinalPrice() {
        switch (size.toLowerCase()) {
            case "small": return basePrice;
            case "medium": return basePrice * 1.3;
            case "large": return basePrice * 1.6;
            default: return basePrice;
        }
    }
    
    @Override
    public String getDescription() {
        return name + " (" + size + "): " + getFinalPrice();
    }
}

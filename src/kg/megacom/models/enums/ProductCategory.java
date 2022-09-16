package kg.megacom.models.enums;

public enum ProductCategory {
    DAIRY ("Молочные продукты"),
    FRUIT("Фрукты"),
    BEVERAGES ("Напитки"),
    VEGETABLES ("Овощи");

    private String val;
    ProductCategory(String val){
    this.val = val;
}

    public String getVal() {
        return val;
    }
}

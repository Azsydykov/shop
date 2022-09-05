package kg.megacom.enums;

public enum ProductCategory {
    DAIRY ("Молочные продукты"),
    FRUIT("Фрукты"),
    BEVERAGES ("Напитки"),
    VEGETABLES ("Овощи");

private String name;

ProductCategory(String name){
    this.name = name;
}

    @Override
    public String toString() {
        return name;
    }
}

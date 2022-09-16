package kg.megacom.models;

import kg.megacom.models.enums.MeasureType;
import kg.megacom.models.enums.ProductCategory;

public class Apple extends Product {
    public Apple(String name, double cost, MeasureType measureType, ProductCategory category) {
        super(name, cost, measureType, category);
    }

    public Apple() {
    }
}

package kg.megacom.models;

import kg.megacom.models.Product;
import kg.megacom.models.enums.MeasureType;
import kg.megacom.models.enums.ProductCategory;

public class Water extends Product {
    public Water(String name, double cost, MeasureType measureType, ProductCategory category) {
        super(name, cost, measureType, category);
    }

    public Water() {
    }
}

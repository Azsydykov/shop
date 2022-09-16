package kg.megacom.models;

import kg.megacom.models.enums.MeasureType;
import kg.megacom.models.enums.ProductCategory;

public class Pear extends Product {
    public Pear(String name, double cost, MeasureType measureType, ProductCategory category) {
        super(name, cost, measureType, category);
    }

    public Pear() {
    }

}

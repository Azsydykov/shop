package kg.megacom.service;


import kg.megacom.models.Cashier;
import kg.megacom.models.Order;
import kg.megacom.models.Receipt;
import kg.megacom.models.Product;

public interface Operation {
    Receipt getReceipt (Order order);
    void getCategory();
    Product[] getProductByCategory(String category);
    Product getProductByName (String productName);
    Cashier getCashierByName (String cashier);

   double getInt(String message);
    boolean checkAnswer();
}

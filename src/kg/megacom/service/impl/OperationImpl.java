package kg.megacom.service.impl;

import kg.megacom.models.*;
import kg.megacom.models.enums.ProductCategory;
import kg.megacom.models.enums.MeasureType;
import kg.megacom.service.Operation;

import java.util.InputMismatchException;
import java.util.Scanner;


public class OperationImpl implements Operation {
    Sugar sugar = new Sugar("Сахар", 90, MeasureType.Kg, ProductCategory.DAIRY);
    Water water = new Water("Легенда", 25, MeasureType.L, ProductCategory.BEVERAGES);
    Tomato tomato = new Tomato("Помидор", 45, MeasureType.Kg, ProductCategory.VEGETABLES);
    Apple apple = new Apple("Яблоко", 110, MeasureType.Kg, ProductCategory.FRUIT);
    Pear pear = new Pear("Груша", 100, MeasureType.Kg, ProductCategory.FRUIT);

    Cashier aibek = new Cashier("Aibek", "aiba", 24);
    Cashier jibek = new Cashier("Jibek", "jiba", 22);

    Product[] products = {sugar, water, tomato, apple, pear};
    Cashier[] cashiers = {aibek, jibek};

    Scanner scanner = new Scanner(System.in);

    @Override
    public Receipt getReceipt(Order order) {

        Receipt receipt = new Receipt();
        Details[] details = order.getDetails();

        double totalSum = 0;
        double totalDiscount = 0;
        ReceiptDetails[] receiptDetails = new ReceiptDetails[10];


        for (int i = 0; i < details.length; i++) {
            if (details[i] != null) {
                Product product = details[i].getProduct();

                double cost = product.getCost() * details[i].getAmount();
                double discount = (cost * details[i].getDiscount()) / 100;
                totalSum = totalSum + (cost - discount);
                totalDiscount = totalDiscount + discount;

                receiptDetails[i] = new ReceiptDetails(product.getName(), cost - discount);
            }
        }
        for (ReceiptDetails item : receiptDetails) {
            System.out.println(item);

            receipt.setName(order.getCashier().getName());
            receipt.setTotalDiscount(totalDiscount);
            receipt.setReceiptDetails(receiptDetails);
            receipt.setTotalSum(totalSum);

        }
        return receipt;
    }

    @Override
    public void getCategory() {
        for (ProductCategory item : ProductCategory.values()) {
            System.out.println(item);
        }
    }

    @Override
    public Product[] getProductByCategory(String category) {

        Product[] result;
        result = new Product[10];

        int j = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getCategory().equals(ProductCategory.valueOf(category))) {
                {
                    result[j] = products[i];
                    j++;
                }
            }
        }
        return result;

    }

    @Override
    public Product getProductByName(String productName) {
        try {
            for (Product item : products) {
                if (productName.equals(item.getName())) {
                    return item;
                }
            }
            return null;
        } catch (InputMismatchException exception) {
            System.out.println("Не верно ввели данные");
            throw new MyExeption(exception.getMessage());
        }
    }

    @Override
    public Cashier getCashierByName(String cashierName) {

        for (Cashier item : cashiers) {
            if (item.getName().equals(cashierName)) {
                return item;
            }
        }
        return null;
    }

    private boolean checkNumber(String text) {
        try {
            double value = Double.parseDouble(text);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public double getInt(String message) {
        System.out.println(message);
        String number = scanner.nextLine();
        while (!checkNumber(number)) {
            System.out.println("Не верный ввод.");
            System.out.println(message);
            number = scanner.nextLine();
        }
        return Double.parseDouble(number);
    }

    @Override
    public boolean checkAnswer() {
        System.out.println("Продолжаете? 1 нет, 0 да");
        String answer = String.valueOf(scanner.nextByte());
        if(answer.equals("0")){
            return true;
        } else if (answer.equals("1")) {
            return false;
        }else {
            return checkAnswer();
        }
    }
}
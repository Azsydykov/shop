package kg.megacom;

import kg.megacom.models.*;
import kg.megacom.service.Operation;
import kg.megacom.service.impl.OperationImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Operation operation = new OperationImpl();
        boolean answer = true;
        int count = 0;
        //  System.out.println(count);
        Details[] details = new Details[10];

        System.out.println("Добро пожаловать");


        while (answer !=false) {
            System.out.println("Выберите категорию продуктов");
            operation.getCategory();
            String category = scanner.next();
            Product[] products;

            try {
                products = operation.getProductByCategory(category);

            } catch (IllegalArgumentException exception) {
                System.out.println("Не верно ввели данные, прошу повторить");
                continue;
            }
            Product product = null;
            while (true) {
                System.out.println("Выберите продукт ");
                for (Product item : products) {
                    if (item != null)
                        item.getInfo();
                }
                String productName = scanner.next();
                product = operation.getProductByName(productName);
                if (product != null)
                    break;
                else System.out.println("Такого продукта нет ");
            }

            double amount = operation.getInt("Введите количество: ");
            double discount = operation.getInt("Укажите скидку: ");


            Details detail = new Details(product, amount, discount);
            details[count] = detail;

          //  operation.checkAnswer();
             answer = operation.checkAnswer();
          //  System.out.println("Хотите продолжить? 0->да, 1->нет");
        //    answer = scanner.nextByte();

            count++;
        }

        for (Details item : details) {
            if (item != null)
                System.out.println(item);
        }


        Cashier cashier = null;

        while (true) {
            try{System.out.println("Выберите кассира");

                String cashierName = scanner.next();
                cashier = operation.getCashierByName(cashierName);
            }catch (Exception e){
                System.out.println("Не верно ввели данные, прошу повторить");
            }
            if (cashier != null)
                break;
            else System.out.println("Не верно ввели имя, прошу повторить");
        }
        Order order = new Order();
        order.setDetails(details);
        order.setCashier(cashier);

        Receipt receipt = operation.getReceipt(order);
        System.out.println(receipt);

    }
}





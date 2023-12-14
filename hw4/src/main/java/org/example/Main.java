package org.example;


import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Buyer b1 = new Buyer("Ivan", "Ivanov", 25, "89224564444");
        Buyer b2 = new Buyer("Ivan", "Petrov", 30, "89224564455");
        Buyer[] buyers = {b1, b2};
        Product p1 = new Product("Iphone 15 128GB", 150000.00);
        Product p2 = new Product("Iphone 14 128GB", 130000.00);
        Product p3 = new Product("Iphone 13 128GB", 110000.00);
        Product p4 = new Product("Iphone 12 128GB", 90000.00);
        Product p5 = new Product("Iphone 11 128GB", 70000.00);
        Product[] products = {p1, p2, p3, p4, p5};
        Order[] orders = new Order[5];

        try {
            //Order order = buy(buyers[0],products[1], 15, buyers, products);
            Order order = buy(new Buyer("Ivan", "Ivanov", 30, "89224564444"), products[1], 15, buyers, products);
            //Order order = buy(new Buyer("Ivan", "Ivanov", 30, "89224564444"), products[1], 105, buyers, products);
            //Order order = buy(new Buyer("Ivan", "Ivanov", 30, "89224564444"), new Product("Iphone 14 128GB", 130000.00), 105, buyers, products);
            orders[0] = order;
        }
        catch (ProductException | AmountException | CustomerException e)
        {
            e.printStackTrace();
        }
        try {
            Order order = buy(buyers[0],products[1], 15, buyers, products);
            orders[1] = order;
        }
        catch (ProductException | AmountException | CustomerException e)
        {
            e.printStackTrace();
        }
        try {
            Order order = buy(buyers[0],products[1], 15, buyers, products);
            orders[2] = order;
        }
        catch (ProductException | AmountException | CustomerException e)
        {
            e.printStackTrace();
        }

        int count = 0;
        for (int i = 0; i < orders.length; i++)
        {
            if(orders[i] != null)
            {
                count += 1;
            }
        }

        System.out.println(String.format("Валидных заказаов %s", count));




    }
    public static Order buy(Buyer buyer, Product product, int quantity, Buyer[] arrOfBuyers, Product[] arrOfProducts) throws CustomerException, ProductException, AmountException{
        if(quantity < 0)
        {
            throw new AmountException("Малое количество");
        }
        if(quantity > 100)
        {
            throw new AmountException("Большое количество");
        }
        if(!Arrays.asList(arrOfProducts).contains(product))
        {
            throw new ProductException("Продукт не найден!");
        }
        if(!Arrays.asList(arrOfBuyers).contains(buyer))
        {
            throw new CustomerException("Покупатель не найден!");
        }
        return new Order(buyer, product, quantity);






    }


}
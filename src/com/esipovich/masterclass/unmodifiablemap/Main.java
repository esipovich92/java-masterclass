package com.esipovich.masterclass.unmodifiablemap;

import java.util.Map;

/**
 * @author Artem Esipovich 11.04.2018
 */

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);


        Basket timsBasket = new Basket("Tim");
        addToBasket(timsBasket, "car", 1);
//        System.out.println(timsBasket);

        addToBasket(timsBasket, "car", 1);
//        System.out.println(timsBasket);

        /*if(addToBasket(timsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }*/

        addToBasket(timsBasket, "spanner", 5);
//        System.out.println(timsBasket);

        addToBasket(timsBasket, "juice", 4);
        addToBasket(timsBasket, "cup", 12);
        addToBasket(timsBasket, "bread", 1);

        System.out.println(timsBasket);

        System.out.println(stockList);


        checkoutBasket(timsBasket);

        System.out.println(stockList);

    }

    public static int addToBasket(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.reserveItem(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public static void unreserve(Basket basket, String item, int quantity) {
        StockItem stockItem = basket.getItemByName(item);
        if (stockItem == null) {
            System.out.println("There is no such item in the basket!");
            return;
        }
        if (stockItem.getReserved() < quantity) {
            System.out.println("There reserved quantity is lees than suggested!");
            return;
        }

        basket.unreserveItem(stockItem, quantity);
        System.out.println("Item " + stockItem.getName() + " was unreserved on " + quantity);
    }

    public static void checkoutBasket(Basket basket) {
        Map<StockItem, Integer> items = basket.Items();
        StockItem stockItem;

        for (Map.Entry<StockItem, Integer> itemToSell : items.entrySet()) {
            stockItem = itemToSell.getKey();
            stockList.sellStock(stockItem.getName(), stockItem.getReserved());
        }
        basket.cleanBasket();
        System.out.println("Stocks from " + basket.getName() + " basket are sold");
    }
}

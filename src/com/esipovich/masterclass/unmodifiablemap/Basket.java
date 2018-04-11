package com.esipovich.masterclass.unmodifiablemap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Artem Esipovich 11.04.2018
 */

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    public StockItem getItemByName(String item) {
        for (Map.Entry<StockItem, Integer> itemToReturn : list.entrySet()) {
            if (itemToReturn.getKey().getName().equals(item)) {
                return itemToReturn.getKey();
            }
        }
        return null;
    }

    public void unreserveItem(StockItem stockItem, int quantity) {
        stockItem.unreserveStock(quantity);
    }

    public void cleanBasket() {
        this.list.clear();
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}

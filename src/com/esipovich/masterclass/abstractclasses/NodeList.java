package com.esipovich.masterclass.abstractclasses;

/**
 * @author Artem Esipovich 09.04.2018
 */

public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}

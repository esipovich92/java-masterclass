package com.esipovich.masterclass.abstractclasses;

/**
 * @author Artem Esipovich 09.04.2018
 */

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.nextItem;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.nextItem = item;
        return this.nextItem;
    }

    @Override
    ListItem previous() {
        return this.previous();
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.previousItem = item;
        return this.previousItem;
    }

    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }
}

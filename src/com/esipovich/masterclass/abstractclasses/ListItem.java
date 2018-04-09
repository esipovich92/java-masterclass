package com.esipovich.masterclass.abstractclasses;

/**
 * @author Artem Esipovich 09.04.2018
 */

public abstract class ListItem {

    protected ListItem nextItem;
    protected ListItem previousItem;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

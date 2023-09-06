/**
 * EXERCISE 7.18 Challenge: A list is a sequential data structure. Design a List class that uses a
 * comma-delimited String—such as, “a,b,c,d,12,dog”—to imple- ment a list. Implement the following
 * methods for this class:
 * 
 * void addItem(Object o); // Use Object.toString()
 * 
 * String getItem(int position);
 * 
 * String toString();
 * 
 * void deleteItem(int position);
 * 
 * void deleteItem(String item);
 * 
 * int getPosition(String item);
 * 
 * String getHead(); // First element
 * 
 * List getTail(); // All but the first element
 * 
 * int length(); // Number of items
 */


package chapter07;

import java.util.Arrays;

public class StringList {
    private String items;
    private int length;

    public StringList() {
        this.items = "";
        this.length = 0;
    }

    public StringList(String items) {
        this.items = items;
        this.length = items.split(",").length;
    }

    public void addItem(Object o) {
        this.items += o.toString() + ",";
        this.length++;
    }

    public String getItem(int position) {
        return this.items.split(",")[position];
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        String[] itemsArray = this.items.split(",");

        for (int i = 0; i < itemsArray.length; i++) {
            buffer.append("[" + i + "] " + itemsArray[i] + ',');
        }
        return buffer.toString();
    }

    public void deleteItem(int position) {
        StringBuffer buffer = new StringBuffer();
        String[] itemsArray = this.items.split(",");

        for (int i = 0; i < itemsArray.length; i++) {
            if (i != position) {
                buffer.append(itemsArray[i] + ',');
            } else {
                this.length--;
            }
        }
        this.items = buffer.toString();
    }

    public void deleteItem(String item) {
        deleteItem(getPosition(item));
    }

    public int getPosition(String item) {
        return Arrays.asList(this.items.split(",")).indexOf(item);
    }

    public String getHead() {
        return this.getItem(0);
    }

    public StringList getTail() {
        // + 1 because of the comma separating the head from the tail
        String tailItems = this.items.substring(this.getHead().length() + 1);
        return new StringList(tailItems);
    }

    public int length() {
        return this.length;
    }
}

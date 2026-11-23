package com.ritik.wishlist.structure;

import com.ritik.wishlist.model.WishlistItem;

public class WishlistLinkedList implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Node<WishlistItem> head;
    private Node<WishlistItem> tail;
    private int size;

    public void add(WishlistItem item) {
        Node<WishlistItem> node = new Node<>(item);
        if (head == null) head = tail = node;
        else { tail.next = node; tail = node; }
        size++;
    }

    public WishlistItem findById(String id) {
        Node<WishlistItem> current = head;
        while (current != null) {
            if (current.data.getId().equalsIgnoreCase(id)) return current.data;
            current = current.next;
        }
        return null;
    }

    public WishlistItem findByName(String name) {
        Node<WishlistItem> current = head;
        while (current != null) {
            if (current.data.getName().equalsIgnoreCase(name)) return current.data;
            current = current.next;
        }
        return null;
    }

    public boolean remove(String id) {
        if (head == null) return false;
        if (head.data.getId().equalsIgnoreCase(id)) {
            head = head.next;
            size--;
            if (head == null) tail = null;
            return true;
        }
        Node<WishlistItem> previous = head;
        Node<WishlistItem> current = head.next;
        while (current != null) {
            if (current.data.getId().equalsIgnoreCase(id)) {
                previous.next = current.next;
                if (current == tail) tail = previous;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node<WishlistItem> current = head;
            while (current.next != null) {
                double a = current.data.getPrice();
                double b = current.next.data.getPrice();
                if ((ascending && a > b) || (!ascending && a < b)) {
                    WishlistItem temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void display() {
        if (head == null) { System.out.println("Your wishlist is empty."); return; }
        System.out.println("ID     | ITEM                     | UNIT PRICE         | CATEGORY       | QTY | LINE TOTAL");
        System.out.println("------------------------------------------------------------------------------------------------------");
        Node<WishlistItem> current = head;
        while (current != null) { System.out.println(current.data); current = current.next; }
    }

    public void displayCategory(String category) {
        Node<WishlistItem> current = head;
        boolean found = false;
        while (current != null) {
            if (current.data.getCategory().equalsIgnoreCase(category)) {
                if (!found) System.out.println("ID     | ITEM                     | UNIT PRICE         | CATEGORY       | QTY | LINE TOTAL");
                System.out.println(current.data);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No items found in category: " + category);
    }

    public double getTotalCost() {
        double total = 0;
        Node<WishlistItem> current = head;
        while (current != null) { total += current.data.getLineTotal(); current = current.next; }
        return total;
    }

    public int getSize() { return size; }
    public Node<WishlistItem> getHead() { return head; }
}

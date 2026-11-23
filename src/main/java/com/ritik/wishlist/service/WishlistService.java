package com.ritik.wishlist.service;

import com.ritik.wishlist.model.WishlistItem;
import com.ritik.wishlist.structure.Node;
import com.ritik.wishlist.structure.WishlistLinkedList;

public class WishlistService {
    private final WishlistLinkedList wishlist;
    private int nextId = 101;

    public WishlistService(WishlistLinkedList wishlist) {
        this.wishlist = wishlist;
        Node<WishlistItem> current = wishlist.getHead();
        while (current != null) {
            String id = current.data.getId();
            if (id.matches("W\\d+")) {
                try { nextId = Math.max(nextId, Integer.parseInt(id.substring(1)) + 1); }
                catch (NumberFormatException ignored) { }
            }
            current = current.next;
        }
    }

    public WishlistItem add(String name, double price, String category, int quantity) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Item name cannot be empty.");
        if (price <= 0) throw new IllegalArgumentException("Price must be greater than zero.");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be greater than zero.");
        if (wishlist.findByName(name.trim()) != null) throw new IllegalArgumentException("This item already exists in your wishlist.");
        WishlistItem item = new WishlistItem(String.format("W%03d", nextId++), name.trim(), price, category.trim(), quantity);
        wishlist.add(item);
        return item;
    }

    public WishlistLinkedList getWishlist() { return wishlist; }
}

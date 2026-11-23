package com.ritik.wishlist.structure;

public class Node<T> implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    public T data;
    public Node<T> next;
    public Node(T data) { this.data = data; }
}

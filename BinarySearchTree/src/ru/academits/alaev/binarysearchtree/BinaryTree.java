package ru.academits.alaev.binarysearchtree;


import java.util.Comparator;

public class BinaryTree<T extends Number> {
    private TreeNode<T> root;
    private int size;
    private Comparator<T> comparator; // Объект компаратор. У него метод compare, чтобы сравнивать объекты.

// Конструктор с компаратором
    public BinaryTree(Comparator<T> comparator) {
        this.root = null;
        this.size = 0;
        this.comparator = comparator;
    }

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void add(TreeNode<T> node) {
        //noinspection unchecked
        Comparable<T> x = (Comparable<T>) node.getData();
        if (root == null){
            root = node;
        } else if (x.compareTo(this.root.getData()) < 0){
            root.setLeft(node);
        } else if (x.compareTo(this.root.getData()) > 0){
            root.setRight(node);
        }
    }
}


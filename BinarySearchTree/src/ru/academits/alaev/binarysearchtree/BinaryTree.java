package ru.academits.alaev.binarysearchtree;


import java.util.Comparator;
import java.util.LinkedList;

public class BinaryTree<T> {
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

    public boolean add(TreeNode<T> node) {
        if (root == null) {
            root = node;
            return true;
        }
        //Текущим узлом считаем корень
        TreeNode<T> currentNode = root;

        //noinspection unchecked
        Comparable<T> x = (Comparable<T>) node.getData();
        boolean condition = true;
        while (condition) {
            if (x.compareTo(currentNode.getData()) <= 0) {
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode.setLeft(node);
                    condition = false;
                }
            } else {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();
                } else {
                    currentNode.setRight(node);
                    condition = false;
                }
            }
        }
        return true;
    }
}





















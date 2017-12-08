package ru.academits.alaev.binarysearchtree;


import java.util.Comparator;


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

    public boolean add(T data) {
        TreeNode<T> node = new TreeNode<T>(data);
        if (root == null) {
            root = node;
            size++;
            return true;
        }
        //Текущим узлом считаем корень
        TreeNode<T> currentNode = root;
        if (comparator != null) {
            return true;
        } else {
            //noinspection unchecked
            Comparable<T> nodeData = (Comparable<T>) node.getData();
            while (true) {
                if (nodeData.compareTo(currentNode.getData()) < 0) {
                    if (currentNode.getLeft() != null) {
                        currentNode = currentNode.getLeft();
                    } else {
                        currentNode.setLeft(node);
                        size++;
                        return true;
                    }
                } else {
                    if (currentNode.getRight() != null) {
                        currentNode = currentNode.getRight();
                    } else {
                        currentNode.setRight(node);
                        size++;
                        return true;
                    }
                }
            }
        }
    }

    // Т.к. ищем узел, то и возвращаю узел
    public TreeNode<T> find(T data) {
        TreeNode<T> node = new TreeNode<T>(data);
        //Текущим узлом считаем корень
        TreeNode<T> currentNode = root;
        if (comparator != null) {
            return null;
        } else {
            //noinspection unchecked
            Comparable<T> nodeData = (Comparable<T>) node.getData();
            while (true) {
                if (nodeData.compareTo(currentNode.getData()) == 0) {
                    return currentNode;
                } else if ((nodeData.compareTo(currentNode.getData()) < 0)) {
                    if (currentNode.getLeft() != null) {
                        currentNode = currentNode.getLeft();
                    } else {
                        return null;
                    }
                } else {
                    if (currentNode.getRight() != null) {
                        currentNode = currentNode.getRight();
                    } else {
                        return null;
                    }
                }
            }
        }
    }
    public boolean removeNode(TreeNode<T> node) {
        //noinspection unchecked
        Comparable<T> nodeData = (Comparable<T>) node.getData();
        TreeNode<T> currentNode = root;
        boolean condition = true;
        while (condition) {
            if (nodeData.compareTo(currentNode.getData()) < 0) {
                TreeNode<T> nextNode = currentNode.getLeft();
                if (nextNode != null) {
                    if (nextNode.getData() != node.getData()) {
                        currentNode = nextNode;
                    } else {
                        if (nextNode.getLeft() == null && nextNode.getRight() == null) { //удаление листа
                            currentNode.setLeft(null);
                            size--;
                            condition = false;
                        } else if (nextNode.getLeft() != null && nextNode.getRight() != null) {//удаление узла с двумя детьми
                            TreeNode<T> minNode = findMin(nextNode.getRight());
                            minNode.setLeft(nextNode.getLeft());
                            minNode.setRight(nextNode.getRight());
                            currentNode.setLeft(minNode);
                            nextNode.getRight().setLeft(null);

                        } else if (nextNode.getLeft() != null) { // удаление узла с одним родителем слева
                            currentNode.setLeft(nextNode.getLeft());
                            size--;
                            condition = false;
                        } else if (nextNode.getRight() != null) {// удаление узла с одним родителем справа
                            currentNode.setLeft(nextNode.getRight());
                        }
                    }
                } else {
                    return false;
                }
            } else {
                TreeNode<T> nextNode = currentNode.getRight();
                if (nextNode != null) {
                    if (nextNode.getData() != node.getData()) {
                        currentNode = nextNode;
                    } else {
                        if (nextNode.getRight() == null && nextNode.getLeft() == null) {
                            currentNode.setRight(null);
                            size--;
                            condition = false;
                        } else if (nextNode.getLeft() != null && nextNode.getRight() != null) {
                            TreeNode<T> minNode = findMin(nextNode.getRight());
                            minNode.setLeft(nextNode.getLeft());
                            minNode.setRight(nextNode.getRight());
                            currentNode.setRight(minNode);
                            nextNode.getRight().setLeft(null);
                            size--;
                            condition = false;
                        } else if (nextNode.getRight() != null) {
                            currentNode.setRight(nextNode.getRight());
                            size--;
                            condition = false;
                        } else if (nextNode.getLeft() != null) {
                            currentNode.setRight(nextNode.getLeft());
                            size--;
                            condition = false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private TreeNode<T> findMin(TreeNode<T> minNode) {
        boolean condition = true;
        while (condition) {
            TreeNode<T> nextNode = minNode.getLeft();
            if (nextNode != null) {
                minNode = nextNode;
            } else {
                minNode.setLeft(null);
                condition = false;
            }
        }
        return minNode;
    }
}





















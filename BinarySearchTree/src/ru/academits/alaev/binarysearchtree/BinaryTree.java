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
        TreeNode<T> node = new TreeNode<>(data);
        if (root == null) {
            root = node;
            size++;
            return true;
        }
        //Текущим узлом считаем корень
        TreeNode<T> currentNode = root;
        while (true) {
            if (myCompare(node.getData(), currentNode.getData()) < 0) {
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

    // Т.к. ищем узел, то и возвращаю тоже узел
    public TreeNode<T> find(T data) {
        TreeNode<T> node = new TreeNode<>(data);
        //Текущим узлом считаем корень
        TreeNode<T> currentNode = root;
        //Проверка, что дерево пустое
        if (this.size == 0) {
            return null;
        }
        while (true) {
            if (myCompare(node.getData(), currentNode.getData()) <= 0) {
                if (currentNode.getData() == data) {
                    return currentNode;
                }
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

    public boolean removeNode(T data) {
        TreeNode<T> parent = null; // родитель удаляемого узла
        TreeNode<T> current = root; //
        TreeNode<T> node = new TreeNode<>(data); //удаляемый узел
        // цикл, такой же как при поиске
        while (true) {
            if (current != null) {
                if (myCompare(node.getData(), current.getData()) <= 0) {
                    if (current.getData() == data) {
                        break;
                    }
                    if (current.getLeft() != null) {
                        parent = current;
                        current = current.getLeft();
                    } else {
                        return false;
                    }
                } else {
                    if (current.getRight() != null) {
                        parent = current;
                        current = current.getRight();
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        // логика удаления узла
        if (current.getLeft() == null && current.getRight() == null) {  //удаление листа
            if (parent != null) {
                if (parent.getLeft() == current) {
                    parent.setLeft(null);
                    size--;
                } else {
                    parent.setRight(null);
                    size--;
                }
            }
            return true;
        } else if (current.getLeft() != null && current.getRight() != null) { //удаление узла с двумя детьми
            TreeNode<T> min = findMin(current.getRight(), current);
            min.setLeft(current.getLeft());
            min.setRight(current.getRight());
            size--;
            if (parent != null) {
                if (myCompare(min.getData(), parent.getData()) < 0) {
                    parent.setLeft(min);
                } else {
                    parent.setRight(min);
                }
            } else { // Удаление корня
                root = min;
            }
            return true;
        } else if (current.getLeft() != null && current.getRight() == null) { //Удаление узла с одним левым ребёнком
            if (parent != null) {
                parent.setRight(current.getLeft());
                size--;
                return true;
            }
        } else {    //Удаление узла с одним правым ребёнком
            if (parent != null) {
                parent.setRight(current.getRight());
                size--;
                return true;
            }
        }
        return false;
    }


    private TreeNode<T> findMin(TreeNode<T> current, TreeNode<T> parent) {
        if (current.getLeft() == null) {       // Минимальный - это правый ребёнок удаляемого
            parent.setRight(current.getRight());
            return current;
        } else {
            while (true) {
                if (current.getLeft() != null) {
                    parent = current;
                    current = current.getLeft();
                } else {        //Нашли минимальный рассмотрим 2 случая
                    if (current.getRight() == null) { // У минимального нет правого ребёнка
                        parent.setLeft(null);
                        return current;
                    } else {    // У минимального есть правый ребенок
                        parent.setLeft(current.getRight());
                        return current;
                    }
                }
            }
        }
    }

    private int myCompare(T o1, T o2) {
        if (this.comparator != null) {
            return this.comparator.compare(o1, o2);
        } else {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else {
                //noinspection unchecked
                Comparable<T> nodeData = (Comparable<T>) o1;
                return nodeData.compareTo(o2);
            }
        }
    }
}
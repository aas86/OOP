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

    // Т.к. ищем узел, то и возвращаю тоже узел по-моему логично
    public TreeNode<T> find(T data) {
        TreeNode<T> node = new TreeNode<T>(data);
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
        //TODO цикл, такой же как при поиске
        while (true) {
            if (current != null) {
                if (myCompare(node.getData(), current.getData()) <= 0) {
                    if (current.getData() == data) {
                        //parent = null;
                        break;
                    }
                    if (current.getLeft() != null) {
                        parent = current;
                        current = current.getLeft();
                    } else {
                        return false;
                        //   parent = null;
                        //   current = null;
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
        //TODO логика удаления узла
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
        } else if (current.getLeft() != null && current.getRight() != null) { // Удаление узла с 2мя детьми
            if (current.getRight().getLeft() == null) { //Если левый узел правого поддерева отсутствует
                current.setData(current.getRight().getData());
                current.setRight(current.getRight().getRight());
                size--;
                return true;
            } else {                                    //Если левый узел правого поддерева есть
                TreeNode<T> minNode = findMin(current.getRight());
                removeNode(minNode.getData());
                current.setData(minNode.getData());
                return true;
            }
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


    private TreeNode<T> findMin(TreeNode<T> current) {
        //  TreeNode<T> parent = null;
        while (true) {
            TreeNode<T> next = current.getLeft();
            if (next != null) {
                //    parent = current;
                current = next;
            } else {//Нашли минимальный
                return current;
            }
        }
    }

    private int myCompare(T o1, T o2) {
        if (this.comparator != null) {
            return this.comparator.compare(o1, o2);
        } else {
            if (o1 == null) {
                throw new NullPointerException("Не может в дереве быть элемент null!");
            }
            //noinspection unchecked
            Comparable<T> nodeData = (Comparable<T>) o1;
            return nodeData.compareTo(o2);
        }
    }
}





















package ru.academits.alaev.binarysearchtree;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Predicate;


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
            if (myCompare(node.getData(), currentNode.getData()) <= 0) {
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
            int comparisonResult = myCompare(node.getData(), currentNode.getData());
            if (comparisonResult == 0) {
                return currentNode;
            } else if (comparisonResult < 0) {
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
                int comparisonResult = myCompare(node.getData(), current.getData());
                if (comparisonResult == 0) {
                    break;
                } else if (comparisonResult < 0) {
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
            } else {
                root = null;
                size--;
            }
            return true;
        } else if (current.getLeft() != null && current.getRight() != null) { //удаление узла с двумя детьми
            TreeNode<T> min = findMin(current.getRight(), current);
            min.setLeft(current.getLeft());
            min.setRight(current.getRight());
            size--;
            if (parent != null) {
                if (myCompare(min.getData(), parent.getData()) <= 0) {
                    parent.setLeft(min);
                } else {
                    parent.setRight(min);
                }
            } else { // Удаление корня
                root = min;
            }
            return true;
        } else if (current.getLeft() != null && current.getRight() == null) { //Удаление узла с одним левым ребёнком
            if (parent != null && current == parent.getRight()) {
                parent.setRight(current.getLeft());
                size--;
                return true;
            } else if (parent != null && current == parent.getLeft()) {
                parent.setLeft(current.getLeft());
                size--;
                return true;
            } else {
                root = current.getLeft();
                size--;
                return true;
            }
        } else {    //Удаление узла с одним правым ребёнком
            if (parent != null && current == parent.getRight()) {
                parent.setRight(current.getRight());
                size--;
                return true;
            } else if (parent != null && current == parent.getLeft()) {
                parent.setLeft(current.getRight());
                size--;
                return true;
            } else {
                root = current.getRight();
                size--;
                return true;
            }
        }
    }


    private TreeNode<T> findMin(TreeNode<T> current, TreeNode<T> parent) {
        if (current.getLeft() == null) {    // Минимальный - это правый ребёнок удаляемого (у него нет ребёнка слева)
            parent.setRight(current.getRight());
            return current;
        } else {
            while (true) {
                if (current.getLeft() != null) {
                    parent = current;
                    current = current.getLeft();
                } else {        // Нашли минимальный рассмотрим 2 случая
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

    private int myCompare(T o1, T o2) { //o1 - искомый; o2 - текущий
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

    // Обход вширину
    public void widthSearch(Consumer<T> someWork) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        queue.add(this.getRoot());
        while (queue.size() != 0) {
            TreeNode<T> element = queue.remove();
            someWork.accept(element.getData());
            if (element.getLeft() != null) {
                queue.add(element.getLeft());
            }
            if (element.getRight() != null) {
                queue.add(element.getRight());
            }
        }
    }

    // Обход в глубину с проделыванием какой либо работы над узлом. Какую работу делать, будет определяться в main'е
    // Т.е. в main'е при вызове этого метода, в качестве аргумента передастся объект анонимного класса (а можно
    // лямбда функцию передать), от которого вызовется его метод из main'а, который я переопределил, как мне нужно

    // В качестве аргумента принимает объект, реализующий интерфейс Consumer<T>. У этого интерфейса лишь один метод,
    // который я переопределил в main'е так, чтобы он печатал.
    public void depthSearch(Consumer<T> someWork) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode<T>> stack = new ArrayList<>();
        stack.add(this.getRoot());
        while (stack.size() != 0) {
            TreeNode<T> element = stack.remove(stack.size() - 1);
            someWork.accept(element.getData()); //Здесь вызывается та работа, которую нужно делать, т.е. по сути
            //вставляется кусок кода из переопределения метода accept.
            if (element.getRight() != null) {
                stack.add(element.getRight());
            }
            if (element.getLeft() != null) {
                stack.add(element.getLeft());
            }
        }
    }

    public void recursiveDepthSearch(Consumer<T> someWork) {
        TreeNode<T> e = root;
        visit(e, someWork);
    }

    private void visit(TreeNode<T> node, Consumer<T> someWork) {
        someWork.accept(node.getData());
        if (node.getLeft() != null) {
            visit(node.getLeft(), someWork);
        }
        if (node.getRight() != null) {
            visit(node.getRight(), someWork);
        }
    }
}
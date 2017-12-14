package ru.academits.alaev.main;

import ru.academits.alaev.binarysearchtree.BinaryTree;
import ru.academits.alaev.binarysearchtree.TreeNode;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        System.out.println(binaryTree.removeNode(3));
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(10);
        binaryTree.add(15);
        binaryTree.add(9);
        binaryTree.add(4);
        binaryTree.add(7);
      //  binaryTree.add(null);
        System.out.println("Размер дерева " + binaryTree.getSize());

        System.out.println("Поиск элемента в дереве");
        TreeNode<Integer> result = binaryTree.find(15);
        if (result != null) {
            System.out.println("Элемент x есть в дереве!");
        } else {
            System.out.println("Нет такого элемента в дереве!");
        }
    //    System.out.println(binaryTree.removeNode(null));
        System.out.println(binaryTree.removeNode(8));
        System.out.println(binaryTree.removeNode(100));
        System.out.println(binaryTree.removeNode(10));
        System.out.println(binaryTree.removeNode(8));
        System.out.println(binaryTree.removeNode(10));
        System.out.println(binaryTree.removeNode(15));
        System.out.println(binaryTree.removeNode(10));
        System.out.println(binaryTree.removeNode(10));
        System.out.println("Размер дерева " + binaryTree.getSize());


    }
}

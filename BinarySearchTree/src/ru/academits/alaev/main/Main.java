package ru.academits.alaev.main;

import ru.academits.alaev.binarysearchtree.BinaryTree;
import ru.academits.alaev.binarysearchtree.TreeNode;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(10);
        binaryTree.add(15);
        binaryTree.add(11);
        /*TreeNode<Integer> a = new TreeNode<>(8);
        TreeNode<Integer> b = new TreeNode<>(3);
        TreeNode<Integer> c = new TreeNode<>(10);
        TreeNode<Integer> d = new TreeNode<>(6);
        TreeNode<Integer> e = new TreeNode<>(2);
        TreeNode<Integer> f = new TreeNode<>(15);
        TreeNode<Integer> g = new TreeNode<>(9);
        TreeNode<Integer> h = new TreeNode<>(11);
        TreeNode<Integer> i = new TreeNode<>(4);*/
     /*   binaryTree.addNode(a);
        binaryTree.addNode(b);
        binaryTree.addNode(c);
        binaryTree.addNode(d);
        binaryTree.addNode(e);
        binaryTree.addNode(f);
        binaryTree.addNode(g);
        binaryTree.addNode(h);
        binaryTree.addNode(i);*/
        System.out.println("Размер дерева " + binaryTree.getSize());

        System.out.println("Поиск элемента в дереве");
        TreeNode<Integer> result = binaryTree.find(9);
        if (result != null) {
            System.out.println("Элемент x есть в дереве!");
        } else {
            System.out.println("Нет такого элемента в дереве!");
        }
        binaryTree.removeNode(3);
        /*binaryTree.removeNode(f);*/

    }
}

package ru.academits.alaev.main;

import ru.academits.alaev.binarysearchtree.BinaryTree;
import ru.academits.alaev.binarysearchtree.TreeNode;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        TreeNode<Integer> a = new TreeNode<>(8);
        TreeNode<Integer> b = new TreeNode<>(3);
        TreeNode<Integer> c = new TreeNode<>(10);
        TreeNode<Integer> d = new TreeNode<>(6);
        TreeNode<Integer> e = new TreeNode<>(2);
        TreeNode<Integer> f = new TreeNode<>(15);
        TreeNode<Integer> g = new TreeNode<>(9);
        TreeNode<Integer> h = new TreeNode<>(11);
        TreeNode<Integer> i = new TreeNode<>(4);
        binaryTree.addNode(a);
        binaryTree.addNode(b);
        binaryTree.addNode(c);
        binaryTree.addNode(d);
        binaryTree.addNode(e);
        binaryTree.addNode(f);
        binaryTree.addNode(g);
        binaryTree.addNode(h);
        binaryTree.addNode(i);
        System.out.println("Размер дерева" + binaryTree.getSize());
        TreeNode<Integer> x = new TreeNode<>(10);
        System.out.println("Поиск элемента " + x.getData() + " в дереве");
        TreeNode<Integer> result = binaryTree.findNode(x);
        if (result != null) {
            System.out.println("Элемент x есть в дереве!");
        } else {
            System.out.println("Нет такого элемента в дереве!");
        }
        binaryTree.removeNode(i);
        binaryTree.removeNode(f);

    }
}

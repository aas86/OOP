package ru.academits.alaev.main;

import ru.academits.alaev.binarysearchtree.BinaryTree;
import ru.academits.alaev.binarysearchtree.TreeNode;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        TreeNode<Integer> a = new TreeNode<>(8);
        TreeNode<Integer> b = new TreeNode<>(3);
        TreeNode<Integer> c = new TreeNode<>(10);
        TreeNode<Integer> d = new TreeNode<>(6);
        TreeNode<Integer> e = new TreeNode<>(2);
        TreeNode<Integer> f = new TreeNode<>(15);
        binaryTree.add(a);
        binaryTree.add(b);
        binaryTree.add(c);
        binaryTree.add(d);
        binaryTree.add(e);
        binaryTree.add(f);
        System.out.println(binaryTree.getSize());
    }
}

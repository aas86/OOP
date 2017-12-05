package ru.academits.alaev.main;

import ru.academits.alaev.binarysearchtree.BinaryTree;
import ru.academits.alaev.binarysearchtree.TreeNode;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        TreeNode<Integer> a = new TreeNode<>(8);
        binaryTree.add(a);
        TreeNode<Integer> b = new TreeNode<>(3);
        binaryTree.add(b);
        TreeNode<Integer> c = new TreeNode<>(10);
        binaryTree.add(c);


    }
}

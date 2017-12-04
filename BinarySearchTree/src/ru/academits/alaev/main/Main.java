package ru.academits.alaev.main;

import ru.academits.alaev.binarysearchtree.BinaryTree;
import ru.academits.alaev.binarysearchtree.NodesComparator;
import ru.academits.alaev.binarysearchtree.TreeNode;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(new NodesComparator<Integer>());
        TreeNode<Integer> a = new TreeNode<>(8);
        TreeNode<Integer> b = new TreeNode<>(3);
        TreeNode<Integer> c = new TreeNode<>(10);


       // binaryTree.add(b);


    }
}

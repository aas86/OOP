package ru.academits.alaev.binarysearchtree;


public class BinaryTree<T extends Number> {
    private TreeNode<T> root;
    private int size;


    public BinaryTree(NodesComparator<T> comparator){
        this.root = null;
        this.size = 0;


    }
    public BinaryTree(TreeNode<T> root) {
        this.root = root;
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

    public void add(TreeNode<T> node){

    }
}

package ru.academits.alaev.binarysearchtree;

public class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    public TreeNode (T data){
        this.data = data;
    }
    public TreeNode(T data, TreeNode<T> left){
        this.data = data;
        this.left = left;
    }
    public TreeNode(TreeNode<T> right, T data){
        this.data = data;
        this.right = right;
    }
    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft(){
        return this.left;
    }
    public void setLeft(TreeNode<T> left){
        this.left = left;
    }
    public TreeNode<T> getRight(){
        return this.right;
    }
    public void setRight(TreeNode<T> right){
        this.right = right;
    }

}

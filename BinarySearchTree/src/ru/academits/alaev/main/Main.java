package ru.academits.alaev.main;

import ru.academits.alaev.binarysearchtree.BinaryTree;
import ru.academits.alaev.binarysearchtree.TreeNode;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        // System.out.println(binaryTree.removeNode(3));
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(15);
        binaryTree.add(9);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(12);
        binaryTree.add(14);
        binaryTree.add(13);
        binaryTree.add(null);
        binaryTree.removeNode(2);
        binaryTree.removeNode(4);
        System.out.println("Размер дерева " + binaryTree.getSize());
        System.out.println("Поиск элемента в дереве");
        TreeNode<Integer> result = binaryTree.find(null);
        if (result != null) {
            System.out.println("Элемент x есть в дереве!");
        } else {
            System.out.println("Нет такого элемента в дереве!");
        }
        //    System.out.println(binaryTree.removeNode(null));
        TreeNode<Integer> result1 = binaryTree.find(null);
        if (result1 != null) {
            System.out.println("Элемент x есть в дереве!");
        } else {
            System.out.println("Нет такого элемента в дереве!");
        }
        System.out.println("Размер дерева " + binaryTree.getSize());
        System.out.println(binaryTree.removeNode(3));
        System.out.println("Размер дерева " + binaryTree.getSize());
        System.out.println(binaryTree.removeNode(100));
        System.out.println(binaryTree.removeNode(10));
        System.out.println(binaryTree.removeNode(8));
        System.out.println(binaryTree.removeNode(10));
        System.out.println(binaryTree.removeNode(15));
        System.out.println(binaryTree.removeNode(10));
        System.out.println(binaryTree.removeNode(10));
        System.out.println("Размер дерева " + binaryTree.getSize());
        //   binaryTree.removeNode(null);
        // Тут вместо x можно любое имя придумать. Тут x - это объект анонимного класса, реализующего интерфейс
        // Consumer<T>. Если бы для его создания нужны были бы параметры (для конструктора), то они бы передавались так
        // x(parameter). А вообще получается, что я в метод передаю функцию. Могу переопределить как хочу эту
        // функцию и тогда метод будет выполнять другую работу.
        System.out.println("Обход дерева в ширину");
        binaryTree.widthSearch(x -> System.out.print(x + " "));
        System.out.println();
        // Здесь то же самое, что и выше, но только сделано через анонимный класс. По alt + Enter переделывается в лямбду
        System.out.println("Обход дерева в глубину без рекурсии");
        binaryTree.depthSearch(new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.print(x + " ");
            }
        });
        System.out.println();
        System.out.println("Обход дерева в глубину с рекурсией");
        binaryTree.recursiveDepthSearch(x -> System.out.print(x + " "));
    }
}

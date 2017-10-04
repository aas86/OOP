package ru.academits.alaev.shapes;

public class Shapes {
    // длина стороны квадрата
    private double aSquare;
    // координаты точек треугольника
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    // стороны прямоугольника
    private double aRect;
    private double bRect;
    // радиус окружности
    private double r;

    public Shapes (double aSquare){
        this.aSquare = aSquare;
    }
    public Shapes(double r){
        this.r = r;
    }
    public Shapes (double x1, double y1, double x2, double y2, double x3, double y3){
        this.x1 = x1;
        this.x1 = y1;
        this.x1 = x2;
        this.x1 = y2;
        this.x1 = x3;
        this.x1 = y3;
    }
    public Shapes(double aRect, double bRect){
        this.aRect = aRect;
        this.bRect = bRect;
    }




}

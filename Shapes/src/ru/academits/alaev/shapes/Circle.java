package ru.academits.alaev.shapes;

public class Circle {
    private double radius;
    public Circle(double r){
        radius = r;
    }
    public double getWidth() {
        return 2 * radius;
    }
    public double getHeight() {
        return 2 * radius;
    }
    public double getArea(){
        return Math.PI * (radius * radius);
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}

package ru.academits.alaev.shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private double[] getSide() {
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double c = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        return new double[]{a, b, c};
    }

    public double getWidth() {
        double max = Math.max(Math.max(x1, x2), x3);
        double min = Math.min(Math.min(x1, x2), x3);
        return max - min;
    }

    public double getHeight() {
        double max = Math.max(Math.max(y1, y2), y3);
        double min = Math.min(Math.min(y1, y2), y3);
        return max - min;
    }

    public double getArea() {
        double[] side = getSide();
        if ((side[0] + side[1] <= side[2]) || (side[0] + side[2] <= side[1] || side[2] + side[1] <= side[0])) {
            return 0;
        } else {
            double p = (side[0] + side[1] + side[2]) / 2;
            return Math.sqrt(p * (p - side[0]) * (p - side[1]) * (p - side[2]));
        }
    }

    public double getPerimeter() {
        double[] side = getSide();
        return side[0] + side[1] + side[2];
    }
}

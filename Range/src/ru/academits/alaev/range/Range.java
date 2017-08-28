package ru.academits.alaev.range;

public class Range {
    private double from;
    private double to;

    private double getFrom() {
        return from;
    }

    private void setFrom(double from) {
        this.from = from;
    }

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public double getLength(){
        return this.to - this.from;
    }

    public static void main(String[] args) {
        double x = 2;
        Range point = new Range(10, 20);
        System.out.println("Is point in range? - " + point.isInside(x));
        System.out.println("Length is - " + point.getLength());
    }
}


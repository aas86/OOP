package ru.academits.alaev.range;

import com.sun.xml.internal.bind.v2.TODO;

public class Range {
    private double from;
    private double to;

    private double getFrom() {
        return from;
    }

    private double getTo() {
        return to;
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

    public double getLength() {
        return this.to - this.from;
    }

    public double getNewSegment(Range segment1, Range segment2) {
        if (segment1.from <= segment2.to && segment2.to >= segment1.from) {
            return ; // тут нужно ещё один объект вернуть например segment3? А как это сделать?
                     // В if вызвать конструктор?
        }else{
            return null; // а как вернуть null??
        }
    }

    public static void main(String[] args) {
        double x = 2;
        Range segment1 = new Range(10, 20);
        System.out.printf("Segment1: %f %f", segment1.getFrom(), segment1.getTo());
        System.out.println("Is point in range? - " + segment1.isInside(x));
        System.out.println("Length is - " + segment1.getLength());
        Range segment2 = new Range(5, 15);
        System.out.printf("Segment2: %f %f", segment2.getFrom(), segment2.getTo());
    }
}


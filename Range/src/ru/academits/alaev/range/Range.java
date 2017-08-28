package ru.academits.alaev.range;

import com.sun.xml.internal.bind.v2.TODO;

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

    public double getNewSegment(){
        //как то надо сюда 2 точки отправить и проверить условие
        // пересечения point.from <= point2.end && point2.end >= point.from
    }

    public static void main(String[] args) {
        double x = 2;
        Range point = new Range(10, 20);
        Range point2 = new Range(5, 15);
        System.out.println(point2.getFrom());
        System.out.println(point.getFrom());
        System.out.println("Is point in range? - " + point.isInside(x));
        System.out.println("Length is - " + point.getLength());

    }
}


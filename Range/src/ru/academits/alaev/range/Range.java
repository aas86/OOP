package ru.academits.alaev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }


    public boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public double getLength() {
        return this.to - this.from;
    }

    public Range getIntersection(Range segment1, Range segment2) {
        if (segment1.from <= segment2.to && segment2.to >= segment1.from) {
            return new Range(segment1.from, segment2.to); // Это же означает что метод возвращает новый объект класса Range,
            // если выполняется условие,
            // созданный конструктором с полями from = segment1.from и to = segment2.to ???
            // Или не правильно?
        } else {
            return null;
        }
    }
}


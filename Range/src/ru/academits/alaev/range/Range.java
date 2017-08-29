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
        if (segment1.from < segment2.to) {
            return new Range(segment1.from, segment2.to);
        } else if (segment2.from < segment1.to) {
            return new Range(segment2.from, segment1.to);
        } else if (segment1.from > segment2.from && segment1.to < segment2.to) {
            return segment1;
        } else if(segment2.from > segment1.from && segment2.to < segment1.to){
            return segment2;
        } else {
            return null;
        }
    }
}


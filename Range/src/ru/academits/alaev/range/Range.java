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

    public void setTo(double to) {
        this.to = to;
    }


    public boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public double getLength() {
        return this.to - this.from;
    }

    public Range getIntersection(Range segment2) {
        // Так как вызываю от segment1 (потому что метод не static),
        // то к полям объекта segment1 можно обратиться через this
        // а к полям объекта segment2 через объект, переданный в виде аргумента.
        // this можно не писать, но я оставил для понимания.
        // Т.о. получается, что через this я обращаюсь к полю объекта от которого вызвал метод.
        if ((this.from < segment2.to) && (this.to > segment2.from)) {
            return new Range(this.from, segment2.to);
        } else if ((segment2.from < this.to) && (segment2.to > this.from)) {
            return new Range(segment2.from, to);
        } else if (this.from > segment2.from && this.to < segment2.to) {
            return new Range(this.from, this.to);
        } else if (segment2.from > this.from && segment2.to < this.to) {
            return new Range(segment2.from, segment2.to);
        } else {
            return null;
        }
    }
}


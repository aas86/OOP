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
        if ((this.to <= segment2.from) || (segment2.to <= this.from)) {
            return null;
        } else if (segment2.from > this.from && segment2.to < this.to) {
            return new Range(segment2.from, segment2.to);
        } else if (this.from > segment2.from && this.to < segment2.to) {
            return new Range(this.from, this.to);
        } else if (segment2.to > this.to) {
            return new Range(segment2.from, this.to);
        } else {
            return new Range(this.from, segment2.to);
        }
    }

    public Range[] getConcatenation(Range segment2) {
        if ((this.to <= segment2.from) || (segment2.to <= this.from)) {
            Range[] result = new Range[2];
            // Т.к. 2 отрезка, то нужно вернуть массив из 2ух новых объектов
            // result - reference тип, а значит нужно указать на что ему ссылаться,
            // а ему нужно ссылаться на новый объект, который мы создаём конструктором
            result[0] = new Range(this.from, this.to);
            result[1] = new Range(segment2.from, segment2.to);
            return result; // Возвращаю массив result
        } else if (this.to < segment2.to) {
            Range[] result = new Range[1];
            result[0] = new Range(this.from, segment2.to);
            return result;
        } else {
            Range[] result = new Range[1];
            result[0] = new Range(segment2.from, this.to);
            return result;
        }
    }
}


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

    public Range[] getSum(Range segment2, int i) {
        if ((this.to <= segment2.from) || (segment2.to <= this.from)) {
            // В этом случае отрезки не пересекаются тогда сумма будет состоять из двух
            // отрезков, следовательно я возвращаю массив из двух новых объектов класса Range. А как их заполнить
            // нужными значениями? Циклом не получается, тогда заполняю вручную поэлементно.
            // Но что-то подсказывает, что не правильно.
            // и что - то не могу сообразить, как напечатать потом из main результат.

            Range[] result = new Range[2];
            result[0].setFrom(this.from);
            result[0].setTo(this.to);
            result[1].setFrom(segment2.from);
            result[1].setTo(segment2.to);
            return result; // Возвращаю массив result
        } else if (this.to < segment2.to) {
            Range[] result = new Range[1];
            result[0].setFrom(this.from);
            result[0].setTo(segment2.to);
            return result;
        } else {
            Range[] result = new Range[1];
            result[0].setFrom(segment2.from);
            result[0].setTo(this.to);
            return result;
        }
    }
}


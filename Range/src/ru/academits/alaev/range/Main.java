package ru.academits.alaev.range;

public class Main {
    public static void main(String[] args) {
        double x = 2;
        Range segment1 = new Range(10, 20);
        System.out.printf("Segment1: %f %f", segment1.getFrom(), segment1.getTo());
        System.out.println("Is point in range? - " + segment1.isInside(x));
        System.out.println("Length is - " + segment1.getLength());
        Range segment2 = new Range(5, 15);
        System.out.printf("Segment2: %f %f", segment2.getFrom(), segment2.getTo());
        System.out.println();
        System.out.println(getIntersection(segment1, segment2));
        // Не понимаю от какого объекта вызывать метод getIntersection
    }
}

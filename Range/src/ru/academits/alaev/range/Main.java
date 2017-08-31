package ru.academits.alaev.range;

public class Main {
    public static void main(String[] args) {
        double x = 2;
        Range segment1 = new Range(1, 5); // Создаю объект segment1
        System.out.printf("Segment1: %f %f \n", segment1.getFrom(), segment1.getTo());
        System.out.println("Is point in range? - " + segment1.isInside(x));
        System.out.println("Length is - " + segment1.getLength());
        Range segment2 = new Range(10, 20); // Создаю объект segment2
        System.out.printf("Segment2: %f %f", segment2.getFrom(), segment2.getTo());
        System.out.println();
        Range result = segment1.getIntersection(segment2);
        if (result == null) {
            System.out.println("No intersection!");
        } else {
            System.out.printf("Result segment: %f %f", result.getFrom(), result.getTo());
        }
        int i = 0; // переменная для цикла, не могу создать её в классе, поэтому передаю
        Range[] result2 = segment1.getSum(segment2, i);
    }
}

package ru.academits.alaev.range;

public class Main {
    public static void main(String[] args) {
        double x = 2;
        Range segment1 = new Range(3, 10); // Создаю объект segment1
        System.out.println("Is point in range? - " + segment1.isInside(x));
        System.out.println("Length is - " + segment1.getLength());
        Range segment2 = new Range(3, 5); // Создаю объект segment2
        System.out.printf("Intersection: ");
        Range intersection = segment1.getIntersection(segment2);
        if (intersection == null) {
            System.out.println("No intersection!");
        } else {
            System.out.printf(" %f %f %n", intersection.getFrom(), intersection.getTo());
        }

        Range[] union = segment1.getUnion(segment2);
        Range.printUnion(union);

        Range[] difference = segment1.getDifference(segment2);
        Range.printDifference(difference);
    }
}

package ru.academits.alaev.range;

public class Main {
    public static void main(String[] args) {
        double x = 2;
        Range segment1 = new Range(10, 20); // Создаю объект segment1
        System.out.printf("Segment1: %f %f \n", segment1.getFrom(), segment1.getTo());
        System.out.println("Is point in range? - " + segment1.isInside(x));
        System.out.println("Length is - " + segment1.getLength());
        Range segment2 = new Range(15, 25); // Создаю объект segment2
        System.out.printf("Segment2: %f %f \n", segment2.getFrom(), segment2.getTo());
        System.out.printf("Intersection: ");
        Range intersection = segment1.getIntersection(segment2);
        if (intersection == null) {
            System.out.println("No intersection!");
        } else {
            System.out.printf(" %f %f \n", intersection.getFrom(), intersection.getTo());
        }
        System.out.printf("Union:         ");
        Range[] union = segment1.getUnion(segment2);
        for (int i = 0; i < union.length; ++i) {
            System.out.printf("%f %f \n", union[i].getFrom(), union[i].getTo());
        }
        System.out.printf("Difference:    ");
        Range[] difference = segment1.getDifference(segment2);
        if (difference == null) {
            System.out.println("No difference");
        } else {
            for (int i = 0; i < difference.length; ++i) {
                System.out.printf("%f %f ", difference[i].getFrom(), difference[i].getTo());
            }
        }
    }
}

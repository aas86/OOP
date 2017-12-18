package ru.academits.alaev.main;

import ru.academits.alaev.person.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Ivan", 20));
        list.add(new Person("Petr", 30));
        list.add(new Person("Egor", 35));
        list.add(new Person("Evgeniy", 37));
        list.add(new Person("Irina", 28));
        list.add(new Person("Sergey", 25));
        list.add(new Person("Anna", 20));
        list.add(new Person("Anna", 40));
        list.add(new Person("Artem", 50));

        List<String> names = list.stream()
                .map(x -> x.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(names);

        String names1 = names.stream().collect(Collectors.joining(", "));
        System.out.println("Имена: " + names1);

        OptionalDouble g = list.stream().filter(x -> x.getAge() > 25)
                .mapToInt(x -> x.getAge())
                .average();
        System.out.println("Средний возраст всех людей, старше 25 лет: " + g.getAsDouble());

        //Сначала отфильтровываю по возрасту, затем сортирую при помощи компаратора
        Stream<Person> stream = list.stream().filter(x -> x.getAge() > 25 && x.getAge() < 40)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge()); // получаю отфильтрованный и отсортированный Stream
        //Чтобы его напечатать преобразовываю его в список строк
        List<String> names2 = stream.map(x -> x.getName())
                .collect(Collectors.toList());
        System.out.println(names2);

        System.out.println(list.stream().
                collect(Collectors.groupingBy(x -> x.getName(), Collectors.averagingInt(x -> x.getAge()))));


    }
}

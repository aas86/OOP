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
        list.add(new Person("Ivan", 15));
        list.add(new Person("Petr", 10));
        list.add(new Person("Egor", 11));
        list.add(new Person("Evgeniy", 37));
        list.add(new Person("Irina", 28));
        list.add(new Person("Sergey", 25));
        list.add(new Person("Sergey", 20));
        list.add(new Person("Anna", 40));
        list.add(new Person("Artem", 50));

        //А) получить список уникальных имен
        List<String> names = list.stream()
                .map(x -> x.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(names);

        //Б) вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.
        String names1 = names.stream().collect(Collectors.joining(", ", "Имя: ", "."));
        System.out.println(names1);

        //В)получить список людей младше 18, посчитать для них средний возраст
        OptionalDouble g = list.stream().filter(x -> x.getAge() < 18)
                .mapToInt(x -> x.getAge())
                .average();
        System.out.println("Средний возраст всех людей, младше 18 лет: " + g.getAsDouble());

        //Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        System.out.println(list.stream().
                collect(Collectors.groupingBy(x -> x.getName(), Collectors.averagingInt(x -> x.getAge()))));

       //Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        //Сначала отфильтровываю по возрасту, затем сортирую при помощи компаратора
        Stream<Person> stream = list.stream().filter(x -> x.getAge() >= 20 && x.getAge() <= 45)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge()); // получаю отфильтрованный и отсортированный Stream
        //Чтобы его напечатать преобразовываю его в список строк
        List<String> names2 = stream.map(x -> x.getName())
                .collect(Collectors.toList());
        System.out.println(names2);



    }
}

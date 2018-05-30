import com.google.gson.Gson;

public class TestParser {
    static class User {
        private String name;
        private String surname;
        private int age;
        private int tel;

        public User(String name, String surname, int age, int tel){
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.tel = tel;
        }
    }
    public static void main(String[] args) {
        User user1 = new User("Andrey", "Alaev", 31, 669976);
        Gson json = new Gson();
        String string = json.toJson(user1);
        System.out.println(string);
    }
}
// Пример подключения библиотеки Gson http://blog.harrix.org/article/7348
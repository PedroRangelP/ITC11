public class Demo {
    public static void main(String[] args) {
        double number = 100;
        Person p = new Person();
        p.name = "Christian";
        p.age = 18;

        foo(number, p);
        System.out.println(number);
        System.out.println(p.name + " " + p.age);
    }

    public static void foo(double number, Person p) {
        number = 123;
        p.name = "Bianca";
        p.age = 19;
    }
}

class Person {
    String name;
    int age;
}
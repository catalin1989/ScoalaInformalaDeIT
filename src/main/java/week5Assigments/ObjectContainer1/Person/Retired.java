package week5Assigments.ObjectContainer1.Person;

import week5Assigments.ObjectContainer1.UtilityClases.Hobby;

import java.util.List;

public class Retired extends Person {
    private final String status = "retired";

    public Retired() {
    }

    public Retired(String name, int age) {
        super(name, age);
    }

    public Retired(String name, int age, List<Hobby> hobbies) {
        super(name, age, hobbies);
    }

    @Override
    public String toString() {
        return "Retired{" +
                "status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}

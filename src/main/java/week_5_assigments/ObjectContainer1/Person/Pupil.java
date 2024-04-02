package week_5_assigments.ObjectContainer1.Person;

import week_5_assigments.ObjectContainer1.UtilityClasses.Hobby;

import java.util.List;

public class Pupil extends Person {

    private final String status = "pupil";

    public Pupil() {
    }

    public Pupil(String name, int age) {
        super(name, age);
    }

    public Pupil(String name, int age, List<Hobby> hobbies) {
        super(name, age, hobbies);
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}

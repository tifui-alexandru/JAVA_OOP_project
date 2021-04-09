package persons;

import subject.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
    private String name;
    private Date birthday;
    protected List<String> subjects = new ArrayList<>();

    Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("\nNume:");
        System.out.println(name);

        System.out.println("\nData nasterii:");
        System.out.println(birthday);

        System.out.println("\nMateriile asociate:");
        for (var subj : subjects)
            System.out.println(subj);
    }
}

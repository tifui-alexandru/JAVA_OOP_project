package persons;

import subject.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Person {
    private String name;
    private Date birthday;
    protected List<String> subjects = new ArrayList<>();
    UUID id;

    Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
        id = UUID.randomUUID();
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
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

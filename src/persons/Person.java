package persons;

import subject.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
    private String name;
    private Date birthday;
    private List<String> subjects = new ArrayList<>();

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
        System.out.println(this.name);

        System.out.println("\nData nasterii:");
        System.out.println(this.birthday);

        System.out.println("\nMateriile asociate:");
        for (var subj : this.subjects)
            System.out.println(subj);
    }

    void addSubject(String subjectName) {
        this.subjects.add(subjectName);
    }
}

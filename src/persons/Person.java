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

    void addSubject(String subjectName) {
        this.subjects.add(subjectName);
    }
}

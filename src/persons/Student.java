package persons;

import subject.Subject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private Map<Subject, Float> grades = new HashMap<>();
    private int yearOfStudy;
    private String groupName;

    Student(String name, Date birthday) {
        super(name, birthday);
    }
}

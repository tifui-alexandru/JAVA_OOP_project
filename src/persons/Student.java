package persons;

import subject.Subject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static service.Service.year1;
import static service.Service.year2;
import static service.Service.year3;

public class Student extends Person {
    private Map<Subject, Float> grades = new HashMap<>();
    private int yearOfStudy;
    private String groupName;

    public Student(String name, Date birthday, int yearOfStudy, String groupName) {
        super(name, birthday);
        this.yearOfStudy = yearOfStudy;
        this.groupName = groupName;

        if (yearOfStudy == 1)
            this.subjects = year1.getSubjects();
        else if (yearOfStudy == 2)
            this.subjects = year2.getSubjects();
        else
            this.subjects = year3.getSubjects();
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public Map<Subject, Float> getGrades() {
        return grades;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public void displayDetails() {
        System.out.println("\nAnul de studiu:");
        System.out.println(yearOfStudy);

        System.out.println("\nGrupa:");
        System.out.println(groupName);

        super.displayDetails();

        System.out.println("\nNotele la materiile sale:");
        grades.forEach((key, value) -> {
            System.out.print(key + " ");
            if (value == 0)
                System.out.println("N/A");
            else
                System.out.println(value);
        });
    }
}

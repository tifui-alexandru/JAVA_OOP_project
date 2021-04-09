package service;

import persons.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsService {
    public static List<Student> studentsList = new ArrayList<>();

    public int getStudentsNo(int yearOfStudy) {
        if (yearOfStudy == 0)
            return studentsList.size();
        int ans = 0;
        for (var stud : studentsList) {
            if (stud.getYearOfStudy() == yearOfStudy)
                ++ans;
        }
        return ans;
    }

    public void displayStudentsInfo(int yearOfStudy) {
        List <Student> displayableStudents = new ArrayList<>();
        if (yearOfStudy == 0)
            displayableStudents = studentsList;
        else {
            for (var stud : studentsList) {
                if (stud.getYearOfStudy() == yearOfStudy)
                    displayableStudents.add(stud);
            }
        }

        for (var stud : displayableStudents) {
            stud.displayDetails();
        }
    }

    public void displayStudentInfo(String name) {
        boolean flag = true;

        for (var stud : studentsList) {
            if (stud.getName() == name) {
                stud.displayDetails();
                flag = false;
            }
        }

        if (flag)
            System.out.println("Nu exista niciun stuent cu acest nume");
    }
}

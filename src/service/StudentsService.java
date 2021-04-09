package service;

import persons.Student;
import subject.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

    public void addStudent(String name, Date bDay, int yearOfStudy, String groupName) {
        studentsList.add(new Student(name, bDay, yearOfStudy, groupName));
    }

    public void markExam(Subject subj) {
        for (var stud : studentsList) {
            if (stud.getYearOfStudy() == subj.getYearOfStudy()) {
                float total = 0;

                for (var eval : subj.getEvaluationList()) {
                    System.out.print("Introduceti nota pentru ");
                    System.out.println(eval.getName());

                    int grade = Integer.parseInt(Main.sc.nextLine());

                    total += 1.0 * grade * eval.getPercentage();
                }

                stud.setGrade(subj, total);
            }
        }
    }

    public void showRankings(int yearOfStudy) {
        if (studentsList.get(0).evaluationComplete())
            System.out.println("Evaluarea studentilor a fost completa\n");
        else
            System.out.println("Evaluarea studentilor este incompleta. Unele examene nu au fost sustinute/corectate\n");

        Collections.sort(studentsList, new AvgComparator());

        for (var stud : studentsList) {
            System.out.println("\nNume");
            System.out.println(stud.getName());

            System.out.println("\nGrupa");
            System.out.println(stud.getGroupName());

            System.out.println("\nMedia:");
            System.out.println(stud.computeAvg());

            System.out.println("\n\n");
        }
    }
}

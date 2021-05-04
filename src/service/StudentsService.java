package service;

import csvParsers.CsvReader;
import persons.Student;
import subject.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static service.Service.*;

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
            if (stud.getName().equals(name)) {
                stud.displayDetails();
                flag = false;
            }
        }

        if (flag)
            System.out.println("Nu exista niciun stuent cu acest nume");
    }

    public void addStudent(String name, Date bDay, int yearOfStudy, String groupName) {
        studentsList.add(new Student(name, bDay, yearOfStudy, groupName));
        System.out.println("\nStudent adaugat cu succes\n");
    }

    public void updateSubjects(int yearOfStudy) {
        for (var stud : studentsList) {
            if (stud.getYearOfStudy() == yearOfStudy) {
                if (yearOfStudy == 1) {
                    stud.setSubjects(year1.getSubjects());
                }
                else if (yearOfStudy == 2) {
                    stud.setSubjects(year2.getSubjects());
                }
                else {
                    stud.setSubjects(year3.getSubjects());
                }
            }
        }
    }

    public void markExam(Subject subj) {

        for (var stud : studentsList) {
            if (stud.getYearOfStudy() == subj.getYearOfStudy()) {
                float total = 0;

                for (var eval : subj.getEvaluationList()) {
                    System.out.println("Introduceti nota pentru " + eval.getName() + " pentru studentul " + stud.getName());

                    int grade = Integer.parseInt(Main.sc.nextLine());

                    total += 1.0 * grade * eval.getPercentage() / 100.0;
                }

                stud.setGrade(subj, total);
            }
        }
    }

    public void showRankings(int yearOfStudy) {
        List<Student> rankableStudents = new ArrayList<>();
        for (var stud : studentsList) {
            if (stud.getYearOfStudy() == yearOfStudy)
                rankableStudents.add(stud);
        }

        if (rankableStudents.get(0).evaluationComplete())
            System.out.println("Evaluarea studentilor a fost completa\n");
        else
            System.out.println("Evaluarea studentilor este incompleta. Unele examene nu au fost sustinute/corectate\n");

        Collections.sort(rankableStudents, new AvgComparator());

        for (var stud : rankableStudents) {
            System.out.println("Nume: " + stud.getName());

            System.out.println("Grupa: " + stud.getGroupName());

            System.out.print("Media:");
            System.out.println(stud.computeAvg());

            System.out.println("\n\n");
        }
    }

    public void initStudents(CsvReader reader) {

    }
}

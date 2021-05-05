package service;

import csvParsers.CsvReader;
import persons.Student;
import subject.Subject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public void addStudent(String name, Date bDay, int yearOfStudy, String groupName) throws IOException {
        studentsList.add(new Student(name, bDay, yearOfStudy, groupName));

        List<String> csvData = new ArrayList<>();
        csvData.add(String.valueOf(studentsList.get(studentsList.size() - 1).getId()));
        csvData.add(name);
        csvData.add(new SimpleDateFormat("dd/MM/yyyy").format(bDay));
        csvData.add(String.valueOf(yearOfStudy));
        csvData.add(groupName);
        Main.writer.writeData("csv/students.csv", csvData);

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

    public void markExam(Subject subj) throws IOException {
        for (var stud : studentsList) {
            if (stud.getYearOfStudy() == subj.getYearOfStudy()) {
                int total = 0;

                float totalProiect = 0;
                float totalExamen = 0;

                float perExamen = 0;
                float perProiect = 0;

                for (var eval : subj.getEvaluationList()) {
                    System.out.println("Introduceti nota pentru " + eval.getName() + " pentru studentul " + stud.getName());

                    int grade = Integer.parseInt(Main.sc.nextLine());

                    if (eval.getName().equals("Proiect")) {
                        totalProiect = grade;
                        perProiect = eval.getPercentage();
                    }
                    else if (grade > totalExamen){
                        // altfel luam cea mai mare nota dintre (examen, marire, restanta)
                        totalExamen = grade;
                        perExamen = eval.getPercentage();
                    }
                }

                total = Math.round((totalExamen * perExamen + totalProiect * perProiect) / 100);
                stud.setGrade(subj, total);

                List<String> csvData = new ArrayList<>();
                csvData.add(String.valueOf(stud.getId()));
                csvData.add(String.valueOf(subj.getId()));
                csvData.add(String.valueOf(total));
                Main.writer.writeData("csv/catalog.csv", csvData);

                System.out.println("\nNota acoradta cu succes!\n");
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

    public static Student findById(UUID id) {
        for (var stud : studentsList) {
            if (stud.getId().equals(id))
                return stud;
        }
        return null; // not ok
    }

    public void initStudents(CsvReader reader) throws FileNotFoundException, ParseException {
        var dbStudentsList = reader.readData("csv/students.csv");
        for (var stud : dbStudentsList) {
            UUID id = UUID.fromString(stud.get(0));
            String name = stud.get(1);
            Date bDay = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(stud.get(2));
            int yearOfStudy = Integer.parseInt(stud.get(3));
            String groupName = stud.get(4);

            studentsList.add(new Student(name, bDay, yearOfStudy, groupName, id));

            if (yearOfStudy == 1) {
                year1.addGroup(groupName);
            }
            else if (yearOfStudy == 2) {
                year2.addGroup(groupName);
            }
            else {
                year3.addGroup(groupName);
            }
        }
    }
}

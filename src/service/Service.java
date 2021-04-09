package service;

import evaluationForms.Evaluation;
import persons.Assistant;
import persons.Professor;
import persons.Student;
import subject.Subject;

import java.text.SimpleDateFormat;
import java.util.*;

public class Service {
    public static List<Student> studentsList = new ArrayList<>();
    public static List<Professor> professorsList = new ArrayList<>();
    public static List<Assistant> assistantsList = new ArrayList<>();
    public static List<Subject> subjectsList = new ArrayList<>();
    public static List<Evaluation> evaluationsList = new ArrayList<>();

    public static List<Set<String>> groupNamesSet = new ArrayList<>();

    boolean validResponse(String response, int lowerBound, int upperBound) {
        try {
            int res = Integer.parseInt(response);
            if (res < lowerBound || res > upperBound)
                throw new Exception("Invalid number");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void studentsInfo() {

    }

    public static void profsInfo() {

    }

    public static void subjectsInfo() {

    }

    public static void addStudent() {

    }

    public static void addProf() {

    }

    public static void addAssistent() {

    }

    public static void addSubject() {

    }

    public static void markExam() {

    }

    public static void showRankings() {

    }
}

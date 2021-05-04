package service;

import csvParsers.CsvReader;
import evaluationForms.Evaluation;
import evaluationForms.Exam;
import subject.Subject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SubjectsService {
    public static List<Subject> subjectsList = new ArrayList<>();

    public int getSubjectsNo(int yearOfStudy) {
        if (yearOfStudy == 0)
            return subjectsList.size();
        int ans = 0;
        for (var subj : subjectsList) {
            if (subj.getYearOfStudy() == yearOfStudy)
                ++ans;
        }
        return ans;
    }

    public void displaySubjectsInfo(int yearOfStudy) {
        List <Subject> displayableSubjects = new ArrayList<>();
        if (yearOfStudy == 0)
            displayableSubjects = subjectsList;
        else {
            for (var subj : subjectsList) {
                if (subj.getYearOfStudy() == yearOfStudy)
                    displayableSubjects.add(subj);
            }
        }

        for (var subj : displayableSubjects) {
            subj.displayDetails();
        }
    }

    public void displaySubjectInfo(String name) {
        boolean flag = true;

        for (var subj : subjectsList) {
            if (subj.getName().equals(name)) {
                subj.displayDetails();
                flag = false;
            }
        }

        if (flag)
            System.out.println("Nu exista niciun stuent cu acest nume");
    }

    public boolean findSubject(String name) {
        for (var subj : subjectsList) {
            if (subj.getName().equals(name))
                return true;
        }
        return false;
    }

    public Subject getSubject(String name) {
        for (var subj : subjectsList) {
            if (subj.getName().equals(name))
                return subj;
        }
        return null;
    }

    public void addSubject(String name, int yearOfStudy, List<Evaluation> evalForms) {
        subjectsList.add(new Subject(name, yearOfStudy, evalForms));
        System.out.println("\nMaterie adaugata cu succes\n");
    }

    public void initSubjects(CsvReader reader) throws FileNotFoundException {
        var dbSubjectsList = reader.readData("csv/subjects.csv");
        for (var subj : dbSubjectsList) {
            UUID id = UUID.fromString(subj.get(0));
            String name = subj.get(1);
            int yearOfStudy = Integer.parseInt(subj.get(2));
            List <Evaluation> evalForms = EvaluationsService.getEvalForms(id);

            subjectsList.add(new Subject(name, yearOfStudy, evalForms, id));
        }
    }
}

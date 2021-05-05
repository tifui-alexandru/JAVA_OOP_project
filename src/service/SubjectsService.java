package service;

import csvParsers.CsvReader;
import evaluationForms.Evaluation;
import subject.Subject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static service.Service.year1;
import static service.Service.year2;
import static service.Service.year3;

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

    public void addSubject(String name, int yearOfStudy, List<Evaluation> evalForms) throws IOException {
        subjectsList.add(new Subject(name, yearOfStudy, evalForms));

        List<String> csvData = new ArrayList<>();
        String subjId = String.valueOf(subjectsList.get(subjectsList.size() - 1).getId());
        csvData.add(subjId);
        csvData.add(name);
        csvData.add(String.valueOf(yearOfStudy));
        Main.writer.writeData("csv/subjects.csv", csvData);

        for (var eval : evalForms) {
            csvData = new ArrayList<>();
            csvData.add(String.valueOf(eval.getId()));
            csvData.add(subjId);
            String evalName = eval.getName();
            if (evalName.equals("Proiect")) {
                if (eval.isOnComputer())
                    evalName = "Proiect pe calculator";
                else
                    evalName = "Proiect clasic";
            }
            csvData.add(evalName);
            csvData.add(new SimpleDateFormat("dd/MM/yyyy").format(eval.getDate()));
            csvData.add(String.valueOf(eval.getPercentage()));
            Main.writer.writeData("csv/evaluations.csv", csvData);
        }

        System.out.println("\nMaterie adaugata cu succes\n");
    }

    public static List<String> getSubjectsById(List<UUID> subjIds) {
        List<String> retVal = new ArrayList<>();

        for (var givenId : subjIds) {
            for (var subj : subjectsList) {
                if (subj.getId().equals(givenId)) {
                    retVal.add(subj.getName());
                    break;
                }
            }
        }

        return retVal;
    }

    public static Subject findById(UUID id) {
        for (var subj : subjectsList) {
            if (subj.getId().equals(id)) {
                return subj;
            }
        }
        return null; // not ok
    }

    public static Subject findByName(String subjTitle) {
        for (var subj : subjectsList) {
            if (subj.getName().equals(subjTitle)) {
                return subj;
            }
        }
        return null; // not ok
    }

    public void initSubjects(CsvReader reader) throws FileNotFoundException {
        var dbSubjectsList = reader.readData("csv/subjects.csv");
        for (var subj : dbSubjectsList) {
            UUID id = UUID.fromString(subj.get(0));
            String name = subj.get(1);
            int yearOfStudy = Integer.parseInt(subj.get(2));
            List <Evaluation> evalForms = EvaluationsService.getEvalForms(id);

            subjectsList.add(new Subject(name, yearOfStudy, evalForms, id));

            if (yearOfStudy == 1) {
                year1.addSubject(name);
            }
            else if (yearOfStudy == 2) {
                year2.addSubject(name);
            }
            else {
                year3.addSubject(name);
            }
        }
    }
}

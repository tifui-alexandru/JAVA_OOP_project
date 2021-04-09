package subject;

import evaluationForms.Evaluation;
import evaluationForms.Exam;
import evaluationForms.Project;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private int yearOfStudy;
    private List<Evaluation> evaluationList = new ArrayList<>();

    public Subject(String name, int yearOfStudy, List<Evaluation> evalForms) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
        this.evaluationList = evalForms;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getName() {
        return name;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void displayDetails() {
        System.out.println("\nNumele materiei");
        System.out.println(name);

        System.out.println("\nAnul de studiu la care se preda");
        System.out.println(yearOfStudy);

        System.out.println("\nFormele de evaluare:");
        for (var eval : evaluationList)
            eval.displayDetails();
    }
}

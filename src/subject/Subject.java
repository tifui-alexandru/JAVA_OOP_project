package subject;

import evaluationForms.Evaluation;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private List<Evaluation> evaluationList = new ArrayList<>();
    private int yearOfStudy;

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getName() {
        return name;
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

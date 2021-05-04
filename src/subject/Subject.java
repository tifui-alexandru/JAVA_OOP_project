package subject;

import evaluationForms.Evaluation;

import java.util.List;
import java.util.UUID;

public class Subject {
    private String name;
    private int yearOfStudy;
    private List<Evaluation> evaluationList;
    private boolean marked;
    UUID id;

    public Subject(String name, int yearOfStudy, List<Evaluation> evalForms) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
        this.evaluationList = evalForms;
        this.marked = false;
        this.id = UUID.randomUUID();
    }

    public Subject(String name, int yearOfStudy, List<Evaluation> evalForms, UUID id) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
        this.evaluationList = evalForms;
        this.marked = false;
        this.id = id;
    }

    public boolean isMarked() {
        return marked;
    }

    public void mark() {
        marked = true;
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

        if (this.marked)
            System.out.println("Notele pentru materie sunt finalizate");
        else
            System.out.println("Notele pentru materie nu sunt finalizate");

        System.out.println("\nAnul de studiu la care se preda");
        System.out.println(yearOfStudy);

        System.out.println("\nFormele de evaluare:");
        for (var eval : evaluationList)
            eval.displayDetails();
    }
}

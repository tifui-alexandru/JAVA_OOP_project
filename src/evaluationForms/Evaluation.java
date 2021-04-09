package evaluationForms;

import persons.Person;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluation {
    private int percentage;
    private Date date;
    private boolean marked;

    public Evaluation(Date date, int percentage) {
        this.date = date;
        this.percentage = percentage;
        this.marked = false;
    }

    public String getName() {
        return "evaluare";
    }

    public int getPercentage() {
        return percentage;
    }

    public boolean isMarked() {
        return marked;
    }

    public void mark() {
        marked = true;
    }

    public void displayDetails() {
        System.out.println("Data evaluare:");
        System.out.println(date);

        System.out.println("Procentajul din nota finala:");
        System.out.println(percentage);

        if (this.marked)
            System.out.println("Proba este deja corectata");
        else
            System.out.println("Proba nu este inca corectata");
    }
}

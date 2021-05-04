package evaluationForms;

import persons.Person;

import java.util.*;

public class Evaluation {
    private int percentage;
    private Date date;
    UUID id;

    public Evaluation(Date date, int percentage) {
        this.date = date;
        this.percentage = percentage;
        id = UUID.randomUUID();
    }

    public String getName() {
        return "evaluare";
    }

    public int getPercentage() {
        return percentage;
    }

    public void displayDetails() {
        System.out.println("Data evaluare:");
        System.out.println(date);

        System.out.println("Procentajul din nota finala:");
        System.out.println(percentage);
    }
}

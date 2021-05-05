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
        this.id = UUID.randomUUID();
    }

    public Evaluation(Date date, int percentage, UUID id) {
        this.date = date;
        this.percentage = percentage;
        this.id = id;
    }

    public UUID getId() { return id; }

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

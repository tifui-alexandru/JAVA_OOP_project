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

    public Evaluation(Date date, int percentage) {
        this.date = date;
        this.percentage = percentage;
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

package evaluationForms;

import java.util.ArrayList;
import java.util.List;

public class Project extends Evaluation {
    private int maxTeamSize;
    private List<Team> teams = new ArrayList<>();

    @Override
    public void displayDetails() {
        System.out.println("Proiect");
        super.displayDetails();
    }
}

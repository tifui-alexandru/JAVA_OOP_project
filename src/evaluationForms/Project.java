package evaluationForms;

import java.util.ArrayList;
import java.util.List;

public class Project extends Evaluation {
    private int maxTeamSize;
    private boolean onComputer;

    @Override
    public void displayDetails() {
        System.out.println("Proiect");
        if (onComputer)
            System.out.println("Acest proiect reprezinta realizarea unei aplicatii");
        else
            System.out.println("Acest proiect nu reprezinta realizarea unei aplicatii");
        super.displayDetails();
    }
}

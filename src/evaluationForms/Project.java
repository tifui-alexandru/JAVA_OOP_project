package evaluationForms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Project extends Evaluation {
    private boolean onComputer;

    public Project(Date date, int percentage, boolean onComputer) {
        super(date, percentage);
        this.onComputer = onComputer;
    }

    public Project(Date date, int percentage, boolean onComputer, UUID id) {
        super(date, percentage, id);
        this.onComputer = onComputer;
    }

    public String getName() {
        return "proiect";
    }

    @Override
    public boolean isOnComputer() { return onComputer; }

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

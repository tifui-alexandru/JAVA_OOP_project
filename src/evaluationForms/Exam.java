package evaluationForms;

import java.util.Date;
import java.util.UUID;

public class  Exam extends Evaluation {
    private boolean isRestanta;
    private boolean isMarire;

    public Exam(Date date, int percentage, boolean isRestanta, boolean isMarire) {
        super(date, percentage);
        this.isMarire = isMarire;
        this.isRestanta = isRestanta;
    }

    public Exam(Date date, int percentage, boolean isRestanta, boolean isMarire, UUID id) {
        super(date, percentage, id);
        this.isMarire = isMarire;
        this.isRestanta = isRestanta;
    }

    public String getName() {
        if(isRestanta)
            return "restanta";
        if (isMarire)
            return "marire";
        return "examen";
    }

    public boolean isMarire() {
        return isMarire;
    }

    public boolean isRestanta() {
        return isRestanta;
    }

    @Override
    public void displayDetails() {
        System.out.println("Examen");
        if (isMarire)
            System.out.println("Marire");
        else if (isRestanta)
            System.out.println("Restanta");
        super.displayDetails();
    }
}

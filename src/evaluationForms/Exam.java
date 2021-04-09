package evaluationForms;

import java.util.Date;

public class  Exam extends Evaluation {
    private boolean isRestanta;
    private boolean isMarire;

    public Exam(Date date, int percentage, boolean isRestanta, boolean isMarire) {
        super(date, percentage);
        this.isMarire = isMarire;
        this.isRestanta = isRestanta;
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

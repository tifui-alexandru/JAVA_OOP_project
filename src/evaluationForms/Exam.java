package evaluationForms;

public class  Exam extends Evaluation {
    private boolean isRestanta;
    private boolean isMarire;

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

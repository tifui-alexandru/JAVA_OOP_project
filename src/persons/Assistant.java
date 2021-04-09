package persons;

import java.util.Date;

public class Assistant extends Person{
    private boolean isMasterStudent;

    Assistant(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public void displayDetails() {
        if (this.isMasterStudent)
            System.out.println("Asistentul este student la master");
        else
            System.out.println("Asistentul nu este student la master");
        super.displayDetails();
    }
}

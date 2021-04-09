package persons;

import java.util.Date;
import java.util.List;

public class Assistant extends Person{
    private boolean isMasterStudent;

    public Assistant(String name, Date birthday, List<String> subjects, boolean isMasterStudent) {
        super(name, birthday);
        this.subjects = subjects;
        this.isMasterStudent = isMasterStudent;
    }

    @Override
    public void displayDetails() {
        if (isMasterStudent)
            System.out.println("Asistentul este student la master");
        else
            System.out.println("Asistentul nu este student la master");
        super.displayDetails();
    }
}

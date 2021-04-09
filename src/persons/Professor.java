package persons;

import java.util.Date;
import java.util.List;

public class Professor extends Person {
    private String title;

    public Professor(String name, Date birthday, List<String> subjects, String title) {
        super(name, birthday);
        this.subjects = subjects;
        this.title = title;
    }

    @Override
    public void displayDetails() {
        System.out.println("Titlul profesorului");
        System.out.println(title);

        super.displayDetails();
    }

    public String getTitle() {
        return title;
    }
}

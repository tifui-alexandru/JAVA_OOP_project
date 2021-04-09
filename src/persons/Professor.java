package persons;

import java.util.Date;

public class Professor extends Person {
    private String title;

    Professor(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public void displayDetails() {
        System.out.println("Titlul profesorului");
        System.out.println(this.title);

        super.displayDetails();
    }

    public String getTitle() {
        return title;
    }
}

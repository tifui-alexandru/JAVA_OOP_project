package service;

import persons.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorsService {
    public static List<Professor> professorsList = new ArrayList<>();

    public int getProfsNo() {
        return professorsList.size();
    }

    public void displayProfsInfo() {
        for (var prof : professorsList) {
            prof.displayDetails();
        }
    }

    public void displayProfInfo(String name) {
        boolean flag = true;

        for (var prof : professorsList) {
            if (prof.getName() == name) {
                prof.displayDetails();
                flag = false;
            }
        }

        if (flag)
            System.out.println("Nu exista niciun profesor cu acest nume");
    }
}

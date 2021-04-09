package service;

import persons.Assistant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AsistantsService {
    public static List<Assistant> assistantsList = new ArrayList<>();

    public int getAsistantsNo() {
        return assistantsList.size();
    }

    public void displayAsistantsInfo() {
        for (var prof : assistantsList) {
            prof.displayDetails();
        }
    }

    public void displayAsistantInfo(String name) {
        boolean flag = true;

        for (var prof : assistantsList) {
            if (prof.getName() == name) {
                prof.displayDetails();
                flag = false;
            }
        }

        if (flag)
            System.out.println("Nu exista niciun asistent cu acest nume");
    }

    public void addAssistent(String name, Date bDay, List<String> subjects, boolean masterStudent) {
        assistantsList.add(new Assistant(name, bDay, subjects, masterStudent));
    }
}

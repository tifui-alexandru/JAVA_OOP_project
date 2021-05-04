package service;

import csvParsers.CsvReader;
import persons.Assistant;
import persons.Professor;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        System.out.println("\nAsistent adaugat cu succes\n");
    }

    public void initAsistants(CsvReader reader) throws FileNotFoundException, ParseException {
        var dbAsistantsList = reader.readData("csv/assistants.csv");
        for (var asist : dbAsistantsList) {
            UUID id = UUID.fromString(asist.get(0));
            String name = asist.get(1);
            Date bDay = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(asist.get(2));
            String title = asist.get(3);

            boolean masterStudent = false;
            if (title.equals("masterand"))
                masterStudent = true;

            var subjectIds = Service.getTaughtSubjectsIDS(id, "csv/teaching-asist.csv", reader);
            var subjects = SubjectsService.getSubjectsById(subjectIds);

            assistantsList.add(new Assistant(name, bDay, subjects, masterStudent));
        }
    }
}

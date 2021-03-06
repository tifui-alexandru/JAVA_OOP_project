package service;

import csvParsers.CsvReader;
import db.DbConnection;
import persons.Assistant;

import java.io.FileNotFoundException;
import java.io.IOException;
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
            if (prof.getName().equals(name)) {
                prof.displayDetails();
                flag = false;
            }
        }

        if (flag)
            System.out.println("Nu exista niciun asistent cu acest nume");
    }

    public void addAssistent(String name, Date bDay, List<String> subjects, boolean masterStudent) {
        assistantsList.add(new Assistant(name, bDay, subjects, masterStudent));

        List<String> csvData = new ArrayList<>();
        String profId = String.valueOf(assistantsList.get(assistantsList.size() - 1).getId());
        csvData.add(profId);
        csvData.add(name);
        csvData.add(new SimpleDateFormat("dd/MM/yyyy").format(bDay));
        String masterand = "normal";
        if (masterStudent)
            masterand = "masterand";
        csvData.add(masterand);

        DbConnection.insert("assistants", csvData);

        for (var subjTitle : subjects) {
            var subj = SubjectsService.findByName(subjTitle);
            csvData = new ArrayList<>();
            csvData.add(String.valueOf(subj.getId()));
            csvData.add(profId);
            DbConnection.insert("teachingasist", csvData);
        }

        System.out.println("\nAsistent adaugat cu succes\n");
    }

    public void initAsistants() throws ParseException {
        var dbAsistantsList = DbConnection.readAll("assistants");
        for (var asist : dbAsistantsList) {
            UUID id = UUID.fromString(asist.get(0));
            String name = asist.get(1);
            Date bDay = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(asist.get(2));
            String title = asist.get(3);

            boolean masterStudent = false;
            if (title.equals("masterand"))
                masterStudent = true;

            var subjectIds = Service.getTaughtSubjectsIDS(id, "teachingasist");
            var subjects = SubjectsService.getSubjectsById(subjectIds);

            assistantsList.add(new Assistant(name, bDay, subjects, masterStudent, id));
        }
    }
}

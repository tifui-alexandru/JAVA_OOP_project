package service;

import csvParsers.CsvReader;
import db.DbConnection;
import persons.Professor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
            if (prof.getName().equals(name)) {
                prof.displayDetails();
                flag = false;
            }
        }

        if (flag)
            System.out.println("Nu exista niciun profesor cu acest nume");
    }

    public void addProf(String name, Date bDay, List<String> subjects, String title) throws IOException {
        professorsList.add(new Professor(name, bDay, subjects, title));

        List<String> csvData = new ArrayList<>();
        String profId = String.valueOf(professorsList.get(professorsList.size() - 1).getId());
        csvData.add(profId);
        csvData.add(name);
        csvData.add(new SimpleDateFormat("dd/MM/yyyy").format(bDay));
        csvData.add(title);

        DbConnection.insert('professors', csvData);

        for (var subjTitle : subjects) {
            var subj = SubjectsService.findByName(subjTitle);
            csvData = new ArrayList<>();
            csvData.add(String.valueOf(subj.getId()));
            csvData.add(profId);
            DbConnection.insert('teaching-profs', csvData);
        }

        System.out.println("\nProfesor adaugat cu succes\n");
    }

    public void initProfessors() throws ParseException {
        var dbProfessordList = DbConnection.readAll("professors");
        for (var prof : dbProfessordList) {
            UUID id = UUID.fromString(prof.get(0));
            String name = prof.get(1);
            Date bDay = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(prof.get(2));
            String title = prof.get(3);

            var subjectIds = Service.getTaughtSubjectsIDS(id, "teaching-profs");
            var subjects = SubjectsService.getSubjectsById(subjectIds);

            professorsList.add(new Professor(name, bDay, subjects, title, id));
        }
    }
}

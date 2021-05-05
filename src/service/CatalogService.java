package service;

import csvParsers.CsvReader;
import persons.Student;
import subject.Subject;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

public class CatalogService {
    public void initGrades(CsvReader reader) throws FileNotFoundException, ParseException {
        var dbStudentsList = reader.readData("csv/catalog.csv");
        for (var studListObj : dbStudentsList) {
            UUID idStudent = UUID.fromString(studListObj.get(0));
            UUID idSubject = UUID.fromString(studListObj.get(1));
            int grade = Integer.parseInt(studListObj.get(2));

            Student stud = StudentsService.findById(idStudent);
            Subject subj = SubjectsService.findById(idSubject);

            stud.setGrade(subj, grade);
        }
    }
}

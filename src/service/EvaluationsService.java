package service;

import csvParsers.CsvReader;
import evaluationForms.Evaluation;
import evaluationForms.Exam;
import evaluationForms.Project;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EvaluationsService {
    private static HashMap<UUID, List<Evaluation>> evaluationsMap = new HashMap<>();

    public void initEvaluations(CsvReader reader) throws FileNotFoundException, ParseException {
        var dbEvaluationsList = reader.readData("csv/evaluations.csv");
        for (var eval : dbEvaluationsList) {
            UUID id = UUID.fromString(eval.get(0));
            UUID subjId = UUID.fromString(eval.get(1));
            String type = eval.get(2);
            Date date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(eval.get(3));
            int percentage = Integer.parseInt(eval.get(4));

            if (evaluationsMap.get(subjId) == null)
                evaluationsMap.put(subjId, new ArrayList<>());

            var evalList = evaluationsMap.get(subjId);

            if (type.equals("Examen")) {
                evalList.add(new Exam(date, percentage, false, false, id));
            }
            else if (type.equals("Restanta")) {
                evalList.add(new Exam(date, percentage, true, false, id));
            }
            else if (type.equals("Marire")) {
                evalList.add(new Exam(date, percentage, false, true, id));
            }
            else if (type.equals("Proiect clasic")) {
                evalList.add(new Project(date, percentage, false, id));
            }
            else {
                evalList.add(new Project(date, percentage, true, id));
            }
        }
    }

    public static List<Evaluation> getEvalForms(UUID subjectId) {
        return evaluationsMap.get(subjectId);
    }
}

package service;

import evaluationForms.Evaluation;
import evaluationForms.Exam;
import evaluationForms.Project;
import year.Year;

import java.util.Date;

public class Service {
    public static Year year1;
    public static Year year2;
    public static Year year3;

    boolean validResponse(String response, int lowerBound, int upperBound) {
        try {
            int res = Integer.parseInt(response);
            if (res < lowerBound || res > upperBound)
                throw new Exception("Invalid number");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean hasGroupName(int yearOfStudy, String groupName) {
        if (yearOfStudy == 1)
            return year1.hasGroup(groupName);
        else if (yearOfStudy == 2)
            return year2.hasGroup(groupName);
        else if (yearOfStudy == 3)
            return year3.hasGroup(groupName);
        return false;
    }

    Evaluation constructEvaluation(int evalForm, Date examDate, int percentage, boolean onComputer) {
        if (evalForm == 1) {
            return new Exam(examDate, percentage, false, false);
        }
        else if (evalForm == 2) {
            return new Exam(examDate, percentage, true, false);
        }
        else if (evalForm == 3) {
            return new Exam(examDate, percentage, false, true);
        }
        else {
            return new Project(examDate, percentage, onComputer);
        }
    }
}

package service;

import subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectsService {
    public static List<Subject> subjectsList = new ArrayList<>();

    public int getSubjectsNo(int yearOfStudy) {
        if (yearOfStudy == 0)
            return subjectsList.size();
        int ans = 0;
        for (var subj : subjectsList) {
            if (subj.getYearOfStudy() == yearOfStudy)
                ++ans;
        }
        return ans;
    }

    public void displaySubjectsInfo(int yearOfStudy) {
        List <Subject> displayableSubjects = new ArrayList<>();
        if (yearOfStudy == 0)
            displayableSubjects = subjectsList;
        else {
            for (var subj : subjectsList) {
                if (subj.getYearOfStudy() == yearOfStudy)
                    displayableSubjects.add(subj);
            }
        }

        for (var subj : displayableSubjects) {
            subj.displayDetails();
        }
    }

    public void displaySubjectInfo(String name) {
        boolean flag = true;

        for (var subj : subjectsList) {
            if (subj.getName() == name) {
                subj.displayDetails();
                flag = false;
            }
        }

        if (flag)
            System.out.println("Nu exista niciun stuent cu acest nume");
    }
}

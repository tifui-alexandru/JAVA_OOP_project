package service;

import persons.Student;

import java.util.Comparator;

public class AvgComparator implements Comparator<Student> {
    public int compare(Student stud1, Student stud2) {
        if (stud1.computeAvg() == stud2.computeAvg())
            return 0;
        if (stud1.computeAvg() > stud2.computeAvg())
            return -1;
        else
            return 1;
    }
}

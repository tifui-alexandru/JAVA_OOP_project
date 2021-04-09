package service;

import year.Year;

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
}

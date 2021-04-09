package service;

import evaluationForms.Evaluation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    static Service service = new Service();

    public static int displayMenu() {
        while (true) {
            System.out.println("0. Iesiti");
            System.out.println("1. Afisati informatii despre studenti");
            System.out.println("2. Afisati informatii despre profesori si asistenti");
            System.out.println("3. Afisati informatii despre materii");
            System.out.println("4. Adaugati student");
            System.out.println("5. Adaugati profesor");
            System.out.println("6. Adaugati asistent");
            System.out.println("7. Adaugati materie");
            System.out.println("8. Notati un examen/proiect");
            System.out.println("9. Afisati clasamentul studentilor");

            String response = sc.nextLine();
            if (service.validResponse(response, 0, 9))
                return Integer.parseInt(response);
            else
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
        }
    }

    public static void studentsInfoMenu() {
        System.out.println("\nCe fel de informatii despre studenti ati vrea sa aflati?");
        System.out.println("Va rog alegeti indicele uneia dintre urmatoarele actiuni posibile:");

        while (true) {
            System.out.println("0. Informatii despre toti studentii");
            System.out.println("1. Informatii despre studentii din anul 1");
            System.out.println("2. Informatii despre studentii din anul 2");
            System.out.println("3. Informatii despre studentii din anul 3");
            System.out.println("4. Informatii despre un student anume");

            String response = sc.nextLine();
            if (service.validResponse(response, 0, 4)) {
                int option = Integer.parseInt(response);
                if (option == 0) {
                    System.out.println(String.format("\nIn facultatea noastra studiaza in total %d studenti la " +
                                                        "licenta\n", service.getStudentsNo(0)));
                    service.displayStudentsInfo(0);
                }
                else if (option == 1) {
                    System.out.println(String.format("\nIn facultatea noastra studiaza in total %d studenti la " +
                            "licenta in anul 1\n", service.getStudentsNo(1)));
                    service.displayStudentsInfo(1);
                }
                else if (option == 2) {
                    System.out.println(String.format("\nIn facultatea noastra studiaza in total %d studenti la " +
                            "licenta in anul 2\n", service.getStudentsNo(2)));
                    service.displayStudentsInfo(2);
                }
                else if (option == 3) {
                    System.out.println(String.format("\nIn facultatea noastra studiaza in total %d studenti la " +
                            "licenta in anul 3\n", service.getStudentsNo(3)));
                    service.displayStudentsInfo(3);
                }
                else {
                    System.out.println("Introduceti va rog numele si prenumele studentului in aceasta ordine");
                    String name = sc.nextLine();
                    service.displayStudentInfo(name);
                }
                
                break;
            }
            else
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
        }
    }

    public static void profsInfoMenu() {
        System.out.println("Ce fel de informatii despre studenti sau asistenti ati vrea sa aflati?");
        System.out.println("Va rog alegeti indicele uneia dintre urmatoarele actiuni posibile:");

        while (true) {
            System.out.println("0. Informatii despre toti profesorii");
            System.out.println("1. Informatii despre toti asistentii");
            System.out.println("2. Informatii despre un profesor anume");
            System.out.println("3. Informatii despre un asistent anume");

            String response = sc.nextLine();
            if (service.validResponse(response, 0, 3)) {
                int option = Integer.parseInt(response);
                if (option == 0) {
                    System.out.println(String.format("\nIn facultatea noastra activeaza in total %d profesori\n",
                            service.getProfsNo()));
                    service.displayProfsInfo();
                }
                else if (option == 1) {
                    System.out.println(String.format("\nIn facultatea noastra activeaza in total %d asistenti\n",
                            service.getAsistantsNo()));
                    service.displayAsistantsInfo();
                }
                else if (option == 2) {
                    System.out.println("Introduceti va rog numele si prenumele profesorului in aceasta ordine");
                    String name = sc.nextLine();
                    service.displayProfInfo(name);
                }
                else {
                    System.out.println("Introduceti va rog numele si prenumele asistentului in aceasta ordine");
                    String name = sc.nextLine();
                    service.displayAsistantInfo(name);
                }

                break;
            }
            else
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
        }
    }

    public static void subjectsInfoMenu() {
        System.out.println("Ce fel de informatii despre materiile predate ati vrea sa aflati?");
        System.out.println("Va rog alegeti indicele uneia dintre urmatoarele actiuni posibile:");

        while (true) {
            System.out.println("0. Informatii despre toate materiile");
            System.out.println("1. Informatii despre materiile din anul 1");
            System.out.println("2. Informatii despre materiile din anul 2");
            System.out.println("3. Informatii despre materiile din anul 3");
            System.out.println("4. Informatii despre o materie anume");

            String response = sc.nextLine();
            if (service.validResponse(response, 0, 4)) {
                int option = Integer.parseInt(response);
                if (option == 0) {
                    System.out.println(String.format("\nIn facultatea noastra se studiaza in total %d materii\n",
                            service.getSubjectssNo(0)));
                    service.displaySubjectsInfo(0);
                }
                else if (option == 1) {
                    System.out.println(String.format("\nIn facultatea noastra se studiaza in total %d materii in anul 1\n",
                            service.getSubjectssNo(1)));
                    service.displaySubjectsInfo(1);
                }
                else if (option == 2) {
                    System.out.println(String.format("\nIn facultatea noastra se studiaza in total %d materii in anul 2\n",
                            service.getSubjectssNo(2)));
                    service.displaySubjectsInfo(2);
                }
                else if (option == 3) {
                    System.out.println(String.format("\nIn facultatea noastra se studiaza in total %d materii in anul 3\n",
                            service.getSubjectssNo(3)));
                    service.displaySubjectsInfo(3);
                }
                else {
                    System.out.println("Introduceti va rog numele materiei");
                    String name = sc.nextLine();
                    service.displaySubjectInfo(name);
                }

                break;
            }
            else
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
        }
    }

    public static void addStudentMenu() {
        System.out.println("\nVa rog introduceti urmatoarele date despre student:\n");

        System.out.println("Numele si prenumele in aceasta ordine");
        String name = sc.nextLine();

        Date bDay;
        while (true) {
            System.out.println("Data nasterii in formatul zi/luna/an");
            String stringBday = sc.nextLine();
            try {
                bDay = new SimpleDateFormat("dd/MM/yyyy").parse(stringBday);
                break;
            }
            catch (Exception e) {
                System.out.println("Data este in format gresit! Va rugam reincercati");
            }
        }

        int yearOfStudy;
        while (true) {
            System.out.println("Anul de studiu (1, 2 sau 3)");
            String response = sc.nextLine();
            if (service.validResponse(response, 1, 3)) {
                yearOfStudy = Integer.parseInt(response);
                break;
            }
            else {
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
            }
        }

        String groupName;
        while (true) {
            System.out.println("Grupa in care acesta se afla");
            String response = sc.nextLine();
            if (service.groupNamesSet.get(yearOfStudy).contains(response)) {
                groupName = response;
                break;
            }
            else {
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
            }
        }

        service.addStudent(name, bDay, yearOfStudy, groupName);
    }

    public static void addProfMenu() {
        System.out.println("\nVa rog introduceti urmatoarele date despre profesor:\n");

        System.out.println("Numele si prenumele in aceasta ordine");
        String name = sc.nextLine();

        System.out.println("Ttitlul acestuia (ex. profesor, lector etc.)");
        String title = sc.nextLine();

        Date bDay;
        while (true) {
            System.out.println("Data nasterii in formatul zi/luna/an");
            String stringBday = sc.nextLine();
            try {
                bDay = new SimpleDateFormat("dd/MM/yyyy").parse(stringBday);
                break;
            }
            catch (Exception e) {
                System.out.println("Data este in format gresit! Va rugam reincercati");
            }
        }

        System.out.println("Numarul materiilor pe care le preda");
        int noSubjects;
        while (true) {
            String response = sc.nextLine();
            if (service.validResponse(response, 1, 10)) {
                noSubjects = Integer.parseInt(response);
                break;
            }
            else
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
        }

        List<String> subjects = new ArrayList<>();
        System.out.println("Numele materiilor pe care acesta le preda");
        for (int idx = 0; idx < noSubjects; ++idx) {
            while (true) {
                System.out.println(String.format("Materia numarul %d", idx));
                String subjectName = sc.nextLine();
                if (service.findSubject(subjectName)) {
                    subjects.add(subjectName);
                    break;
                }
                else
                    System.out.println("Materia specificata nu exista! Incercati din nou!");
            }
        }

        service.addProf(name, bDay, subjects, title);
    }

    public static void addAssistentMenu() {
        System.out.println("\nVa rog introduceti urmatoarele date despre asistent:\n");

        System.out.println("Numele si prenumele in aceasta ordine");
        String name = sc.nextLine();

        boolean masterStudent;
        System.out.println("Introduceti 1 daca asistentul este student la master, respectiv 0 in caz contrar");
        while (true) {
            String response = sc.nextLine();
            if (service.validResponse(response, 0, 1)) {
                masterStudent = (Integer.parseInt(response) == 1);
                break;
            }
            else
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
        }

        Date bDay;
        while (true) {
            System.out.println("Data nasterii in formatul zi/luna/an");
            String stringBday = sc.nextLine();
            try {
                bDay = new SimpleDateFormat("dd/MM/yyyy").parse(stringBday);
                break;
            }
            catch (Exception e) {
                System.out.println("Data este in format gresit! Va rugam reincercati");
            }
        }

        System.out.println("Numarul materiilor pe care le preda");
        int noSubjects;
        while (true) {
            String response = sc.nextLine();
            if (service.validResponse(response, 1, 10)) {
                noSubjects = Integer.parseInt(response);
                break;
            }
            else
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
        }

        List<String> subjects = new ArrayList<>();
        System.out.println("Numele materiilor pe care acesta le preda");
        for (int idx = 0; idx < noSubjects; ++idx) {
            while (true) {
                System.out.println(String.format("Materia numarul %d", idx));
                String subjectName = sc.nextLine();
                if (service.findSubject(subjectName)) {
                    subjects.add(subjectName);
                    break;
                }
                else
                    System.out.println("Materia specificata nu exista! Incercati din nou!");
            }
        }

        service.addAssistent(name, bDay, subjects, masterStudent);
    }

    public static void addSubjectMenu() {
        System.out.println("\nVa rog introduceti urmatoarele date despre materie:\n");

        System.out.println("Numele materiei");
        String name = sc.nextLine();

        int yearOfStudy;
        while (true) {
            System.out.println("Anul de studiu la care materia se preda (1, 2 sau 3)");
            String response = sc.nextLine();
            if (service.validResponse(response, 1, 3)) {
                yearOfStudy = Integer.parseInt(response);
                break;
            }
            else {
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
            }
        }

        int noEvalForms;
        while (true) {
            System.out.println("Forme de evaluare posibile: examen, marire, restanta, proiect");
            System.out.println("Introduceti numarul de forme de evaluare (minim 1, maxim 4)");
            String response = sc.nextLine();
            if (service.validResponse(response, 1, 3)) {
                noEvalForms = Integer.parseInt(response);
                break;
            }
            else {
                System.out.println("\nOptinuea este invalida, va rog reincercati!\n");
            }
        }

        List<Evaluation> evalForms = new ArrayList<>();
        for (int idx = 0; idx < noEvalForms; ++idx) {
            int evalForm;
            while (true) {
                System.out.println(String.format("Introduceti forma de evaluare cu numarul %d", idx));
                System.out.println("Tastati 1 pentru examen, 2 pentru restanta, 3 pentru marire, 4 pentru proiect");
                String response = sc.nextLine();
                if (service.validResponse(response, 1, 4)) {
                    evalForm = Integer.parseInt(response);
                    break;
                }
                else
                    System.out.println("Optinue invalida, incercati din nou!");
            }

            Date examDate;
            while (true) {
                System.out.println("Introduceti data sustinerii evaluarii in formatul zi/luna/an");
                String stringDate = sc.nextLine();
                try {
                    examDate = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
                    break;
                }
                catch (Exception e) {
                    System.out.println("Data este in format gresit! Va rugam reincercati");
                }
            }

            int percentage;
            while (true) {
                System.out.println("Introduceti procentajul formei de evaluare din nota finala");
                String response = sc.nextLine();
                if (service.validResponse(response, 1, 100)) {
                    percentage = Integer.parseInt(response);
                    break;
                }
                else
                    System.out.println("Optinue invalida, incercati din nou!");
            }

            evalForms.add(service.constructEvaluation(evalForm, examDate, percentage));
        }

        service.addSubject(name, yearOfStudy, evalForms);
    }

    public static void markExamMenu() {
        System.out.println("Introduceti numele materiei");
        String name = sc.nextLine();

        int evalForm;
        while (true) {
            System.out.println(String.format("Introduceti forma de evaluare cu numarul %d", idx));
            System.out.println("Tastati 1 pentru examen, 2 pentru restanta, 3 pentru marire, 4 pentru proiect");
            String response = sc.nextLine();
            if (service.validResponse(response, 1, 4)) {
                evalForm = Integer.parseInt(response);
                break;
            }
            else
                System.out.println("Optinue invalida, incercati din nou!");
        }

        service.markExam(name, evalForm);
    }

    public static void showRankingsMenu() {
        System.out.println("Selectati anul de stutiu pentru care doriti sa afisati clasamentul studentilor (1, 2 sau 3)");
        int yearOfStudy;
        while (true) {
            String response = sc.nextLine();
            if (service.validResponse(response, 1, 3)) {
                yearOfStudy = Integer.parseInt(response);
                break;
            }
            else
                System.out.println("Optinue invalida, incercati din nou!");
        }

        service.showRankings(yearOfStudy);
    }

    public static boolean performActionMenu(int res) {
        if (res == 0) {
            System.out.println("Va multumim! O zi buna!");
            return true;
        }
        else if (res == 1) {
            studentsInfoMenu();
        }
        else if (res == 2) {
            profsInfoMenu();
        }
        else if (res == 3) {
            subjectsInfoMenu();
        }
        else if (res == 4) {
            addStudentMenu();
        }
        else if (res == 5) {
            addProfMenu();
        }
        else if (res == 6) {
            addAssistentMenu();
        }
        else if (res == 7) {
            addSubjectMenu();
        }
        else if (res == 8) {
            markExamMenu();
        }
        else if (res == 9) {
            showRankingsMenu();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Buna ziua!");
        System.out.println("Bine ati venit in catalogul virtual al facultatii noastre!");

        while (true) {
            System.out.println("Va rog alegeti indicele uneia dintre urmatoarele actiuni posibile:");
            int res = displayMenu();
            boolean stop = performActionMenu(res);
            if (stop)
                break;
        }
    }
}

# JAVA_OOP_project

Proiectul implementeaza un sistem de tip catalog virtual pentru o facultate. 
Acesta suporta urmatoarele operatii:
1. Afisati informatii despre studenti (despre toti studentii, despre cei dintr-un an anume sau despre nu student anume)
2. Afisati informatii despre profesori si asistenti (despre toti profesorii/asistentii sau despre un profesor/asisten anume)
3. Afisati informatii despre materii (despre toate materiile, despre cele dintr-un an anume sau despre o materie anume)
4. Adaugati student
5. Adaugati profesor
6. Adaugati asistent
7. Adaugati materie
8. Notati un examen/proiect
9. Afisati clasamentul studentilor (dintr-un an de studiu in parte)

Clasele folosite sunt urmatoarele:
1. Person - clasa abstracta
2. Student - clasa ce extinde clasa Person
3. Asistant - clasa ce extinde clasa Person
4. Professor - clasa ce extinde clasa Person

5. Evaluation - clasa abstracta
6. Exam - clasa ce extinde clasa Evaluation
7. Project - clasa ce extinde clasa Evaluation

8. Subject - clasa pentru materie

9. Year - clasa ce contine informatii despre un an de studiu (doar 3 instante ale acesteia)

10. StudentsService - clasa de serviciu pentru studenti
11. AsistantsService - clasa de serviciu pentru asistenti
12. ProfessorsService - clasa de serviciu pentru profesori
13. SubjectsService - clasa de serviciu pentru materii
14. Service - clasa de serviciu globala

15. AvgComparator - clasa ce implementeaza interfata Comparator, folosita pentru sortarea studentilor in clasament

16. Main - clasa principala a programului unde are loc interactiunea cu utilizatorul

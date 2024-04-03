package week_8_exeptions_and_logging_assigment;

import java.text.SimpleDateFormat;
import java.util.*;

public class StudentRepository {
    private Set<Student> studentsDataBase;

    public StudentRepository() {
        studentsDataBase = new HashSet<>();
    }

    public void addStudentToDataBase(Student student) {
        if (student == null) {
            throw new IllegalArgumentException(" You can't add a student who hasn't the info for the required fields.");
        }
        int dataBaseSizeBeforeAddingThisStudent = studentsDataBase.size();
        studentsDataBase.add(student);
        int dataBaseSizeAfterAddingThisStudent = studentsDataBase.size();
        if (dataBaseSizeBeforeAddingThisStudent == dataBaseSizeAfterAddingThisStudent) {
            MyLogger.logger.warning("You already have this " + student + " in the data base.");
        } else {
            MyLogger.logger.info(student + " has been successfully added to the data base.");
        }

    }

    public void deleteStudentFromDataBase(String id) {
        if (id == null || id.isBlank() || id.length() != 13) {
            throw new IllegalArgumentException("You're input id is null, blank or has an incorrect entered ID. Please enter a valid id.");
        }
        Student student = null;
        for (Student student1 : studentsDataBase) {
            if (student1.getCNP().equals(id)) {
                student = student1;
            }
        }
        if (student == null) {
            MyLogger.logger.info("No such student found in the data base");
            return;
        }
        studentsDataBase.remove(student);
        MyLogger.logger.info("Successfully deleted " + student + " from the data base.");
    }

    public void retrieveStudentsBasedOnAge(int age) {
        List<Student> listOfStudents = new ArrayList<>();
        if (age < 0) {
            throw new IllegalArgumentException("You can't have a negative number as an age");
        }
        if (age < 18) {
            throw new IllegalArgumentException(" No student can be under normal conditions under 18 years old.");

        }
        int studentAge = 0;
        for (Student student : studentsDataBase) {
            studentAge = calculateStudentAgeInYears(student.getDateOfBirth());
            if (studentAge == age) {
                listOfStudents.add(student);
            }
        }
        if (listOfStudents.isEmpty()) {
            MyLogger.logger.info("There is no student with this age: " + age);
        } else {
            MyLogger.logger.info("Printing the list of students:");
            System.out.println(listOfStudents);
        }
    }

    public void retrieveStudentsBasedOnAge(String age) {
        List<Student> listOfStudents = new ArrayList<>();
        if (age == null || age.isBlank() || age.isEmpty()) {
            throw new IllegalArgumentException("You're input id is null, blank or has an incorrect entered ID. Please enter a valid id.");
        }
        try {

            int ageInt = Integer.parseInt(age);
            if (ageInt < 0) {
                throw new IllegalArgumentException("You can't have a negative number as an age");
            }
            if (ageInt < 18) {
                throw new IllegalArgumentException(" No student can be under normal conditions under 18 years old.");

            }
            int studentAge = 0;
            for (Student student : studentsDataBase) {
                studentAge = calculateStudentAgeInYears(student.getDateOfBirth());
                if (studentAge == ageInt) {
                    listOfStudents.add(student);
                }
            }
            if (listOfStudents.isEmpty()) {
                MyLogger.logger.info("There is no student with this age: " + age);
            } else {
                MyLogger.logger.info("Printing the list of students:");
                System.out.println(listOfStudents);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(" You didn't enter a valid number as an age.");
        }
    }

    private int calculateStudentAgeInYears(String birthDate) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        String currentDate = format.format(date);
        String[] currentDateArray = currentDate.split("\\.");

        String[] birthDateArray = birthDate.split("\\.");
        int currentYear = Integer.parseInt(currentDateArray[2]);
        int currentMonth = Integer.parseInt(currentDateArray[1]);
        int currentDay = Integer.parseInt(currentDateArray[0]);
        int birthMonth = Integer.parseInt(birthDateArray[1]);
        int birthYear = Integer.parseInt(birthDateArray[2]);
        int birthDay = Integer.parseInt(birthDateArray[0]);

        if (currentMonth > birthMonth) {
            return currentYear - birthYear;
        } else if (currentMonth == birthMonth) {
            if (currentDay >= birthDay) {
                return currentYear - birthYear;
            } else {
                return currentYear - birthYear - 1;
            }
        }
        return currentYear - birthYear - 1;
    }

    public void listStudentsOrderedByLastName() {
        if (studentsDataBase == null || studentsDataBase.isEmpty()) {
            throw new IllegalArgumentException("You haven't added any data in the data base!");
        }
        List<Student> listOfStudents = new ArrayList<>(studentsDataBase);
        listOfStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        System.out.println("Printing students sorted by they're last name.");
        System.out.println(listOfStudents);
    }

    public void listStudentsOrderedByBirthDay() {
        if (studentsDataBase == null || studentsDataBase.isEmpty()) {
            throw new IllegalArgumentException("You haven't added any data in the data base!");
        }
        List<Student> listOfStudents = new ArrayList<>(studentsDataBase);
        listOfStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student firstStudent, Student secondStudent) {
                String[] firstStudentBirthDayArray = firstStudent.getDateOfBirth().split("\\.");
                int firstStudentBirthYear = Integer.parseInt(firstStudentBirthDayArray[2]);
                int firstStudentBirthMonth = Integer.parseInt(firstStudentBirthDayArray[1]);
                int firstStudentBirthDay = Integer.parseInt(firstStudentBirthDayArray[0]);
                String[] secondStudentBirthDayArray = secondStudent.getDateOfBirth().split("\\.");
                int secondStudentBirthYear = Integer.parseInt(secondStudentBirthDayArray[2]);
                int secondStudentBirthMonth = Integer.parseInt(secondStudentBirthDayArray[1]);
                int secondStudentBirthDay = Integer.parseInt(secondStudentBirthDayArray[0]);
                if (firstStudentBirthYear == secondStudentBirthYear && firstStudentBirthMonth == secondStudentBirthMonth) {
                    return firstStudentBirthDay - secondStudentBirthDay;
                }
                if (firstStudentBirthYear == secondStudentBirthYear) {
                    return firstStudentBirthMonth - secondStudentBirthMonth;
                }
                return firstStudentBirthYear - secondStudentBirthYear;
            }
        });
        MyLogger.logger.info("Printing students sorted by they're birthday from the oldest to the youngest. ");
        System.out.println(listOfStudents);
    }

    public Set<Student> getStudentsDataBase() {
        return studentsDataBase;
    }
}

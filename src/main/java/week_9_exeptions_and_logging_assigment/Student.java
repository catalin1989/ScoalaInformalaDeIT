package week_9_exeptions_and_logging_assigment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private final String dateOfBirth;
    private char sex;
    private final String CNP;

    public Student(String firstName, String lastName, String dateOfBirth, char sex, String CNP) {
        validateName(firstName);
        this.firstName = firstName;
        validateName(lastName);
        this.lastName = lastName;
        validateDateOfBirth(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
        validateGender(sex);
        this.sex = sex;
        validateCNP(CNP);
        this.CNP = CNP;
        MyLogger.logger.info("All the data entered for " + firstName + " " + lastName + " are valid. The student info can be added to the repository");

    }

    private void validateName(String s) {
        if (s == null) {
            throw new IllegalArgumentException("The name should not be null. Please enter a valid name!");
        }
        if (s.isEmpty()) {
            throw new IllegalArgumentException("The name should not be empty. Please enter a valid name!");
        }
        if (s.isBlank()) {
            throw new IllegalArgumentException("The name should not be blank. Please enter a valid name!");
        }
    }

    private void validateDateOfBirth(String dateOfBirth) {

        String[] array = dateOfBirth.split("\\.");
        if (array.length != 3) {
            throw new IllegalArgumentException("You have entered an invalid date. Please enter a valid number in the date field!");
        }
        try {
            int day = Integer.parseInt(array[0]);
            int month = Integer.parseInt(array[1]);
            int year = Integer.parseInt(array[2]);
            if (day < 1) {
                throw new IllegalArgumentException("You can't have a negative number as a day. Please enter a valid number!");
            }
            if (monthIsOdd(month)) {
                if (day > 31) {
                    throw new IllegalArgumentException("You can't have a day number over 31 in an odd month.Please enter a valid number!");
                }

            } else {
                if (day > 30) {
                    throw new IllegalArgumentException("You can't have a day number over 30 in an even month. Please enter a valid number!");
                }
            }

            if (month == 2) {
                if (yearIsLeap(year) && day > 29) {
                    throw new IllegalArgumentException("You can't have a day number over 29, on the second moth of a leap year. Please enter a valid number");
                } else {
                    if (!yearIsLeap(year) && day > 28) {
                        throw new IllegalArgumentException("You can't have a day number over 28, on the second month. Please enter a valid number.");
                    }


                }

            }
            if (month < 1) {
                throw new IllegalArgumentException("You can't have a negative number as a month. Please enter a valid number!");
            }
            if (year < 1900 || year > (currentYear() - 18)) {
                throw new IllegalArgumentException("You have entered an invalid number for a year! PLease enter a valid number");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("You have entered an invalid date. Please enter a valid number in the date field");
        }
    }

    private boolean monthIsOdd(int month) {
        boolean result = true;
        if (month == 2 || month == 4 || month == 6 || month == 8 || month == 10 || month == 12) {
            result = false;
        }
        return result;
    }

    private boolean yearIsLeap(int year) {
        boolean result = true;
        if (year % 4 != 0) {
            result = false;
        }
        return result;
    }

    private int currentYear() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String year = format.format(date);
        return Integer.parseInt(year);
    }

    private void validateGender(char sex) {
        String s = "MmFf";
        if (s.indexOf(sex) == -1) {
            throw new IllegalArgumentException("You haven't entered a valid option for the sex of the student");
        }
    }

    private void validateCNP(String cnp) {
        if (cnp.length() != 13) {
            throw new IllegalArgumentException("You haven't entered a full cnp. A CNP should have 13 numbers ");
        }
        validateDateOfBirthWithCNP(cnp, dateOfBirth);

    }

    private void validateDateOfBirthWithCNP(String cnp, String dateOfBirth) {
        String dayFromCNP = cnp.substring(5, 7);
        String monthFromCNP = cnp.substring(3, 5);
        String yearFromCNP = cnp.substring(1, 3);

        String dayFromEnteredBirthDay = dateOfBirth.substring(0, 2);
        String mothFromEnteredBirthDay = dateOfBirth.substring(3, 5);
        String yearFromEnteredBirthDay = dateOfBirth.substring(8);

        if (!dayFromCNP.equals(dayFromEnteredBirthDay)) {
            throw new IllegalArgumentException("You have a problem with the CNP and the entered birth day. The day does not match");
        }
        if (!monthFromCNP.equals(mothFromEnteredBirthDay)) {
            throw new IllegalArgumentException("You have a problem with the CNP and the entered birth day. The month does not match");
        }
        if (!yearFromCNP.equals(yearFromEnteredBirthDay)) {
            throw new IllegalArgumentException("You have a problem with the CNP and the entered birth day. The year does not match");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(CNP, student.CNP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CNP);
    }

    @Override
    public String toString() {
        return "Student{" +
                "first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", birth day='" + dateOfBirth + '\'' +
                ", CNP='" + CNP + '\'' +
                '}';
    }

    public String getCNP() {
        return CNP;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getSex() {
        return sex;
    }
}

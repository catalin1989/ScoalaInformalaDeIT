package week_8_exeptions_and_logging_assigment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    private StudentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new StudentRepository();
    }

    @Test
    void addAValidCreatedStudent_expectedSuccess_resultSuccessfully() {
        boolean flag = false;
        try {
            Student student = new Student("Aston", "Martin", "10.05.1989", 'M', "1890510123456");
            repository.addStudentToDataBase(student);
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertFalse(flag);
        assertEquals(1, repository.getStudentsDataBase().size());
    }

    @Test
    void addANullInput_expectedException_resultIllegalArgumentException() {
        boolean flag = false;
        try {

            repository.addStudentToDataBase(null);
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertTrue(flag);
        assertEquals(0, repository.getStudentsDataBase().size());
    }

    @Test
    void deleteValidStudent_expectedSuccess_resultSuccessfully() {

        boolean flag = false;
        try {
            Student student1 = new Student("Aston", "Martin", "05.02.1991", 'F', "1910205125497");
            Student student2 = new Student("David", "Beckam", "04.03.1991", 'F', "1910304125597");
            repository.addStudentToDataBase(student1);
            repository.addStudentToDataBase(student2);
            repository.deleteStudentFromDataBase("1910205125497");
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertFalse(flag);
        assertEquals(1, repository.getStudentsDataBase().size());

    }

    @Test
    void idInputIsNull_expectedException_resultIllegalArgumentException() {
        boolean flag = false;
        try {
            Student student1 = new Student("Aston", "Martin", "05.02.1991", 'F', "1910205125497");
            Student student2 = new Student("David", "Beckam", "04.03.1991", 'F', "1910304125597");
            repository.addStudentToDataBase(student1);
            repository.addStudentToDataBase(student2);
            repository.deleteStudentFromDataBase(null);
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertTrue(flag);
        assertEquals(2, repository.getStudentsDataBase().size());
    }

    @Test
    void idInputIsValidButNoStudentWithThisId_expectNoModification_resultSuccessfully() {
        boolean flag = false;
        try {
            Student student1 = new Student("Aston", "Martin", "05.02.1991", 'F', "1910205125497");
            Student student2 = new Student("David", "Beckam", "04.03.1991", 'F', "1910304125597");
            repository.addStudentToDataBase(student1);
            repository.addStudentToDataBase(student2);
            repository.deleteStudentFromDataBase("1899295123456");
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertFalse(flag);
        assertEquals(2, repository.getStudentsDataBase().size());
    }

    @Test
    void enterInvalidAgeForPrintStudentsByAge_expectException_resultIllegalArgumentException() {
        boolean flag = false;
        try {
            Student student1 = new Student("Aston", "Martin", "05.02.1991", 'F', "1910205125497");
            Student student2 = new Student("David", "Beckam", "04.03.1991", 'F', "1910304125597");
            repository.addStudentToDataBase(student1);
            repository.addStudentToDataBase(student2);
            repository.retrieveStudentsBasedOnAge("-14");
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertTrue(flag);
    }
    @Test
    void enterValidAgeAsStringForPrintStudentsByAge_expectSuccess_resultSuccessfully(){
        boolean flag = false;
        try {
            Student student1 = new Student("Aston", "Martin", "05.02.1991", 'F', "1910205125497");
            Student student2 = new Student("David", "Beckam", "04.03.1991", 'F', "1910304125597");
            repository.addStudentToDataBase(student1);
            repository.addStudentToDataBase(student2);
            repository.retrieveStudentsBasedOnAge("33");
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertFalse(flag);
    }
    @Test
    void enterValidAgeAsIntForPrintStudentsByAge_expectNoOutputBecauseNoStudentWithThisAgeIsInDataBase_resultSuccessfully(){
        boolean flag = false;
        try {
            Student student1 = new Student("Aston", "Martin", "05.02.1991", 'F', "1910205125497");
            Student student2 = new Student("David", "Beckam", "04.03.1991", 'F', "1910304125597");
            repository.addStudentToDataBase(student1);
            repository.addStudentToDataBase(student2);
            repository.retrieveStudentsBasedOnAge(19);
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertFalse(flag);
    }

    @Test
    void listStudentsOrderedByNameButStudentDataBaseIsEmpty_expectException_resultIllegalArgumentException(){
        boolean flag = false;
        try {
            repository.listStudentsOrderedByLastName();
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertTrue(flag);
    }
    @Test
    void listStudentsOrderedByAgeButDataBaseIsEmpty_expectException_resultIllegalArgumentException(){
        boolean flag = false;
        try {
            repository.listStudentsOrderedByBirthDay();
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertTrue(flag);
    }
}
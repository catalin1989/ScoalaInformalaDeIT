package week_9_exeptions_and_logging_assigment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createAStudentWithAllValidFields_expectedNoExceptions_ResultSuccessfully(){
        boolean flag=false;
        try{
            Student student=new Student("Aston","Martin","10.05.1989",'M',"1890510123456");
        }
        catch (IllegalArgumentException e){
            flag=true;
        }
        assertFalse(flag);
    }

    @Test
    void enterANullFirstName_expectedException_resultIllegalArgumentException(){
        boolean flag=false;
        try{
            Student student=new Student(null,"Martin","10.05.1989",'M',"1890510123456");
        }
        catch (IllegalArgumentException e){
            flag=true;
        }
        assertTrue(flag);
    }
    @Test
    void enteredAnEmptyLastName_expectedException_resultIllegalArgumentException(){
        boolean flag=false;
        try{
            Student student=new Student("Aston","","10.05.1989",'M',"1890510123456");
        }
        catch (IllegalArgumentException e){
            flag=true;
        }
        assertTrue(flag);
    }

    @Test
    void enteredAnInvalidMonthNumber_expectedException_resultIllegalArgumentException(){
        boolean flag=false;
        try{
            Student student=new Student("Aston","Martin","10.15.1989",'M',"1890510123456");
        }
        catch (IllegalArgumentException e){
            flag=true;
        }
        assertTrue(flag);
    }
    @Test
    void enteredNoNumberAsADay_expectedException_resultIllegalArgumentException(){
        boolean flag=false;
        try{
            Student student=new Student("Aston","Martin",".05.1989",'M',"1890510123456");
        }
        catch (IllegalArgumentException e){
            flag=true;
        }
        assertTrue(flag);
    }
    @Test
    void enteredInvalidSex_expectedException_resultIllegalArgumentException(){
        boolean flag=false;
        try{
            Student student=new Student("Aston","Martin","10.05.1989",'T',"1890510123456");
        }
        catch (IllegalArgumentException e){
            flag=true;
        }
        assertTrue(flag);
    }
    @Test
    void enteredBirthDateAndCNPDoNotMatch_expectedException_resultIllegalArgumentException(){
        //The first letters of the CNP are SexYYMMDD. If we have a male with the birthdate of 10.05.1989 the cnp in the old
        //format should look like 1890510xxxxxx and in the new format 5890510xxxxxx.
        boolean flag=false;
        try{
            Student student=new Student("Aston","Martin","10.05.1989",'T',"1890610123456");
        }
        catch (IllegalArgumentException e){
            flag=true;
        }
        assertTrue(flag);
    }
    @Test
    void enteredCNPDoesNotMatchTheRequiredLength_expectedException_resultIllegalArgumentException(){
        boolean flag=false;
        try{
            Student student=new Student("Aston","Martin","10.05.1989",'T',"18906101234566");
        }
        catch (IllegalArgumentException e){
            flag=true;
        }
        assertTrue(flag);
    }
    }




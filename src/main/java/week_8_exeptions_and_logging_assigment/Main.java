package week_8_exeptions_and_logging_assigment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
private static Logger logger= LogManager.getLogger(Main.class);
    public static void main(String[] args) {
    try {
        logger.info("Starting the program.");

        System.out.println("Please enter the sex of the student in the format M, m for male or F f for female.");
        Student student1 = new Student("John", "Snow", "05.02.1989", 'F', "2890205125497");
        Student student2 = new Student("Aston", "Martin", "05.02.1991", 'F', "2910205125497");
        Student student3 = new Student("David", "Beckam", "04.03.1991", 'F', "2910304125597");
        Student student4 = new Student("Ferrero","Rocher","05.01.2000",'m',"1000105123456");
        Student student5= new Student("James","Bond","21.12.1999",'M',"1991221123456");
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudentToDataBase(student1);
        studentRepository.addStudentToDataBase(student2);
        studentRepository.addStudentToDataBase(student3);
        studentRepository.addStudentToDataBase(student4);
        studentRepository.addStudentToDataBase(student5);
       studentRepository.retrieveStudentsBasedOnAge("33");
       studentRepository.listStudentsOrderedByLastName();
       studentRepository.listStudentsOrderedByBirthDay();
       studentRepository.deleteStudentFromDataBase("2890205125497");
       studentRepository.listStudentsOrderedByBirthDay();

    }
    catch (IllegalArgumentException e){
        System.out.println(e);
    }

    }
}

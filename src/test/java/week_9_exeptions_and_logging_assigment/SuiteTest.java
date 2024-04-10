package week_9_exeptions_and_logging_assigment;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({StudentTest.class, StudentRepositoryTest.class})
public class SuiteTest {
}

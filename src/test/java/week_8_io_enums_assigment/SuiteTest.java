package week_8_io_enums_assigment;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({MyCalculatorTest.class, MyReaderTest.class, AthleteTest.class})
public class SuiteTest {
}

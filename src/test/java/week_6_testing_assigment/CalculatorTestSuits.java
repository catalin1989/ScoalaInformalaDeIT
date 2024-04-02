package week_6_testing_assigment;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ConvertorTest.class, ReaderTest.class})
public class CalculatorTestSuits {
}

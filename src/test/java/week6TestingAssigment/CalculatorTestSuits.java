package week6TestingAssigment;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ConvertorTest.class, ReaderTest.class})
public class CalculatorTestSuits {
}

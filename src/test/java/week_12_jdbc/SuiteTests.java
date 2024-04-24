package week_12_jdbc;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({MyConnectionTest.class, MyDataBaseReaderTest.class, MyDataBaseWriterTests.class})
public class SuiteTests {
}

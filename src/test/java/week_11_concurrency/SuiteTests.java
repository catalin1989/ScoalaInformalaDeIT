package week_11_concurrency;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({FestivalGateTest.class, TicketTest.class, FestivalStatisticsThreadTest.class})
public class SuiteTests {
}

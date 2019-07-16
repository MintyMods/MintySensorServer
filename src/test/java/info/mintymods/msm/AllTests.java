package info.mintymods.msm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MsmExceptionHintTest.class, MsmExceptionTest.class,
		MsmMonitorRequestTest.class, MsmMonitorResponseTest.class, MsmSensorLabelTest.class, MsmSensorReadingTest.class,
		MsmSensorTest.class, MsmSensorTypeTest.class})
public class AllTests {
}

package info.mintymods;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ info.mintymods.msm.AllTests.class, info.mintymods.mss.core.AllTests.class,
		info.mintymods.mss.services.hwinfo.AllTests.class, info.mintymods.mss.utils.AllTests.class,
		info.mintymods.mss.ApplicationTests.class, })
public class AllTests {
//	@RunWith(SpringRunner.class)
//	@SpringBootTest
}

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//this is a test suite class which run all the unit test classes for us
@RunWith(Suite.class)
@SuiteClasses({ AuthenticationTest.class, PersonStoredTest.class, RSATest.class })
public class AllTests {

}

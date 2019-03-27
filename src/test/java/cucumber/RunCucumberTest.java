package cucumber;

import config.DriverProvider;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "stepdefination"
)
public class RunCucumberTest{

    private static final DriverProvider driverProvider = DriverProvider.get();

    @AfterClass
    public static void tearDown() {
        try {
            if(driverProvider.getWebDriver() != null)
                driverProvider.getWebDriver().quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

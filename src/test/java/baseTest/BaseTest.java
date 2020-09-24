package baseTest;

import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExtentReportListner;
import utils.FileAndEnv;

@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner {

    @BeforeClass
    public void baseTest(){
        RestAssured.baseURI = FileAndEnv.envAndFile().get("ServerURL");
    }

}

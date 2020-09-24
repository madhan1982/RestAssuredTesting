package apiTest;

import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.Test;

public class GetAPITest extends BaseTest {

    @Test
    public void getAPITest(){
        Response response = RestAssured.given().when().get(APIPath.apiClass.GET_LISTOFUSER);

        test.log(LogStatus.INFO, "Start testing");
        System.out.println(response.getBody().asString());
        System.out.println(response.getCookies());
        System.out.println(response.getSessionId());
        System.out.println(response.getStatusCode());
        System.out.println(response.xmlPath());
        System.out.println(response.getTime());

        APIVerification.responseCodeValidation(response, 400);
        APIVerification.responseKeyValidationFromArray(response, "title");
        APIVerification.responseTimeValidation(response);


    }
}

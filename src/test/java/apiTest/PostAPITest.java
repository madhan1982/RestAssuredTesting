package apiTest;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import utils.CommonFunctions;

import java.util.Random;


public class PostAPITest extends BaseTest {

    @Test
    public void validPostAPITest(){
        HeaderConfigs header = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        Response response = RestAssured.given()
                .when()
                .headers(header.defualtHeaders()).body(builder.postRequestBody(CommonFunctions.randomNumber(),CommonFunctions.randamString(), CommonFunctions.randamString()))
                .when()
                .post(APIPath.apiClass.POST_CREATEUSER);

        APIVerification.responseKeyValidationFromObject(response, "title");
        APIVerification.responseCodeValidation(response, 201);
        APIVerification.responseTimeValidation(response);


        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());

    }
}

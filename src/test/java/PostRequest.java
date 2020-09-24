import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PostRequest {

    @Test
    public void postRequest(){

        RestAssured.baseURI = "https://reqres.in/api/users";

        String jsonstring = "{\n" +
                "    \"name\": \"Maddy\",\n" +
                "    \"job\": \"test\"\n" +
                "}";
        RestAssured.given()
                .body(jsonstring)
                .post()
                .then()
                .log()
                .all()
                .statusCode(201);

        }

    }



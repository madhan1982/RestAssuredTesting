import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.matcher.RestAssuredMatchers.*;

public class Test2 {

    @Test
    public void test2(){

        baseURI = "https://reqres.in/api/users";
        /*given().param("page", "2")
                .when()
                .get()
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(200); */


        Response response = given().param("page", 2)
                .when()
                .get();

        System.out.println(response.body().toString());
        System.out.println(response.getContentType());
        System.out.println(response.getTime());
        System.out.println(response.getCookies());
        System.out.println(response.prettyPrint());

    }
}

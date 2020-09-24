import static io.restassured.RestAssured.*;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.lwawt.macosx.CSystemTray;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test1 {

    @Test
    public void test1(){
        System.out.println("Test 1");

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());

        System.out.println(response.getBody().toString());
        System.out.println(response.getBody());
        System.out.println(response.getContentType().toString());
        System.out.println(response.xmlPath().toString());
       // Assert.assertEquals(response.statusCode(), 300);
    }

    @Test
    public void test2(){
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
        .body("data.id[1]", equalTo(9));

    }

    @Test
    void test3(){
        given().get("https://reqres.in/api/users?page=2").then().
                body("data.first_name", hasItems("Linsay"));
    }

    @Test
    public void test4()
    {

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("Name", "Madan");
        map.put("Role", "Test Manager");

        JSONObject request = new JSONObject(map);
        System.out.println(map);
        System.out.println(request);


    }
}

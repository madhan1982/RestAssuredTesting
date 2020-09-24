package apiVerifications;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import utils.CommonFunctions;


public class APIVerification {

    static CommonFunctions cf = new CommonFunctions();
    public static void responseCodeValidation(Response response, int statusCode){
        try{
            Assert.assertEquals(statusCode, response.getStatusCode());
            cf.Log_Pass("Sucessfully validated the status code, code is ::" + response.getStatusCode());
            System.out.println("Sucessfully validated the status code, code is ::" + response.getStatusCode());

        } catch (AssertionError e){
            cf.Log_Fail(e.fillInStackTrace());
            cf.Log_Fail("Expected status code is :: "+ statusCode +", but got this ::" + response.statusCode());
            System.out.println("Expected status code is :: "+ statusCode +", but got this ::" + response.statusCode());

        } catch (Exception e){
            cf.Log_Fail(e.fillInStackTrace());
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void responseKeyValidationFromArray(Response response, String key){
        try {

            JSONArray array = new JSONArray(response.getBody().asString());
            for(int i = 0; i< array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
               cf.Log_Pass("Validated values are "+ obj.get(key));
                System.out.println("Validated values are "+ obj.get(key));
            }
        } catch (Exception e){
            cf.Log_Fail(e.fillInStackTrace());
            System.out.println(e.fillInStackTrace());
        }
    }


    public static void responseKeyValidationFromObject(Response response, String key){
        try {
            JSONObject object = new JSONObject(response.getBody().asString());
            if (object.has(key) && object.get(key)!=null){
                cf.Log_Pass("Successfully validated values of "+ key+ "It is "+object.get(key));
                System.out.println("Successfully validated values of "+ key+ "It is "+object.get(key));
            }else {
                cf.Log_Fail("Key is not available");
                System.out.println("Key is not available");
            }
        } catch (Exception e){
            cf.Log_Fail(e.fillInStackTrace());
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void responseTimeValidation(Response response){
        try{
            long time = response.time();
            cf.Log_Pass("API response time is " + response.getTime());
            System.out.println("API response time is " + response.getTime());
        } catch (Exception e){
            cf.Log_Fail(e.fillInStackTrace());
            System.out.println(e.fillInStackTrace());
        }

    }
}

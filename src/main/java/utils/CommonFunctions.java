package utils;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class CommonFunctions extends ExtentReportListner{

    public void Log_Pass(String logMessage){
        test.log(LogStatus.PASS, logMessage);
    }

    public void Log_Fail(String logMessage){
        test.log(LogStatus.FAIL, logMessage);
    }

    public void Log_Fail(Throwable throwable){
        test.log(LogStatus.FAIL, throwable);
    }

    public void Log_Info(String logMessage){
        test.log(LogStatus.INFO, logMessage);
    }

    public void Log_Skipped(String logMessage){
        test.log(LogStatus.SKIP, logMessage);
    }

    public static String randomNumber(){
        //Random number generation
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        String id = Integer.toString(randomNumber);
        System.out.println("Random ID is "+id);



        return id;
    }

    public static String randamString(){
        //random number generation
        String randomString = RandomStringUtils.randomAlphabetic(8);
        System.out.println("Random String is "+randomString);

        return randomString;
    }

}

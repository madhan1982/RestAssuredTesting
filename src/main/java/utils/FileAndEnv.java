package utils;

import jdk.internal.cmm.SystemResourcePressureImpl;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAndEnv {
    public static Map<String , String>  fileAndEnv = new HashMap<String, String>();
    public static Properties proMain = new Properties();
    public static Properties proPreSet = new Properties();

    public static Map<String , String> envAndFile(){
        String environment = System.getProperty("env");
        try {
            if(environment.equalsIgnoreCase("test")){
                FileInputStream fisTest = new FileInputStream(System.getProperty("user.dir")+"/input/test.properties");

                System.out.println(System.getProperty("user.dir"));
                proMain.load(fisTest);
                fileAndEnv.put("ServerURL", proMain.getProperty("ServerURL"));
                fileAndEnv.put("ApiKey", proMain.getProperty("ApiKey"));
                fileAndEnv.put("UserName", proMain.getProperty("UserName"));
                fileAndEnv.put("Password", proMain.getProperty("Password"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileAndEnv;
    }

    public static Map<String, String > getConfigReader(){
        if (fileAndEnv == null){
            fileAndEnv = envAndFile();
        }
        return fileAndEnv;
    }


}

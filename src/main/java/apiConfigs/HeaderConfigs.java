package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

    public Map<String, String> defualtHeaders(){

        Map<String, String> defualtHeaders = new HashMap<String, String>();
        defualtHeaders.put("Content-Type", "application/json");
        return defualtHeaders;
    }
}

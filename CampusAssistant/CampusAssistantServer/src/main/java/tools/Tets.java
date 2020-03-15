package tools;

import java.util.HashMap;
import java.util.Map;

public class Tets {
    public static void main(String[] args) throws Exception {
        Map condiMap = new HashMap();
        condiMap.put("usernam", "xxx");
        DBUtils.query("User", condiMap);
    }
}

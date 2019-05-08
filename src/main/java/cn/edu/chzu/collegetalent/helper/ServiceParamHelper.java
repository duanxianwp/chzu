package cn.edu.chzu.collegetalent.helper;

import com.alibaba.fastjson.JSONObject;

public class ServiceParamHelper {

    public static JSONObject createResultJSONObject(Integer code, String message) {
        JSONObject r = new JSONObject();
        JSONObject h = new JSONObject();
        h.put("code", code);
        h.put("msg", message);
        r.put("head", h);
        r.put("data", new JSONObject());
        return r;
    }

    public static JSONObject createSuccessResultJSONObject() {
        return createResultJSONObject(0, "Success");
    }

    public static JSONObject createFailResultJSONObject() {
        return createResultJSONObject(100, "Error");
    }
    public static JSONObject createFailResultJSONObject(Integer errorCode, String message) {
        return createResultJSONObject(errorCode, message);
    }

}

package cn.edu.chzu.collegetalent.helper;

import com.alibaba.fastjson.JSONObject;

/**
 * @auther: chzu
 * @date: Created in 2019/2/13 16:31
 * @description:
 */
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

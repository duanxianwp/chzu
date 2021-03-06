package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.helper.EncryptHelper;
import cn.edu.chzu.collegetalent.helper.ServiceParamHelper;
import cn.edu.chzu.collegetalent.model.CtAdmin;
import cn.edu.chzu.collegetalent.service.AdminService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CommonsLog
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseApiController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login.do")
    public Object login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password, HttpServletRequest request, HttpServletResponse response){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        if(StringUtils.isNotBlank(username)&&StringUtils.isNotBlank(password)){
            CtAdmin admin = adminService.login(username,EncryptHelper.MD5(password));
            request.getSession().setAttribute("admin", admin);
            responseData.put("data", admin);
        }
        try{
            response.sendRedirect("/index");
        } catch (Exception e){
            log.error("登录成功跳转失败");
        }
        return "ok";
    }

    @PostMapping("/update")
    public Object update(@RequestParam(name = "password") String password, HttpServletRequest request){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        if(StringUtils.isNotBlank(password)){
            CtAdmin admin = (CtAdmin) request.getSession().getAttribute("admin");
            if(admin!=null){
                adminService.update(admin.getId(),password);
            }
        }
        return responseData;
    }

}

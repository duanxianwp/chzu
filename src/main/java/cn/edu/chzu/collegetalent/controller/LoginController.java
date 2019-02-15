package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.exception.ServiceException;
import cn.edu.chzu.collegetalent.helper.ServiceParamHelper;
import cn.edu.chzu.collegetalent.model.CtCompany;
import cn.edu.chzu.collegetalent.model.CtStudents;
import cn.edu.chzu.collegetalent.service.CompanyService;
import cn.edu.chzu.collegetalent.service.StudentService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther: chzu
 * @date: Created in 2019/2/15 09:58
 * @description:
 */
@CommonsLog
@Controller
public class LoginController extends BaseApiController{

    @Autowired
    private CompanyService companyService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/login.do")
    public Object login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        if(StringUtils.isBlank(email)||StringUtils.isBlank(password)){
            throw new ServiceException("登录信息有误，请校验后再登录");
        }

        CtCompany company = companyService.getByEmailAndPassword(email, password);
        if(company != null){
            responseData.put("data",company);
            responseData.put("type",1);
        } else{
            CtStudents students = studentService.getByEmailAndPassword(email, password);
            if(students==null){
                throw new ServiceException("登录信息有误");
            }
            responseData.put("data",students);
            responseData.put("type",2);
        }

        return responseData;
    }

}

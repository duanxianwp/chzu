package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.constant.Constant;
import cn.edu.chzu.collegetalent.exception.ServiceException;
import cn.edu.chzu.collegetalent.helper.ServiceParamHelper;
import cn.edu.chzu.collegetalent.model.CtStudents;
import cn.edu.chzu.collegetalent.service.StudentService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @auther: chzu
 * @date: Created in 2019/2/13 17:16
 * @description:
 */

@CommonsLog
@Controller
@RequestMapping("/students")
public class StudentController extends BaseApiController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login.do")
    public Object login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password){
        if(StringUtils.isBlank(email)||StringUtils.isBlank(password)){
            throw new ServiceException("登录信息有误，请校验后再登录");
        }
        CtStudents students = studentService.getByEmailAndPassword(email, password);
        if(students==null){
            throw new ServiceException("登录信息有误");
        }
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        responseData.put("data", students);
        return responseData;
    }

    @PostMapping("/register.do")
    public Object register(@RequestParam(name = "name") String name,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "sex") String sex,
                           @RequestParam(name = "grade") String grade,
                           @RequestParam(name = "major") String major,
                           @RequestParam(name = "employment") Integer employment,
                           @RequestParam(name = "employmentCompany", required = false, defaultValue = "") String employmentCompany,
                           @RequestParam(name = "employmentCity", required = false, defaultValue = "") String employmentCity,
                           @RequestParam(name = "phone") String phone,
                           @RequestParam(name = "wechat", required = false, defaultValue = "") String wechat,
                           @RequestParam(name = "qq", required = false, defaultValue = "") String qq,
                           @RequestParam(name = "email") String email){
        CtStudents students = new CtStudents();
        students.setName(name);
        students.setPassword(password);
        students.setSex(sex);
        students.setGrade(grade);
        students.setMajor(major);
        students.setEmployment(employment);
        students.setEmploymentCompany(employmentCompany);
        students.setEmploymentCity(employmentCity);
        students.setPhone(phone);
        students.setWechat(wechat);
        students.setQq(qq);
        students.setEmail(email);

        students = studentService.add(students);

        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        responseData.put("data", students);
        return responseData;
    }

    @GetMapping("/get")
    public Object get(@RequestParam(name = "id") Integer id){
        CtStudents students = studentService.getById(id);
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        responseData.put("data",students);
        return responseData;
    }

    @PostMapping("/update")
    public Object update(@RequestParam(name = "id") Integer id,
                         @RequestParam(name = "sex") String sex,
                         @RequestParam(name = "grade") String grade,
                         @RequestParam(name = "major") String major,
                         @RequestParam(name = "employment") Integer employment,
                         @RequestParam(name = "employmentCompany", required = false, defaultValue = "") String employmentCompany,
                         @RequestParam(name = "employmentCity", required = false, defaultValue = "") String employmentCity,
                         @RequestParam(name = "phone") String phone,
                         @RequestParam(name = "wechat", required = false, defaultValue = "") String wechat,
                         @RequestParam(name = "qq", required = false, defaultValue = "") String qq){
        CtStudents students = new CtStudents();
        students.setId(id);
        students.setSex(sex);
        students.setGrade(grade);
        students.setMajor(major);
        students.setEmployment(employment);
        students.setEmploymentCompany(employmentCompany);
        students.setEmploymentCity(employmentCity);
        students.setPhone(phone);
        students.setWechat(wechat);
        students.setQq(qq);

        studentService.update(students);

        return ServiceParamHelper.createSuccessResultJSONObject();
    }

    @PostMapping("/updatePassword")
    public Object updatePassword(@RequestParam(name = "id") Integer id,
                                 @RequestParam(name = "password") String password,
                                 @RequestParam(name = "oldpassword") String oldpassword){

        CtStudents students = studentService.getById(id);
        if(oldpassword.equals(students.getPassword())){
            students.setPassword(password);
            studentService.update(students);
        }

        return ServiceParamHelper.createSuccessResultJSONObject();
    }

    @GetMapping("/list")
    public Object list(@RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                       @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        PageHelper.startPage(pageNum, pageSize);
        List<CtStudents> list = studentService.listAll();
        PageInfo<CtStudents> info = new PageInfo<CtStudents>(list);
        responseData.put("data", list);
        responseData.put("total", info.getTotal());
        responseData.put("totalPage", info.getPages());
        responseData.put("pageNum", pageNum);
        return responseData;
    }

    @PostMapping("/delete")
    public Object delete(@RequestParam(name = "id") Integer id){
        CtStudents students = new CtStudents();
        students.setId(id);
        students.setDelFlag(Constant.DelFlag.DEL);
        studentService.update(students);
        return ServiceParamHelper.createSuccessResultJSONObject();
    }

}

package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.constant.Constant;
import cn.edu.chzu.collegetalent.exception.ServiceException;
import cn.edu.chzu.collegetalent.helper.EncryptHelper;
import cn.edu.chzu.collegetalent.helper.ServiceParamHelper;
import cn.edu.chzu.collegetalent.model.CtStudents;
import cn.edu.chzu.collegetalent.service.StudentService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
                           @RequestParam(name = "conduct", defaultValue = "良好") String conduct,
                           @RequestParam(name = "employment") Integer employment,
                           @RequestParam(name = "employmentCompany", required = false, defaultValue = "") String employmentCompany,
                           @RequestParam(name = "employmentCity", required = false, defaultValue = "") String employmentCity,
                           @RequestParam(name = "phone") String phone,
                           @RequestParam(name = "wechat", required = false, defaultValue = "") String wechat,
                           @RequestParam(name = "qq", required = false, defaultValue = "") String qq,
                           @RequestParam(name = "email") String email){

        CtStudents checkMail = studentService.getByEmail(email);
        if(checkMail!=null){
            throw new ServiceException("此邮箱已被占用，请勿重复注册！");
        }

        CtStudents students = new CtStudents();
        students.setName(name);
        students.setPassword(password);
        students.setSex(sex);
        students.setGrade(grade);
        students.setMajor(major);
        students.setConduct(conduct);
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
                         @RequestParam(name = "conduct", defaultValue = "良好") String conduct,
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
        students.setConduct(conduct);
        students.setEmployment(employment);
        students.setEmploymentCompany(employmentCompany);
        students.setEmploymentCity(employmentCity);
        students.setPhone(phone);
        students.setWechat(wechat);
        students.setQq(qq);

        studentService.update(students);

        return ServiceParamHelper.createSuccessResultJSONObject();
    }

    @GetMapping("/pc/edit")
    public Object pcEdit(@RequestParam(name = "id") Integer id){
        CtStudents students = studentService.getById(id);
        ModelAndView modelAndView = new ModelAndView("student_edit");
        modelAndView.addObject("student", students);
        return modelAndView;
    }

    @PostMapping("/pc/edit.do")
    public Object pcEditDo(@RequestParam(name = "id") Integer id,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "sex") String sex,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "grade") String grade,
                           @RequestParam(name = "major") String major,
                           @RequestParam(name = "conduct") String conduct,
                           @RequestParam(name = "employment") Integer employment,
                           @RequestParam(name = "employmentCompany", required = false, defaultValue = "") String employmentCompany,
                           @RequestParam(name = "employmentCity", required = false, defaultValue = "") String employmentCity,
                           @RequestParam(name = "phone") String phone,
                           @RequestParam(name = "wechat", required = false, defaultValue = "") String wechat,
                           @RequestParam(name = "qq", required = false, defaultValue = "") String qq){
        CtStudents students = studentService.getById(id);
        if(!password.equals(students.getPassword())&&!EncryptHelper.MD5(password).equals(students.getPassword())){
            students.setPassword(EncryptHelper.MD5(password));
        }
        students.setName(name);
        students.setSex(sex);
        students.setGrade(grade);
        students.setMajor(major);
        students.setConduct(conduct);
        students.setEmployment(employment);
        students.setEmploymentCompany(employmentCompany);
        students.setEmploymentCity(employmentCity);
        students.setPhone(phone);
        students.setWechat(wechat);
        students.setQq(qq);

        studentService.update(students);

        PageHelper.startPage(1, 10);
        List<CtStudents> list = studentService.listAll();
        PageInfo<CtStudents> info = new PageInfo<CtStudents>(list);

        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }

    @GetMapping("/pc/add/check")
    public Object pcAddCheckMail(@RequestParam String email){
        CtStudents checkMail = studentService.getByEmail(email);
        if(checkMail!=null){
            throw new ServiceException("此邮箱已被占用，请更换邮箱地址！");
        }
        return ServiceParamHelper.createSuccessResultJSONObject();
    }

    @PostMapping("/pc/add")
    public Object pcAdd(@RequestParam(name = "name") String name,
                        @RequestParam(name = "sex") String sex,
                        @RequestParam(name = "grade") String grade,
                        @RequestParam(name = "major") String major,
                        @RequestParam(name = "conduct") String conduct,
                        @RequestParam(name = "employment") Integer employment,
                        @RequestParam(name = "employmentCompany", required = false, defaultValue = "") String employmentCompany,
                        @RequestParam(name = "employmentCity", required = false, defaultValue = "") String employmentCity,
                        @RequestParam(name = "phone") String phone,
                        @RequestParam(name = "wechat", required = false, defaultValue = "") String wechat,
                        @RequestParam(name = "qq", required = false, defaultValue = "") String qq,
                        @RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password){

        CtStudents checkMail = studentService.getByEmail(email);
        if(checkMail!=null){
            throw new ServiceException("此邮箱已被占用，请勿重复注册！");
        }

        CtStudents students = new CtStudents();
        students.setName(name);
        students.setSex(sex);
        students.setGrade(grade);
        students.setMajor(major);
        students.setConduct(conduct);
        students.setEmployment(employment);
        students.setEmploymentCompany(employmentCompany);
        students.setEmploymentCity(employmentCity);
        students.setPhone(phone);
        students.setWechat(wechat);
        students.setQq(qq);
        students.setEmail(email);
        students.setPassword(EncryptHelper.MD5(password));
        students.setCreateTime(new Date());
        students.setUpdateTime(new Date());

        studentService.add(students);

        PageHelper.startPage(1, 10);
        List<CtStudents> list = studentService.listAll();
        PageInfo<CtStudents> info = new PageInfo<CtStudents>(list);

        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }

    @PostMapping("/updatePassword")
    public Object updatePassword(@RequestParam(name = "id") Integer id,
                                 @RequestParam(name = "password") String password,
                                 @RequestParam(name = "oldpassword") String oldpassword){

        CtStudents students = studentService.getById(id);
        if(students==null||students.getId()==null){
            throw new ServiceException("用户信息不存在");
        }
        if(!oldpassword.equals(students.getPassword())){
            throw new ServiceException("原密码不正确");
        }

        students.setPassword(password);
        students.setUpdateTime(new Date());
        studentService.update(students);

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

    @GetMapping("/view/list")
    public Object viewList(@RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                           @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){

        PageHelper.startPage(pageNum, pageSize);
        List<CtStudents> list = studentService.listAll();
        PageInfo<CtStudents> info = new PageInfo<CtStudents>(list);

        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }

    @GetMapping("/view/search")
    public Object viewSearch(@RequestParam String key,
                             @RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                             @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){

        PageHelper.startPage(pageNum, pageSize);
        List<CtStudents> list = studentService.search(key);
        PageInfo<CtStudents> info = new PageInfo<CtStudents>(list);

        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }


    @RequestMapping(value = "/pc/del", method = {RequestMethod.GET, RequestMethod.POST})
    public Object delete(@RequestParam(name = "id") Integer id){
        CtStudents students = new CtStudents();
        students.setId(id);
        students.setDelFlag(Constant.DelFlag.DEL);
        studentService.update(students);

        PageHelper.startPage(1, 20);
        List<CtStudents> list = studentService.listAll();
        PageInfo<CtStudents> info = new PageInfo<CtStudents>(list);

        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }


    @GetMapping("/employment")
    public Object employment(){

        Map<Integer,List<CtStudents>> map =  studentService.listAll().stream().collect(Collectors.groupingBy(CtStudents::getEmployment));

        Integer employmentNum = 0,unemploymentNum = 0;

        if(map.containsKey(1)&&!map.get(1).isEmpty()){
            employmentNum = map.get(1).size();
        }
        if(map.containsKey(0)&&!map.get(0).isEmpty()){
            unemploymentNum = map.get(0).size();
        }

        ModelAndView modelAndView = new ModelAndView("employment");
        modelAndView.addObject("unemploy", unemploymentNum);
        modelAndView.addObject("employ", employmentNum);
        log.info("modelAndView"+modelAndView );
        return modelAndView;
    }

    @GetMapping("/conduct")
    public Object conduct(){

        Map<String,List<CtStudents>> map =  studentService.listAll().stream().collect(Collectors.groupingBy(CtStudents::getConduct));

        Integer level1 = 0,level2 = 0, level3=0, level4=0;

        if(map.containsKey("优秀")&&!map.get("优秀").isEmpty()){
            level1 = map.get("优秀").size();
        }
        if(map.containsKey("良好")&&!map.get("良好").isEmpty()){
            level2 = map.get("良好").size();
        }
        if(map.containsKey("一般")&&!map.get("一般").isEmpty()){
            level3 = map.get("一般").size();
        }
        if(map.containsKey("较差")&&!map.get("较差").isEmpty()){
            level4 = map.get("较差").size();
        }

        ModelAndView modelAndView = new ModelAndView("conduct");
        modelAndView.addObject("level1", level1);
        modelAndView.addObject("level2", level2);
        modelAndView.addObject("level3", level3);
        modelAndView.addObject("level4", level4);
        return modelAndView;
    }

    @GetMapping("/city")
    public Object city(){

        List<CtStudents> list = studentService.city();

        Map<String,List<CtStudents>> map =  list.stream().collect(Collectors.groupingBy(CtStudents::getEmploymentCity));

        Integer beijing = 0,shanghai = 0, guangzhou=0, shenzhen=0, hangzhou=0, nanjing=0, hefei=0, qita=0;

        if(map.containsKey("北京")&&!map.get("北京").isEmpty()){
            beijing = map.get("北京").size();
        }
        if(map.containsKey("上海")&&!map.get("上海").isEmpty()){
            shanghai = map.get("上海").size();
        }
        if(map.containsKey("广州")&&!map.get("广州").isEmpty()){
            guangzhou = map.get("广州").size();
        }
        if(map.containsKey("深圳")&&!map.get("深圳").isEmpty()){
            shenzhen = map.get("深圳").size();
        }
        if(map.containsKey("杭州")&&!map.get("杭州").isEmpty()){
            hangzhou = map.get("杭州").size();
        }
        if(map.containsKey("南京")&&!map.get("南京").isEmpty()){
            nanjing = map.get("南京").size();
        }
        if(map.containsKey("合肥")&&!map.get("合肥").isEmpty()){
            hefei = map.get("合肥").size();
        }

        qita = list.size() - beijing - shanghai - guangzhou - shenzhen - hangzhou - nanjing - hefei;

        ModelAndView modelAndView = new ModelAndView("city");
        modelAndView.addObject("beijing", beijing);
        modelAndView.addObject("shanghai", shanghai);
        modelAndView.addObject("guangzhou", guangzhou);
        modelAndView.addObject("shenzhen", shenzhen);
        modelAndView.addObject("hangzhou", hangzhou);
        modelAndView.addObject("nanjing", nanjing);
        modelAndView.addObject("hefei", hefei);
        modelAndView.addObject("qita", qita);
        return modelAndView;
    }

    @GetMapping("/relevance")
    public Object relevance(){

        List<CtStudents> list = studentService.listAll();

        Map<String,List<CtStudents>> conductMap =  list.stream().collect(Collectors.groupingBy(CtStudents::getConduct));


        Map<Integer,List<CtStudents>> employMap =  list.stream().collect(Collectors.groupingBy(CtStudents::getEmployment));

        Integer employmentNum = 0;

        if(employMap.containsKey(1)&&!employMap.get(1).isEmpty()){
            employmentNum = employMap.get(1).size();
        }

        Integer youxiu = 0;

        if(conductMap.containsKey("优秀")&&!conductMap.get("优秀").isEmpty()){
            List<CtStudents> youxiuStudents = conductMap.get("优秀").stream().collect(Collectors.groupingBy(CtStudents::getEmployment)).get(1);
            if(!youxiuStudents.isEmpty()){
                youxiu = youxiuStudents.size();
            }
        }

        float data = 0f;
        if(employmentNum!=0&&youxiu!=0){
            data = (youxiu*1.0f/employmentNum)*100;
        }

        float b = (float)(Math.round(data*100))/100;

        ModelAndView modelAndView = new ModelAndView("relevance");
        modelAndView.addObject("data", b);
        return modelAndView;
    }

}

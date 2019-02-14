package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.constant.Constant;
import cn.edu.chzu.collegetalent.helper.ServiceParamHelper;
import cn.edu.chzu.collegetalent.model.CtCompany;
import cn.edu.chzu.collegetalent.service.CompanyService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @auther: chzu
 * @date: Created in 2019/2/14 00:53
 * @description:
 */
@CommonsLog
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseApiController{
    @Autowired
    private CompanyService companyService;

    @PostMapping("/login.do")
    public Object login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        CtCompany company = companyService.getByEmailAndPassword(email, password);
        if(company != null){
            responseData.put("data",company);
        }
        return responseData;
    }

    @PostMapping("/register.do")
    public Object register(@RequestParam(name = "name") String name,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "contact") String contact,
                           @RequestParam(name = "address") String address,
                           @RequestParam(name = "phone") String phone,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "serviceTrade") String serviceTrade){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        CtCompany company = new CtCompany();
        company.setName(name);
        company.setPassword(password);
        company.setContact(contact);
        company.setAddress(address);
        company.setPhone(phone);
        company.setEmail(email);
        company.setServiceTrade(serviceTrade);

        company = companyService.add(company);
        responseData.put("data",company);

        return responseData;
    }

    @PostMapping("/update")
    public Object update(@RequestParam(name = "id") Integer id,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "password") String password,
                         @RequestParam(name = "contact") String contact,
                         @RequestParam(name = "address") String address,
                         @RequestParam(name = "phone") String phone,
                         @RequestParam(name = "email") String email,
                         @RequestParam(name = "serviceTrade") String serviceTrade){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        CtCompany company = new CtCompany();
        company.setId(id);
        company.setName(name);
        company.setPassword(password);
        company.setContact(contact);
        company.setAddress(address);
        company.setPhone(phone);
        company.setEmail(email);
        company.setServiceTrade(serviceTrade);

        companyService.update(company);

        return responseData;
    }

    @PostMapping("/updatePassword")
    public Object updatePassword(@RequestParam(name = "id") Integer id,
                         @RequestParam(name = "password") String password){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        CtCompany company = new CtCompany();
        company.setId(id);
        company.setPassword(password);
        companyService.update(company);
        return responseData;
    }

    @GetMapping("/get")
    public Object get(@RequestParam(name = "id") Integer id){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        CtCompany company = companyService.get(id);
        responseData.put("data", company);
        return responseData;
    }

    @GetMapping("/list")
    public Object list(@RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                       @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        PageHelper.startPage(pageNum, pageSize);
        List<CtCompany> list = companyService.listAll();
        PageInfo<CtCompany> info = new PageInfo<CtCompany>(list);

        responseData.put("data", list);
        responseData.put("total", info.getTotal());
        responseData.put("totalPage", info.getPages());
        responseData.put("pageNum", pageNum);
        return responseData;
    }

    @PostMapping("/delete")
    public Object delete(@RequestParam(name = "id") Integer id){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        CtCompany company = new CtCompany();
        company.setId(id);
        company.setDelFlag(Constant.DelFlag.DEL);
        companyService.update(company);
        return responseData;
    }


}

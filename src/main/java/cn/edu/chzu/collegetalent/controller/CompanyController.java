package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.constant.Constant;
import cn.edu.chzu.collegetalent.exception.ServiceException;
import cn.edu.chzu.collegetalent.helper.EncryptHelper;
import cn.edu.chzu.collegetalent.helper.ServiceParamHelper;
import cn.edu.chzu.collegetalent.model.CtCompany;
import cn.edu.chzu.collegetalent.service.CompanyService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

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

        CtCompany checkMail = companyService.getByEmail(email);
        if(checkMail!=null){
            throw new ServiceException("此邮箱已被占用，请勿重复注册！");
        }

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

    @GetMapping("/pc/add/check")
    public Object pcAddCheckMail(@RequestParam String email){
        CtCompany checkMail = companyService.getByEmail(email);
        if(checkMail!=null){
            throw new ServiceException("此邮箱已被占用，请更换邮箱地址！");
        }
        return ServiceParamHelper.createSuccessResultJSONObject();
    }

    @PostMapping("/pc/add")
    public Object pcAdd(@RequestParam(name = "name") String name,
                        @RequestParam(name = "password") String password,
                        @RequestParam(name = "contact") String contact,
                        @RequestParam(name = "address") String address,
                        @RequestParam(name = "phone") String phone,
                        @RequestParam(name = "email") String email,
                        @RequestParam(name = "serviceTrade") String serviceTrade){
        CtCompany checkMail = companyService.getByEmail(email);
        if(checkMail!=null){
            throw new ServiceException("此邮箱已被占用，请勿重复注册！");
        }

        CtCompany company = new CtCompany();
        company.setName(name);
        company.setPassword(EncryptHelper.MD5(password));
        company.setContact(contact);
        company.setAddress(address);
        company.setPhone(phone);
        company.setEmail(email);
        company.setServiceTrade(serviceTrade);

        companyService.add(company);

        PageHelper.startPage(1, 10);
        List<CtCompany> list = companyService.listAll();
        PageInfo<CtCompany> info = new PageInfo<CtCompany>(list);

        ModelAndView modelAndView = new ModelAndView("company");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }


    @PostMapping("/update")
    public Object update(@RequestParam(name = "id") Integer id,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "contact") String contact,
                         @RequestParam(name = "address") String address,
                         @RequestParam(name = "phone") String phone,
                         @RequestParam(name = "email") String email,
                         @RequestParam(name = "serviceTrade") String serviceTrade){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        CtCompany company = new CtCompany();
        company.setId(id);
        company.setName(name);
        company.setContact(contact);
        company.setAddress(address);
        company.setPhone(phone);
        company.setEmail(email);
        company.setServiceTrade(serviceTrade);

        companyService.update(company);

        return responseData;
    }

    @GetMapping("/pc/edit")
    public Object pcEdit(@RequestParam(name = "id") Integer id){
        CtCompany company = companyService.get(id);
        ModelAndView modelAndView = new ModelAndView("company_edit");
        modelAndView.addObject("company", company);
        return modelAndView;
    }

    @PostMapping("/pc/edit.do")
    public Object pcEditDo(@RequestParam(name = "id") Integer id,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "contact") String contact,
                           @RequestParam(name = "address") String address,
                           @RequestParam(name = "phone") String phone,
                           //@RequestParam(name = "email") String email,
                           @RequestParam(name = "serviceTrade") String serviceTrade){

        CtCompany company = companyService.get(id);
        if(!password.equals(company.getPassword())&&!EncryptHelper.MD5(password).equals(company.getPassword())){
            company.setPassword(EncryptHelper.MD5(password));
        }
        company.setId(id);
        company.setName(name);
        company.setContact(contact);
        company.setAddress(address);
        company.setPhone(phone);
        //company.setEmail(email);
        company.setServiceTrade(serviceTrade);

        companyService.update(company);

        PageHelper.startPage(1, 10);
        List<CtCompany> list = companyService.listAll();
        PageInfo<CtCompany> info = new PageInfo<CtCompany>(list);

        ModelAndView modelAndView = new ModelAndView("company");
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
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        CtCompany company = companyService.get(id);
        if(company==null||company.getId()==null){
            throw new ServiceException("用户不存在");
        }
        if(!oldpassword.equals(company.getPassword())){
            throw new ServiceException("原密码不正确");
        }
        company.setPassword(password);
        company.setUpdateTime(new Date());
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

    @GetMapping("/view/search")
    public Object viewSearch(@RequestParam String key,
                             @RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                             @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<CtCompany> list = companyService.search(key);
        PageInfo<CtCompany> info = new PageInfo<CtCompany>(list);

        ModelAndView modelAndView = new ModelAndView("company");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }

    @GetMapping("/view/list")
    public Object listView(@RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                           @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){

        PageHelper.startPage(pageNum, pageSize);
        List<CtCompany> list = companyService.listAll();
        PageInfo<CtCompany> info = new PageInfo<CtCompany>(list);

        ModelAndView modelAndView = new ModelAndView("company");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }

    @RequestMapping(value = "/pc/del",method = {RequestMethod.GET,RequestMethod.POST})
    public Object delete(@RequestParam(name = "id") Integer id){
        CtCompany company = new CtCompany();
        company.setId(id);
        company.setDelFlag(Constant.DelFlag.DEL);
        companyService.update(company);

        PageHelper.startPage(1, 10);
        List<CtCompany> list = companyService.listAll();
        PageInfo<CtCompany> info = new PageInfo<CtCompany>(list);

        ModelAndView modelAndView = new ModelAndView("company");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }


}

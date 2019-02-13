package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.helper.EncryptHelper;
import cn.edu.chzu.collegetalent.helper.ServiceParamHelper;
import cn.edu.chzu.collegetalent.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: chzu
 * @date: Created in 2019/1/17 13:36
 * @description: 启动监控
 */
@Controller
@ResponseBody
public class KeepAlivedController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/keepalived")
    public String keepalived(){
        return "ok";
    }

}

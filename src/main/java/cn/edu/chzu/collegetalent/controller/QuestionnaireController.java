package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.constant.Constant;
import cn.edu.chzu.collegetalent.helper.ServiceParamHelper;
import cn.edu.chzu.collegetalent.model.CtQuestionnaires;
import cn.edu.chzu.collegetalent.service.QuestionnaireService;
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

import java.util.Date;
import java.util.List;

/**
 * @auther: chzu
 * @date: Created in 2019/2/14 11:17
 * @description:
 */
@CommonsLog
@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController extends BaseApiController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping("/add")
    public Object add(@RequestParam(name = "name") String name,
                      @RequestParam(name = "type") String type,
                      @RequestParam(name = "endTime") String endTime){
        CtQuestionnaires questionnaires = new CtQuestionnaires();
        questionnaires.setName(name);
        questionnaires.setType(type);
        questionnaires.setEndTime(new Date(endTime));
        questionnaires = questionnaireService.add(questionnaires);
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        responseData.put("data", questionnaires);
        return responseData;
    }

    @GetMapping("/get")
    public Object get(@RequestParam(name = "id") Integer id){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        log.info("处理器方法get,参数id=" + id);
        responseData.put("data", questionnaireService.get(id));
        return responseData;
    }

    @GetMapping("/list")
    public Object list(@RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                       @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        PageHelper.startPage(pageNum,pageSize);
        List<CtQuestionnaires> list = questionnaireService.listAll();
        PageInfo<CtQuestionnaires> info = new PageInfo<CtQuestionnaires>(list);

        responseData.put("data", list);
        responseData.put("total", info.getTotal());
        responseData.put("totalPage", info.getPages());
        responseData.put("pageNum", pageNum);

        return responseData;
    }

    @GetMapping("/listWithSubject")
    public Object listWithSubject(@RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                       @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        //PageHelper.startPage(pageNum,pageSize);
        List<CtQuestionnaires> list = questionnaireService.listAllWithSubject(null);
        //PageInfo<CtQuestionnaires> info = new PageInfo<CtQuestionnaires>(list);

        responseData.put("data", list);
        //responseData.put("total", info.getTotal());
        //responseData.put("totalPage", info.getPages());
        //responseData.put("pageNum", pageNum);

        return responseData;
    }

    @PostMapping("/addWithSubjest")
    public Object addWithSubjest(){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        return responseData;
    }

}

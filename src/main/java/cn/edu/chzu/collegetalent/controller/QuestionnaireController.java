package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.constant.Constant;
import cn.edu.chzu.collegetalent.helper.DateHelper;
import cn.edu.chzu.collegetalent.helper.ServiceParamHelper;
import cn.edu.chzu.collegetalent.model.*;
import cn.edu.chzu.collegetalent.service.*;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.stream.events.EndDocument;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @auther: chzu
 * @date: Created in 2019/2/14 11:17
 * @description:
 */
@CommonsLog
@Controller
@ResponseBody
@RequestMapping("/questionnaire")
public class QuestionnaireController extends BaseApiController {
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/pc/add")
    public Object add(@RequestParam(name = "name") String name,
                      @RequestParam(name = "type") String type,
                      @RequestParam(name = "endTime") String endTime){
        CtQuestionnaires questionnaires = new CtQuestionnaires();
        questionnaires.setName(name);
        questionnaires.setType(type);
        Date endDate = DateHelper.toDate(endTime);
        questionnaires.setEndTime(endDate);
        questionnaires.setCreateTime(new Date());
        questionnaires.setUpdateTime(new Date());
        questionnaireService.add(questionnaires);

        PageHelper.startPage(1,10);
        List<CtQuestionnaires> list = questionnaireService.listAll();
        PageInfo<CtQuestionnaires> info = new PageInfo<CtQuestionnaires>(list);

        ModelAndView modelAndView = new ModelAndView("question");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }

    @GetMapping("/get")
    public Object get(@RequestParam(name = "id") Integer id){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        log.info("处理器方法get,参数id=" + id);
        responseData.put("data", questionnaireService.get(id));
        return responseData;
    }

    @GetMapping("/pc/del")
    public Object delete(@RequestParam(name = "id") Integer id){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();
        log.info("处理器方法get,参数id=" + id);
        CtQuestionnaires questionnaires = new CtQuestionnaires();
        questionnaires.setId(id);
        questionnaires.setDelFlag(Constant.DelFlag.DEL);
        questionnaireService.update(questionnaires);

        PageHelper.startPage(1,10);
        List<CtQuestionnaires> list = questionnaireService.listAll();
        PageInfo<CtQuestionnaires> info = new PageInfo<CtQuestionnaires>(list);

        ModelAndView modelAndView = new ModelAndView("question");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }

    @GetMapping("/add_subject")
    public Object addSubject(@RequestParam(name = "id") Integer id){
        CtQuestionnaires questionnaires = questionnaireService.get(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("question_add_subject");
        modelAndView.addObject("qn",questionnaires);
        modelAndView.addObject("count", questionnaires.getSubjects().size());

        return modelAndView;
    }

    @RequestMapping(value = "/pc/delSubject",method = {RequestMethod.GET,RequestMethod.POST})
    public Object delSubject(@RequestParam(name = "id") Integer id){
        Integer qId = subjectService.get(id).getQnId();
        subjectService.del(id);

        CtQuestionnaires questionnaires = questionnaireService.get(qId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("question_add_subject");
        modelAndView.addObject("qn", questionnaires);
        modelAndView.addObject("count", questionnaires.getSubjects().size());

        return modelAndView;
    }


    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "0") Integer id,
                       @RequestParam(defaultValue = "学生") String type,
                       @RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                       @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        PageHelper.startPage(pageNum,pageSize);
        List<CtQuestionnaires> list = questionnaireService.listByType(type);
        PageInfo<CtQuestionnaires> info = new PageInfo<CtQuestionnaires>(list);

        responseData.put("data", list);
        responseData.put("total", info.getTotal());
        responseData.put("totalPage", info.getPages());
        responseData.put("pageNum", pageNum);

        return responseData;
    }

    @GetMapping("/view/list")
    public Object listView(@RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                       @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<CtQuestionnaires> list = questionnaireService.listAll();
        PageInfo<CtQuestionnaires> info = new PageInfo<CtQuestionnaires>(list);

        ModelAndView modelAndView = new ModelAndView("question");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
    }

    @GetMapping("/view/search")
    public Object searchView(@RequestParam String key ,@RequestParam(name = "pageNum", defaultValue = Constant.defaultPageNum) Integer pageNum,
                           @RequestParam(name = "pageSize", defaultValue = Constant.defaultPageSize) Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<CtQuestionnaires> list = questionnaireService.search(key);
        PageInfo<CtQuestionnaires> info = new PageInfo<CtQuestionnaires>(list);

        ModelAndView modelAndView = new ModelAndView("question");
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", info.getTotal());
        modelAndView.addObject("pages", info.getPages());
        modelAndView.addObject("pageNum", info.getPageNum());
        return modelAndView;
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

    /*
     * 移动端提交问卷调查结果
     */
    @RequestMapping(value = "/addWithSubject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object addWithSubject(@RequestBody JSONObject requestData){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        JSONObject answerData = requestData.getJSONObject("answerData");

        Integer answerId = requestData.getInteger("answerId");
        Integer qnId = requestData.getInteger("qnId");

        String answerType = "学生";
        String answerName = "";

        CtQuestionnaires questionnaires = questionnaireService.get(qnId);
        if(questionnaires.getType().equals("企业")){
            CtCompany company = companyService.get(answerId);
            answerType = "企业";
            answerName = company.getName();
        }
        if(questionnaires.getType().equals("学生")){
            CtStudents students = studentService.getById(answerId);
            answerName = students.getName();
        }

        for(String key : answerData.keySet()){
            Integer subId = Integer.parseInt(key);
            CtAnswer answer = new CtAnswer();
            answer.setQnId(qnId);
            answer.setAnswerId(answerId);
            answer.setAnswerName(answerName);
            answer.setAnswerType(answerType);
            answer.setSubjectNum(subId);
            answer.setSubjectContent(subjectService.get(subId).getContent());
            answer.setAnswer(answerData.getString(key));
            answer.setCreateTime(new Date());
            answerService.add(answer);
            log.info("add answer to db ...");
        }

        return responseData;
    }

    @RequestMapping(value = "/pc/addSubject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object pcAddSubject(@RequestBody List<CtSubject> subjects){
        JSONObject responseData = ServiceParamHelper.createSuccessResultJSONObject();

        log.info(subjects.size());

        for(CtSubject subject : subjects){
            subject.setDelFlag(Constant.DelFlag.NODEL);
            subject.setCreateTime(new Date());
            subject.setUpdateTime(new Date());
            subjectService.add(subject);
            log.info("insert in to db "+ subject);
        }

        return responseData;
    }


}

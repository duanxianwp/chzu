package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.dao.CtAnswerMapper;
import cn.edu.chzu.collegetalent.model.CtAnswer;
import cn.edu.chzu.collegetalent.model.CtAnswerExample;
import cn.edu.chzu.collegetalent.model.CtSubject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnswerService {
    @Autowired
    private CtAnswerMapper answerMapper;

    @Autowired
    private SubjectService subjectService;

    public CtAnswer add(CtAnswer answer) {
        answerMapper.insertSelective(answer);
        return answer;
    }

    public List<CtAnswer> list() {
        CtAnswerExample example = new CtAnswerExample();
        example.createCriteria();
        return answerMapper.selectByExample(example);
    }

    /**
     * 分析选项情况
     *
     * @param qnId
     * @param subjectNum
     * @return
     */
    public Map<String, Object> list(Integer qnId, Integer subjectNum) {


        Map<String, Object> resp = new HashMap<>();
        CtSubject ctSubject = subjectService.get(qnId, subjectNum);

        /**
         * 问题
         */
        resp.put("subject_content", ctSubject == null ? null : ctSubject.getContent());

        /**
         * 找出所有选项
         */
        JSONObject options = JSON.parseObject(ctSubject.getOption());
        if (options!=null && options.size()>0){
            for (String key : options.keySet()) {
                resp.put("answer_"+key.toLowerCase(),options.get(key));
            }
        }
        JSONArray optionJson = ctSubject.getOptionJson();
        for (int i = 0; i < optionJson.size(); i++) {
            String option = JSON.parseObject(JSON.toJSONString(optionJson.get(i))).get("optionSelector").toString();
            resp.put("answer_"+option.split(" ")[0].toLowerCase()+"_num",countByAnswer(qnId,subjectNum,option));
        }
        return resp;
    }

    public Integer countByAnswer(Integer qnId,Integer subjectNum,String answer){

        CtAnswerExample ctAnswerExample = new CtAnswerExample();
        ctAnswerExample.createCriteria()
                .andQnIdEqualTo(qnId)
                .andSubjectNumEqualTo(subjectNum)
                .andAnswerEqualTo(answer);
        return answerMapper.countByExample(ctAnswerExample);
    }
}

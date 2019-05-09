package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.dao.CtAnswerMapper;
import cn.edu.chzu.collegetalent.model.CtAnswer;
import cn.edu.chzu.collegetalent.model.CtAnswerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, Object> list(Integer qnId, Integer subjectNum) {

        CtAnswerExample ctAnswerExample = new CtAnswerExample();
        ctAnswerExample.createCriteria()
                .andQnIdEqualTo(qnId)
                .andSubjectNumEqualTo(subjectNum);

        List<CtAnswer> ctAnswers = answerMapper.selectByExample(ctAnswerExample);
        Map<String, Object> resp = new HashMap<>();
        resp.put("question", subjectService.get(qnId, subjectNum));
        if (CollectionUtils.isEmpty(ctAnswers)) {
            return resp;
        }
        resp.put("data", ctAnswers.stream().collect(Collectors.groupingBy(CtAnswer::getAnswer, Collectors.counting())));
        return resp;
    }
}

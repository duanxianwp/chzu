package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.dao.CtAnswerMapper;
import cn.edu.chzu.collegetalent.model.CtAnswer;
import cn.edu.chzu.collegetalent.model.CtAnswerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    @Autowired
    private CtAnswerMapper answerMapper;

    public CtAnswer add(CtAnswer answer){
        answerMapper.insertSelective(answer);
        return answer;
    }

    public List<CtAnswer> list(){
        CtAnswerExample example = new CtAnswerExample();
        example.createCriteria();
        return answerMapper.selectByExample(example);
    }

    public Map<String,Long> list(Integer qnId, Integer subjectNum){

        CtAnswerExample ctAnswerExample = new CtAnswerExample();
        ctAnswerExample.createCriteria()
                .andQnIdEqualTo(qnId)
                .andSubjectNumEqualTo(subjectNum);

        List<CtAnswer> ctAnswers = answerMapper.selectByExample(ctAnswerExample);
        return ctAnswers.stream().collect(Collectors.groupingBy(CtAnswer::getSubjectContent,Collectors.counting()));
    }
}

package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.dao.CtAnswerMapper;
import cn.edu.chzu.collegetalent.model.CtAnswer;
import cn.edu.chzu.collegetalent.model.CtAnswerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: chzu
 * @date: Created in 2019/4/19 14:10
 * @description:
 */
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


}

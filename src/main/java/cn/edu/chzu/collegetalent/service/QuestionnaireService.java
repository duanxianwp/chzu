package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.constant.Constant;
import cn.edu.chzu.collegetalent.dao.CtQuestionnairesMapper;
import cn.edu.chzu.collegetalent.dao.CtSubjectMapper;
import cn.edu.chzu.collegetalent.model.CtQuestionnaires;
import cn.edu.chzu.collegetalent.model.CtQuestionnairesExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuestionnaireService {

    @Autowired
    private CtQuestionnairesMapper questionnairesMapper;
    @Autowired
    private CtSubjectMapper subjectMapper;

    public CtQuestionnaires add(CtQuestionnaires questionnaires){
        questionnairesMapper.insertSelective(questionnaires);
        return questionnaires;
    }

    public boolean update(CtQuestionnaires questionnaires){
        questionnairesMapper.updateByPrimaryKeySelective(questionnaires);
        return true;
    }

    public CtQuestionnaires get(Integer id){
        CtQuestionnaires questionnaires = questionnairesMapper.selectByPrimaryKey(id);
        questionnaires.setSubjects(subjectMapper.selectByQnId(id));
        return questionnaires;
    }

    public List<CtQuestionnaires> listByType(String type){
        CtQuestionnairesExample example = new CtQuestionnairesExample();
        example.createCriteria()
                .andTypeEqualTo(type)
                .andDelFlagEqualTo(Constant.DelFlag.NODEL);
        return questionnairesMapper.selectByExample(example);
    }

    public List<CtQuestionnaires> listAll(){
        CtQuestionnairesExample example = new CtQuestionnairesExample();
        example.createCriteria()
                .andDelFlagEqualTo(Constant.DelFlag.NODEL);
        return questionnairesMapper.selectByExample(example);
    }

    public List<CtQuestionnaires> search(String key){
        return questionnairesMapper.search(key);
    }

    public List<CtQuestionnaires> listAllWithSubject(CtQuestionnaires questionnaires){
        return questionnairesMapper.selectQuestionnaireWithSubject(questionnaires);
    }

}

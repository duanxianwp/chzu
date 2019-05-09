package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.dao.CtSubjectMapper;
import cn.edu.chzu.collegetalent.model.CtSubject;
import cn.edu.chzu.collegetalent.model.CtSubjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private CtSubjectMapper subjectMapper;

    public CtSubject get(Integer id){
        return subjectMapper.selectByPrimaryKey(id);
    }

    public CtSubject add(CtSubject subject){
        subjectMapper.insertSelective(subject);
        return subject;
    }

    public boolean del(Integer id){
        subjectMapper.deleteByPrimaryKey(id);
        return true;
    }

    public CtSubject get(Integer qnId, Integer num){
        CtSubjectExample subjectExample = new CtSubjectExample();
        subjectExample.createCriteria()
                .andQnIdEqualTo(qnId)
                .andNumEqualTo(num);
        List<CtSubject> ctSubjects = subjectMapper.selectByExample(subjectExample);
        return CollectionUtils.isEmpty(ctSubjects)?null:ctSubjects.get(0);
    }

    public List<CtSubject> getSubjectsByQsId(Integer qnId){
        return subjectMapper.selectByQnId(qnId);
    }
}

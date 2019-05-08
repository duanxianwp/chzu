package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.dao.CtSubjectMapper;
import cn.edu.chzu.collegetalent.model.CtSubject;
import cn.edu.chzu.collegetalent.model.CtSubjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<CtSubject> getSubjectsByQsId(Integer qnId){
        return subjectMapper.selectByQnId(qnId);
    }
}

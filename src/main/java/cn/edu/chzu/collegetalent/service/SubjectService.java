package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.dao.CtSubjectMapper;
import cn.edu.chzu.collegetalent.model.CtSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: chzu
 * @date: Created in 2019/4/19 14:17
 * @description:
 */
@Service
public class SubjectService {
    @Autowired
    private CtSubjectMapper subjectMapper;

    public CtSubject get(Integer id){
        return subjectMapper.selectByPrimaryKey(id);
    }

}

package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.constant.Constant;
import cn.edu.chzu.collegetalent.dao.CtStudentsMapper;
import cn.edu.chzu.collegetalent.model.CtStudents;
import cn.edu.chzu.collegetalent.model.CtStudentsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: chzu
 * @date: Created in 2019/2/13 17:16
 * @description:
 */
@Service
public class StudentService {

    @Autowired
    private CtStudentsMapper studentsMapper;

    public CtStudents add(CtStudents students){
        studentsMapper.insertSelective(students);
        return students;
    }

    public boolean update(CtStudents students){
        studentsMapper.updateByPrimaryKeySelective(students);
        return true;
    }

    public CtStudents getByEmailAndPassword(String email, String password){
        return studentsMapper.getByEmailAndPassword(email, password);
    }

    public CtStudents getById(Integer id){
        return studentsMapper.selectByPrimaryKey(id);
    }

    public List<CtStudents> listAll(){
        CtStudentsExample example = new CtStudentsExample();
        example.createCriteria().andDelFlagEqualTo(Constant.DelFlag.NODEL);
        return studentsMapper.selectByExample(example);
    }

    public List<CtStudents> search(String key){
        return studentsMapper.search(key);
    }

}

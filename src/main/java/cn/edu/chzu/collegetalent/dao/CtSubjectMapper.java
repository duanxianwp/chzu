package cn.edu.chzu.collegetalent.dao;

import cn.edu.chzu.collegetalent.model.CtSubject;
import cn.edu.chzu.collegetalent.model.CtSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtSubjectMapper {
    int countByExample(CtSubjectExample example);

    int deleteByExample(CtSubjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CtSubject record);

    int insertSelective(CtSubject record);

    List<CtSubject> selectByExample(CtSubjectExample example);

    CtSubject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CtSubject record, @Param("example") CtSubjectExample example);

    int updateByExample(@Param("record") CtSubject record, @Param("example") CtSubjectExample example);

    int updateByPrimaryKeySelective(CtSubject record);

    int updateByPrimaryKey(CtSubject record);
}
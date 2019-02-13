package cn.edu.chzu.collegetalent.dao;

import cn.edu.chzu.collegetalent.model.CtAnswer;
import cn.edu.chzu.collegetalent.model.CtAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtAnswerMapper {
    int countByExample(CtAnswerExample example);

    int deleteByExample(CtAnswerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CtAnswer record);

    int insertSelective(CtAnswer record);

    List<CtAnswer> selectByExample(CtAnswerExample example);

    CtAnswer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CtAnswer record, @Param("example") CtAnswerExample example);

    int updateByExample(@Param("record") CtAnswer record, @Param("example") CtAnswerExample example);

    int updateByPrimaryKeySelective(CtAnswer record);

    int updateByPrimaryKey(CtAnswer record);
}
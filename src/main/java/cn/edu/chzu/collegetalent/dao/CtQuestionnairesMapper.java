package cn.edu.chzu.collegetalent.dao;

import cn.edu.chzu.collegetalent.model.CtQuestionnaires;
import cn.edu.chzu.collegetalent.model.CtQuestionnairesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtQuestionnairesMapper {
    int countByExample(CtQuestionnairesExample example);

    int deleteByExample(CtQuestionnairesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CtQuestionnaires record);

    int insertSelective(CtQuestionnaires record);

    List<CtQuestionnaires> selectByExample(CtQuestionnairesExample example);

    List<CtQuestionnaires> selectQuestionnaireWithSubject(CtQuestionnaires questionnaires);

    CtQuestionnaires selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CtQuestionnaires record, @Param("example") CtQuestionnairesExample example);

    int updateByExample(@Param("record") CtQuestionnaires record, @Param("example") CtQuestionnairesExample example);

    int updateByPrimaryKeySelective(CtQuestionnaires record);

    int updateByPrimaryKey(CtQuestionnaires record);
}
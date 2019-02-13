package cn.edu.chzu.collegetalent.dao;

import cn.edu.chzu.collegetalent.model.CtCompany;
import cn.edu.chzu.collegetalent.model.CtCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtCompanyMapper {
    int countByExample(CtCompanyExample example);

    int deleteByExample(CtCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CtCompany record);

    int insertSelective(CtCompany record);

    List<CtCompany> selectByExample(CtCompanyExample example);

    CtCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CtCompany record, @Param("example") CtCompanyExample example);

    int updateByExample(@Param("record") CtCompany record, @Param("example") CtCompanyExample example);

    int updateByPrimaryKeySelective(CtCompany record);

    int updateByPrimaryKey(CtCompany record);
}
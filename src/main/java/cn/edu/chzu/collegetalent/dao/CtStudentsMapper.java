package cn.edu.chzu.collegetalent.dao;

import cn.edu.chzu.collegetalent.model.CtStudents;
import cn.edu.chzu.collegetalent.model.CtStudentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtStudentsMapper {
    int countByExample(CtStudentsExample example);

    int deleteByExample(CtStudentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CtStudents record);

    int insertSelective(CtStudents record);

    List<CtStudents> selectByExample(CtStudentsExample example);

    List<CtStudents> search(@Param("keyWord") String keyWord);

    CtStudents selectByPrimaryKey(Integer id);

    CtStudents getByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    int updateByExampleSelective(@Param("record") CtStudents record, @Param("example") CtStudentsExample example);

    int updateByExample(@Param("record") CtStudents record, @Param("example") CtStudentsExample example);

    int updateByPrimaryKeySelective(CtStudents record);

    int updateByPrimaryKey(CtStudents record);

}
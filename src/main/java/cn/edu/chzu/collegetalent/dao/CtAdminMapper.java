package cn.edu.chzu.collegetalent.dao;

import cn.edu.chzu.collegetalent.model.CtAdmin;
import cn.edu.chzu.collegetalent.model.CtAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtAdminMapper {
    int countByExample(CtAdminExample example);

    int deleteByExample(CtAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CtAdmin record);

    int insertSelective(CtAdmin record);

    List<CtAdmin> selectByExample(CtAdminExample example);

    CtAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CtAdmin record, @Param("example") CtAdminExample example);

    int updateByExample(@Param("record") CtAdmin record, @Param("example") CtAdminExample example);

    int updateByPrimaryKeySelective(CtAdmin record);

    int updateByPrimaryKey(CtAdmin record);

    CtAdmin getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

}
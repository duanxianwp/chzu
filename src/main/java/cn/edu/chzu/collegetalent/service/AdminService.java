package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.dao.CtAdminMapper;
import cn.edu.chzu.collegetalent.model.CtAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: chzu
 * @date: Created in 2019/2/13 16:38
 * @description:
 */
@Service
public class AdminService {

    @Autowired
    private CtAdminMapper adminMapper;

    public CtAdmin login(String username, String password){
        return adminMapper.getByUsernameAndPassword(username,password);
    }

    public boolean update(Integer id, String password){
        CtAdmin admin = new CtAdmin();
        admin.setId(id);
        admin.setPassword(password);
        adminMapper.updateByPrimaryKeySelective(admin);
        return true;
    }

}

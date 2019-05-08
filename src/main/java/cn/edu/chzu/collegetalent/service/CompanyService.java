package cn.edu.chzu.collegetalent.service;

import cn.edu.chzu.collegetalent.constant.Constant;
import cn.edu.chzu.collegetalent.dao.CtCompanyMapper;
import cn.edu.chzu.collegetalent.model.CtCompany;
import cn.edu.chzu.collegetalent.model.CtCompanyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CtCompanyMapper companyMapper;

    public CtCompany add(CtCompany ctCompany){
        companyMapper.insertSelective(ctCompany);
        return ctCompany;
    }

    public boolean update(CtCompany company){
        companyMapper.updateByPrimaryKeySelective(company);
        return true;
    }

    public CtCompany get(Integer id){
        return companyMapper.selectByPrimaryKey(id);
    }

    public CtCompany getByEmailAndPassword(String email, String password){
        CtCompanyExample example = new CtCompanyExample();
        example.createCriteria()
                .andEmailEqualTo(email)
                .andPasswordEqualTo(password)
                .andDelFlagEqualTo(Constant.DelFlag.NODEL);
        List<CtCompany> list = companyMapper.selectByExample(example);
        if(list.isEmpty()){
            return new CtCompany();
        }
        return list.get(0);
    }

    public CtCompany getByEmail(String email){
        CtCompanyExample example = new CtCompanyExample();
        example.createCriteria()
                .andDelFlagEqualTo(Constant.DelFlag.NODEL).andEmailEqualTo(email);
        List<CtCompany> list = companyMapper.selectByExample(example);
        if(list.isEmpty()){
            return null;
        } else {
            return list.get(0);
        }
    }

    public List<CtCompany> listAll(){
        CtCompanyExample example = new CtCompanyExample();
        example.createCriteria()
                .andDelFlagEqualTo(Constant.DelFlag.NODEL);
        return companyMapper.selectByExample(example);
    }

    public List<CtCompany> search(String keyWord){
        return companyMapper.search(keyWord);
    }

}

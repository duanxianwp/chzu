package cn.edu.chzu.collegetalent.model;

import java.io.Serializable;
import java.util.Date;

public class CtStudents implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private String sex;

    private String grade;

    private String conduct;

    private String major;

    private Integer employment;

    private String employmentCompany;

    private String employmentCity;

    private String phone;

    private String wechat;

    private String qq;

    private String email;

    private Integer delFlag;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct == null ? null : conduct.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Integer getEmployment() {
        return employment;
    }

    public void setEmployment(Integer employment) {
        this.employment = employment;
    }

    public String getEmploymentCompany() {
        return employmentCompany;
    }

    public void setEmploymentCompany(String employmentCompany) {
        this.employmentCompany = employmentCompany == null ? null : employmentCompany.trim();
    }

    public String getEmploymentCity() {
        return employmentCity;
    }

    public void setEmploymentCity(String employmentCity) {
        this.employmentCity = employmentCity == null ? null : employmentCity.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", sex=").append(sex);
        sb.append(", grade=").append(grade);
        sb.append(", conduct=").append(conduct);
        sb.append(", major=").append(major);
        sb.append(", employment=").append(employment);
        sb.append(", employmentCompany=").append(employmentCompany);
        sb.append(", employmentCity=").append(employmentCity);
        sb.append(", phone=").append(phone);
        sb.append(", wechat=").append(wechat);
        sb.append(", qq=").append(qq);
        sb.append(", email=").append(email);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
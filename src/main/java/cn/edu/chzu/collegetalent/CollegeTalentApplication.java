package cn.edu.chzu.collegetalent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "cn.edu.chzu.collegetalent.dao")
public class CollegeTalentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeTalentApplication.class, args);
    }

}


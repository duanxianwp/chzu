package cn.edu.chzu.collegetalent.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 * @auther: jone
 * @date: Created in 2019/3/1 10:15
 * @description:
 */
@CommonsLog
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void register() {
    }

    @Test
    public void get() {
    }

    @Test
    public void update() {
    }

    @Test
    public void updatePassword() {
    }

    @Test
    public void list() {
    }

    @Test
    public void viewList() {
    }

    @Test
    public void delete() {
    }
}
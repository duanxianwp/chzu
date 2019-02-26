package cn.edu.chzu.collegetalent.controller;

import cn.edu.chzu.collegetalent.helper.EncryptHelper;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.apachecommons.CommonsLog;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

/**
 * @auther: chzu
 * @date: Created in 2019/2/15 15:11
 * @description:
 */
@CommonsLog
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testLogin() throws Exception{
        String uri = "/login.do";
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .param("email","huolifu@eruik.com")
                        .param("password",EncryptHelper.MD5("1234567"))
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(status,200);
        String content = mvcResult.getResponse().getContentAsString();
        JSONObject result = JSONObject.parseObject(content);

        log.info(result);

        Assert.assertTrue("成功", result.getJSONObject("head").getInteger("code").equals(0));
    }

}
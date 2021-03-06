package com.yuan.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class ParaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void firstRequest() {
    }

    @Test
    void requestPara() {
    }

    @Test
    void pathPara() {
    }

    @Test
    void multiUrl() {
    }

    @Test
    void required() {
    }

    @Test
    void testJavaBean() {
    }

    @Test
    void testJson() {
    }

    @Test
    void testPost() throws Exception {
        Integer num; ;

        MockHttpServletResponse response= mockMvc.perform(MockMvcRequestBuilders.post("/lx/testPost")
                .param("a", "2")
                .param("b", "3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        response.setCharacterEncoding("UTF-8");
        num= Integer.parseInt(response.getContentAsString());
        assertThat(num).isEqualTo(5);
    }
}
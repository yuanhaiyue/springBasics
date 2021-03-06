package com.yuan.demo;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.context.WebApplicationContext;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
class StudentControllerTest {
    @Autowired
    StudentController studentController;

    @Autowired
    private MockMvc mockMvc;

/*
    @Autowired
    private WebApplicationContext webApplicationContext;

      @Before
      public void setUp() {
          mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
      }
  */
    @Autowired
    private TestRestTemplate testRestTemplate ;

    @Test
    void student() {
        assertThat(studentController.student(1).toString()).isEqualTo("Student{id=1, name='小明'}");
    }

    @Test
    void studentTwo() throws Exception {
        String str="" ;

        MockHttpServletResponse response= mockMvc.perform(MockMvcRequestBuilders.get("/student?num=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        response.setCharacterEncoding("UTF-8");
        str=response.getContentAsString();
        assertThat(str).isEqualTo("{\"id\":1,\"name\":\"小明\"}");
    }
    @Test
    void studentTree() {
        ResponseEntity<String> entity=testRestTemplate.exchange("/student?num=1", HttpMethod.GET,null,String.class);

        assertThat(entity.getBody()).isEqualTo("{\"id\":1,\"name\":\"小明\"}");
    }
}
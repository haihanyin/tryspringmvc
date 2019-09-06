package p.hh.trymvc.ter.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersonControllerTest.ContextConfig.class)
@WebAppConfiguration
class PersonControllerTest {

    @Configuration
    @ComponentScan(basePackages = "p.hh.trymvc.ter")
    public static class ContextConfig {
    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    void greetingWithClientError() throws Exception {
        mvc.perform(get("/greeting").param("exp", "client"))
                .andDo(print())
                .andExpect(content().string("client error"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void greetingWithServerError() throws Exception {
        mvc.perform(get("/greeting").param("exp", "server"))
                .andDo(print())
                .andExpect(content().string("server error"))
                .andExpect(status().is5xxServerError());
    }
}
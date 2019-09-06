package p.hh.trymvc.thm.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = SimpleUrlHandlerMappingTest.Config.class)
class SimpleUrlHandlerMappingTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void greeting() throws Exception {
        mvc.perform(get("/mygreeting.xyz"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Configuration
    static class Config {
        @Bean
        public HandlerMapping handlerMapping() {
            SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
            simpleUrlHandlerMapping.setUrlMap(Collections.singletonMap("/mygreeting.xyz", carController()));
            return simpleUrlHandlerMapping;
        }

        @Bean
        public CarController carController() {
            return new CarController();
        }
    }
}
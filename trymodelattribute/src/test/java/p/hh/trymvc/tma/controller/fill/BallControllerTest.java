package p.hh.trymvc.tma.controller.pre;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BallControllerTest.Config.class)
@WebAppConfiguration
class BallControllerTest {

    @Configuration
    @ComponentScan(basePackages = "p.hh.trymvc.tma")
    static class Config { }

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /* In this test, ball is instantiated when the handler method is invoked
        all varaibles in the request are automatically filled in the ball model
     */

    @Test
    void getBook() throws Exception {
        mockMvc.perform(get("/ball/10")
                .param("name", "earth")
                .param("color", "red")
        ).andDo(print()).andExpect(status().isOk());
    }
}
package p.hh.trymvc.tlr.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BookControllerTest.ContextConfig.class)
@WebAppConfiguration
class BookControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void simpleGreeting() throws Exception {
        mvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(content().string(containsString("hello")));
    }

    @ParameterizedTest
    @CsvSource({"fr,bonjorno", "nl,dag"})
    void greetings(String lang, String greetingWord) throws Exception {
        mvc.perform(get("/greeting").param("locale", lang))
                .andDo(print())
                .andExpect(content().string(containsString(greetingWord)));
    }

    @Configuration
    @ComponentScan(basePackages = "p.hh.trymvc.tlr")
    public static class ContextConfig {
    }
}
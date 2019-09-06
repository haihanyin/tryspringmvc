package p.hh.trymvc.ttr.controller;

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
@ContextConfiguration(classes = MovieControllerTest.ContextConfig.class)
@WebAppConfiguration
class MovieControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void greeting() throws Exception {
        String theme = "default";
        mvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(content().string(containsString(theme + "/appstyle.css")));
    }

    @ParameterizedTest
    @CsvSource({"blue,blue", "red,red"})
    void themeGreeting(String themeParam, String themeCss) throws Exception {
        mvc.perform(get("/greeting").param("theme", themeParam))
                .andDo(print())
                .andExpect(content().string(containsString(themeCss + "/appstyle.css")));
    }

    @Configuration
    @ComponentScan(basePackages = "p.hh.trymvc.ttr")
    public static class ContextConfig {
    }
}
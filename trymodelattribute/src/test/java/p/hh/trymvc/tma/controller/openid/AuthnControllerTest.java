package p.hh.trymvc.tma.controller.openid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = p.hh.trymvc.tma.controller.openid.AuthnControllerTest.Config.class)
@WebAppConfiguration
class AuthnControllerTest {

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

    @Test
    void authorize() throws Exception {
        mockMvc.perform(get("/authorize")
                .param("scope", "openid")
                .param("scope", "openid1")
                .param("response_type", "code")
                .param("color", "red")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void authorizePost() throws Exception {
        mockMvc.perform(post("/authorize")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"scope\":\"openid\"}")
        ).andDo(print()).andExpect(status().isOk());
    }
}

package p.hh.trymvc.thm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import p.hh.trymvc.thm.controller.CarController;

@Configuration
@EnableWebMvc
public class ThmAppServletConfig {

}

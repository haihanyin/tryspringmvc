package p.hh.trymvc.twf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "p.hh.trymvc.twf.controller")
public class TwfAppServletConfig {

}

package p.hh.trymvc.tca.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "p.hh.trymvc.tca.controller")
public class TcaAppServletConfig {

}

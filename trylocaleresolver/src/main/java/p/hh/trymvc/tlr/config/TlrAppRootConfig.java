package p.hh.trymvc.tlr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "p.hh.trymvc.tlr.service")
public class TlrAppRootConfig {
}

package p.hh.trymvc.tca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

@Configuration
public class TcaAppRootConfig {

    @Bean
    public HandlerMapping handlerMapping() {
        BeanNameUrlHandlerMapping beanNameUrlHandlerMapping = new BeanNameUrlHandlerMapping();
        return beanNameUrlHandlerMapping;
    }
}

package p.hh.trymvc.twf.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class TwfAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{TwfAppRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{TwfAppServletConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

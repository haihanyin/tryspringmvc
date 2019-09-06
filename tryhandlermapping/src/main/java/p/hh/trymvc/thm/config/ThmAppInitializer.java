package p.hh.trymvc.thm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ThmAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ThmAppRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ThmAppServletConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

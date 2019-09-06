package p.hh.trymvc.ter.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class TerAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{TerAppRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{TerAppServletConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

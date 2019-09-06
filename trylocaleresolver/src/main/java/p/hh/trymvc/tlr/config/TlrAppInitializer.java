package p.hh.trymvc.tlr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class TlrAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{TlrAppRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{TlrAppServletConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

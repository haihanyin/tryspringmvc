package p.hh.trymvc.tca.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class TcaAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{TcaAppRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{TcaAppServletConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

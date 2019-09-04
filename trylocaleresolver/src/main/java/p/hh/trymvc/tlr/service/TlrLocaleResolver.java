package p.hh.trymvc.tlr.service;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.AbstractLocaleContextResolver;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component("localeResolver")
public class TlrLocaleResolver extends AbstractLocaleResolver {

    public TlrLocaleResolver() {
        this.setDefaultLocale(new Locale(""));
    }

    public Locale resolveLocale(HttpServletRequest request) {
        String locale = request.getParameter("locale");
        if ("fr".equals(locale)) {
            return new Locale("fr");
        } else if ("nl".equals(locale)) {
            return new Locale("nl");
        } else {
            return new Locale("");
        }
    }

    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // do nothing
    }
}

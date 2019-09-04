package p.hh.trymvc.ttr.service;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.theme.AbstractThemeResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("themeResolver")
public class TtrThemeResolver extends AbstractThemeResolver {

    public String resolveThemeName(HttpServletRequest request) {
        String theme = request.getParameter("theme");
        if ("blue".equals(theme)) {
            return "blue";
        } else if ("red".equals(theme)) {
            return "red";
        } else {
            return "default";
        }
    }

    public void setThemeName(HttpServletRequest request, HttpServletResponse response, String themeName) {

    }
}

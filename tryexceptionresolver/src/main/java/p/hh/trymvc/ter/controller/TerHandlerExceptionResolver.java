package p.hh.trymvc.ter.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TerHandlerExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof TerException) {
            TerException terException = (TerException) ex;
            String type = terException.getType();
            try {
                response.getWriter().write(type + " error");
                if ("client".equals(type)) {
                    response.setStatus(400);
                } else if ("server".equals(type)) {
                    response.setStatus(500);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

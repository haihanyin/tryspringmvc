package p.hh.trymvc.tma.controller.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@RestController
@SessionAttributes("location")
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam String location, HttpSession session) {
        session.setAttribute("location", new Location(location));
        return "greeting at " + location;
    }

    @GetMapping("/shakeHands")
    public String shakeHands(@SessionAttribute Location location) {
        return "shakeHands at " + location.getName();
    }

    // Location is mapped by @SessionAttributes
    @GetMapping("/chitchat")
    public String chitchat(@ModelAttribute Location location) {
        return "chitchat at " + location.getName();
    }

    // Location is mapped by @SessionAttributes
    @GetMapping("/saygoodbye")
    public String saygoodbye(Location location, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "say goodbye at " + location.getName();
    }
}

package p.hh.trymvc.tar.controller.callable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Callable<String> greeting() {
        Callable<String> result = () -> {
            Thread.sleep(3000);
            return "hello from mars";
        };
        return result;
    }
}

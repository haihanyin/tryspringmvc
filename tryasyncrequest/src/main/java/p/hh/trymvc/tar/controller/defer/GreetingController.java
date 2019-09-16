package p.hh.trymvc.tar.controller.defer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public DeferredResult<String> greeting() {
        final DeferredResult<String> deferredResult = new DeferredResult<String>();
        ForkJoinPool.commonPool().submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            deferredResult.setResult("greeting from mars");
        });
        return deferredResult;
    }
}

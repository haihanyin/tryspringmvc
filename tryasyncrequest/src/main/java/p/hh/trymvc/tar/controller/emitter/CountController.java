package p.hh.trymvc.tar.controller.emitter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

@RestController
public class CountController {

    @GetMapping("/count")
    public ResponseBodyEmitter handle() {
        ResponseBodyEmitter responseBodyEmitter = new ResponseBodyEmitter();
        ForkJoinPool.commonPool().submit(() -> {
            for(int i = 0; i<5; i++) {
                try {
                    Thread.sleep(1000);
                    responseBodyEmitter.send(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            responseBodyEmitter.complete();
        });
        return responseBodyEmitter;
    }
}

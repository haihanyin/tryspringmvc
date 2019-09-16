package p.hh.trymvc.twf.controller;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

@RestController
public class CityController {

    private static List<City> cities = Arrays.asList(
            new City("Beijing"),
            new City("New York"),
            new City("San Paulo"),
            new City("Sydney"),
            new City("Amsterdam"),
            new City("Kairo")
    );

    @GetMapping("/city/{id}")
    public Mono<City> getCityById(@PathVariable int id) {
        return Mono.fromCallable(new Callable<City>() {
            @Override
            public City call() throws Exception {
                Thread.sleep(3000);
                return cities.get(id);
            }
        });
    }

    @GetMapping("/cities")
    public Flux<Long> getCities() {
        return Flux.interval(Duration.ofMillis(100));
    }
}

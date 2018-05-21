package ru.cmlt.security.webfluxsimple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

/**
 * Created by Anatoly Samoylenko on 08.05.18.
 */

@RestController
public class MainController {

    @GetMapping("/")
    public Mono<String> welcome(Mono<Principal> principalM) {
        return principalM
                .map(Principal::getName)
                .defaultIfEmpty("anon")
                .map(name -> String.format("webflux-simple -> Welcome, %s!", name));
    }

    @GetMapping("/profile")
    public Mono<String> profile(Mono<Principal> principalM) {
        return principalM
                .map(Principal::getName)
                .map(name -> String.format("webflux-simple -> Profile: %s", name));
    }

    @GetMapping("/admin")
    public Mono<String> greetAdmin(Mono<Principal> principalM) {
        return principalM
                .map(Principal::getName)
                .map(name -> String.format("webflux-simple -> Admin access: %s", name));
    }

}

package com.foo.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author: he
 * @date: 2019/5/21
 */
@Component
public class GreetingHandler {


    public Mono<ServerResponse> hello(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("hello YOU"));
    }
}

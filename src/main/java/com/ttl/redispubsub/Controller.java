package com.ttl.redispubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired MessagePublisher publisher;

    @PostMapping(value = "/redis")
    public String getTestData(@RequestBody Infos infos) {
        publisher.publish(infos);
        return "OK";
    }
}

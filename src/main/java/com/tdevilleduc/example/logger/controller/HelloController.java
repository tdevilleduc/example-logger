package com.tdevilleduc.example.logger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String hello() {
        if (logger.isInfoEnabled()) {
            logger.info("/hello");
        }
        return "Hello, World";
    }

    @GetMapping("/{toto}")
    public String hello(@PathVariable("toto") String name) {
        if (logger.isDebugEnabled()) {
            logger.debug("/hello {}", name);
        }
        return "Hello, " + name;
    }
}

package com.tdevilleduc.example.logger.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void helloShouldReturnHelloWorldMessage() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello",
                String.class)).contains("Hello, World");
    }

    @Test
    public void helloWithNameShouldReturnHelloWithNameMessage() {
        String randomName = UUID.randomUUID().toString();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello/" + randomName,
                String.class)).contains("Hello, " + randomName);
    }
}

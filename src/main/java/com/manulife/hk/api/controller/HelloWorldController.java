package com.manulife.hk.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("start")
public class HelloWorldController {

    @GetMapping(value = "/v1/hello", produces = {"application/json"})
    public String helloWorld() {
        return "Hello world";
    }
}

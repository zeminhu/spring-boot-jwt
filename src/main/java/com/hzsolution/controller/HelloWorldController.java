package com.hzsolution.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping({ "/hello" })
    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String firstPage() {
        return "Hello World";
    }
}

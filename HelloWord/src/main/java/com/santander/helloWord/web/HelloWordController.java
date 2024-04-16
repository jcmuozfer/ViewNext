package com.santander.helloWord.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.santander.helloWord.model.HelloWord;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/index/")
public class HelloWordController {

    @Value("${variable.global.first}")
    private String hi;

    @GetMapping("/hi")
    public String handler() {
        HelloWord hi2 = new HelloWord("Hello Word", LocalDateTime.now().toString());

        return hi2.getMessage();
    }

    @GetMapping()
    public String index() {
        return hi;
    }

}

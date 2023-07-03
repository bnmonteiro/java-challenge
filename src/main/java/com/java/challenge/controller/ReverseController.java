package com.java.challenge.controller;

import com.java.challenge.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverseController {

    @Autowired
    private ReverseService service;

    @PostMapping("/reverse")
    public String reverseWords(@RequestBody String sentence) {

        return service.reverseWordsInSentence(sentence);

    }

}

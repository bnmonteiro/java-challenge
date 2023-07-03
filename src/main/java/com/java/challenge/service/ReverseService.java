package com.java.challenge.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseService {

    public String reverseWordsInSentence(String sentence){
        String[] words = sentence.split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        return reversed.toString().trim();
    }

}

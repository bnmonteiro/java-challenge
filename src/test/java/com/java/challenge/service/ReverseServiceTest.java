package com.java.challenge.service;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ReverseServiceTest {

    @Test
    public void reverseWordsInSentenceTest(){

        ReverseService myService = new ReverseService();

        String result = myService.reverseWordsInSentence("sentence to reverse words");

        assertEquals("words reverse to sentence", result);

    }
}

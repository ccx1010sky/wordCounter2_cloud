package com.ccx2.wordCounter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class WordCounter {

    private final Map<String, Integer> wordCounts = new HashMap<>();

//    @Autowired
    private final RealTranslator translator;

    //Constructor
    @Autowired
    public WordCounter(RealTranslator translator) {
        this.translator = translator;
    }


    // Synchronized method to handle concurrent access
    public synchronized void addWords(String... words) {
        for (String word : words) {
            if (word != null && word.matches("^[a-zA-Z]+$")) {
                String translatedWord = translator.translate(word);
                wordCounts.put(translatedWord, wordCounts.getOrDefault(translatedWord, 0) + 1);
            }
        }
    }

    // Synchronized method to handle concurrent access
    public synchronized int getCount(String word) {
        if (word == null || !word.matches("^[a-zA-Z]+$")) {
            return 0;
        }
        String translatedWord = translator.translate(word);
        return wordCounts.getOrDefault(translatedWord, 0);
    }

    // Method to print the entire map for debugging
    public synchronized String printWordCounts() {
        return wordCounts.toString();
    }


}
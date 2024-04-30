package com.ccx2.wordCounter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordCounterController {
    private final WordCounter wordCounter;

    @Autowired
    public WordCounterController( WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<Void> addWords(@RequestBody List<String> words) {
        wordCounter.addWords(words.toArray(new String[0]));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getCount(@RequestParam String word) {
        return ResponseEntity.ok(wordCounter.getCount(word));
    }
}

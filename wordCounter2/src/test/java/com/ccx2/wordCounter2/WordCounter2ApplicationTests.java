package com.ccx2.wordCounter2;


//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class WordCounter2ApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;

public class WordCounter2ApplicationTests {

    @Mock
    private RealTranslator mockTranslator;

    private WordCounter wordCounter;

    @Before
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
        mockTranslator = new RealTranslator();
        wordCounter = new WordCounter(mockTranslator);
    }


//    @Test
//    public void testAddWords(){
//        wordCounter.addWords(("flower"));
//    }

    @Test
    public void testAddWordSingleCount() {
        wordCounter.addWords("blume");
        wordCounter.addWords("flor");
        assertEquals(2, wordCounter.getCount("flower"));
    }

    @Test
    public void testAddWordMultipleCounts() {
        wordCounter.addWords("flor");
        wordCounter.addWords("blume");
        wordCounter.addWords("blume");
        wordCounter.addWords("blume","flor","blume");
        wordCounter.addWords("blue");
        assertEquals(6, wordCounter.getCount("flower"));
    }

    @Test
    public void testGetCountForNonExistingWord() {
        assertEquals(0, wordCounter.getCount("nonexisting"));
    }


    @Test
    public void testWordCountingWithNonAlphabetic() {
        wordCounter.addWords("flower1", "flor", "blume","flower","Flower");
        int count = wordCounter.getCount("flower");
        // "flower1" should not be counted as it contains non-alphabetic characters
        assertEquals(4, count);
    }


    @Test
    public void testPrintWordCounts() {
        wordCounter.addWords("flower", "flor", "blume","Flower","blue");
        System.out.println(wordCounter.printWordCounts());

    }


}
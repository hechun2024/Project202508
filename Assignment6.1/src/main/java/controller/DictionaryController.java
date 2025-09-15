package controller;

import model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();

        // Hardcoded dictionary entries for testing
        dictionary.addWord("java", "A popular programming language.");
        dictionary.addWord("python", "An interpreted, high-level programming language.");
        dictionary.addWord("dictionary", "A collection of words and their meanings.");
    }

    // Search for a word, return result or error message
    public String searchWord(String word) {
        try {
            return dictionary.getMeaning(word);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

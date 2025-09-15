package model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words;

    public Dictionary() {
        words = new HashMap<>();
    }

    // Add a word and its meaning
    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning);
    }

    // Search for a word and return its meaning
    public String getMeaning(String word) throws Exception {
        if (word == null || word.trim().isEmpty()) {
            throw new Exception("Word cannot be empty!");
        }
        String meaning = words.get(word.toLowerCase());
        if (meaning == null) {
            throw new Exception("Word not found in dictionary!");
        }
        return meaning;
    }
}

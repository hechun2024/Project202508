package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of notes.
 */
public class Notebook {
    private final List<Note> notes;

    public Notebook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void removeNote(Note note) {
        notes.remove(note);
    }

    public List<Note> getNotes() {
        return notes;
    }
}

package model;

/**
 * Represents a single note with a title and content.
 */
public class Note {
    private String title;
    private String content;

    // Constructor
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter and Setter for Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for Content
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    // Represent a note as a string (for display in ListView or text area)
    @Override
    public String toString() {
        return title + ": " + content;
    }
}

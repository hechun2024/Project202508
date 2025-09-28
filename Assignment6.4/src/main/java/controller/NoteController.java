package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Note;
import model.Notebook;

/**
 * Controller class for managing user interactions with the notebook app.
 */
public class NoteController {

    @FXML private TextField titleField;     // Input field for note title
    @FXML private TextArea contentArea;     // Input area for note content
    @FXML private Button addButton;         // Button to add or update note
    @FXML private Button deleteButton;      // Button to delete note
    @FXML private ListView<Note> noteListView; // ListView to display notes

    private Notebook notebook;
    private Note selectedNote; // Keep track of currently selected note

    @FXML
    public void initialize() {
        notebook = new Notebook();

        // Handle selection in the ListView
        noteListView.getSelectionModel().selectedItemProperty().addListener((obs, oldNote, newNote) -> {
            if (newNote != null) {
                selectedNote = newNote;
                titleField.setText(newNote.getTitle());
                contentArea.setText(newNote.getContent());
                addButton.setText("Update"); // Change button text
            }
        });
    }

    // Add or update a note
    @FXML
    private void addNote() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();

        if (title.isEmpty() || content.isEmpty()) {
            showAlert("Error", "Both title and content are required.");
            return;
        }

        if (selectedNote == null) {
            // Create new note
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
            noteListView.getItems().add(newNote);
        } else {
            // Update existing note
            selectedNote.setTitle(title);
            selectedNote.setContent(content);
            noteListView.refresh(); // Refresh ListView to show changes
        }

        clearForm();
    }

    // Delete a selected note
    @FXML
    private void deleteNote() {
        if (selectedNote != null) {
            notebook.removeNote(selectedNote);
            noteListView.getItems().remove(selectedNote);
            clearForm();
        } else {
            showAlert("Warning", "No note selected to delete.");
        }
    }

    // Reset input fields
    private void clearForm() {
        titleField.clear();
        contentArea.clear();
        noteListView.getSelectionModel().clearSelection();
        selectedNote = null;
        addButton.setText("Add"); // Reset button text
    }

    // Show alert messages
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

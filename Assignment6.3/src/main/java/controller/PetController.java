// 6.3. Create a Virtual Pet that follows the mouse cursor around the window.
package controller;

import javafx.application.Platform;
import model.Pet;
import view.PetView;

/**
 * PetController — Controller
 * Handles mouse events, updates the Pet model, and tells the View to redraw.
 * Runs movement in a background thread and updates GUI via Platform.runLater.
 */
public class PetController {
    private Pet pet;
    private PetView gui;

    private Double targetX = null;
    private Double targetY = null;
    private double petSize = 80;

    private boolean running = true; // control loop

    public PetController(PetView gui) {
        this.pet = new Pet(100, 100, petSize);
        this.gui = gui;
        startLoop(); // start background loop when controller is created
    }

    public void setTarget(double x, double y) {
        this.targetX = x;
        this.targetY = y;
    }

    public void clearTarget() {
        this.targetX = null;
        this.targetY = null;
    }

    /**
     * Background loop:
     * - Updates pet's position in a worker thread
     * - Calls Platform.runLater to update GUI safely
     */
    private void startLoop() {
        new Thread(() -> {
            while (running) {
                if (targetX != null && targetY != null) {
                    pet.moveTowards(targetX, targetY, gui.getCanvasWidth(), gui.getCanvasHeight());
                }

                // Always update GUI on the JavaFX Application Thread
                Platform.runLater(() -> {
                    gui.updateCanvas(pet.getX(), pet.getY(), petSize);
                });

                try {
                    Thread.sleep(16); // about 60 updates per second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stopLoop() {
        running = false;
    }
}

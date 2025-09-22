//6.3. Create a Virtual Pet that follows the mouse cursor around the window.
package model;


//Stores the pet's position, size, and movement logic.

public class Pet {
    private double x;       // current X position
    private double y;       // current Y position
    private double speed = 4.0;  // movement speed (pixels per frame)
    private double petSize; // size of the pet image

    public Pet(double x, double y, double petSize) {
        this.x = x;
        this.y = y;
        this.petSize = petSize;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    /**
     * Move the pet towards the target point by "speed" pixels.
     * Ensure the pet stays inside the canvas boundaries.
     */
    public void moveTowards(double targetX, double targetY, double canvasWidth, double canvasHeight) {
        double dx = targetX - x;
        double dy = targetY - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > speed) {
            x += (dx / distance) * speed;
            y += (dy / distance) * speed;
        } else {
            x = targetX;
            y = targetY;
        }

        //  Boundary check (keep pet fully visible)
        double halfSize = petSize / 2;
        if (x < halfSize) x = halfSize;
        if (y < halfSize) y = halfSize;
        if (x > canvasWidth - halfSize) x = canvasWidth - halfSize;
        if (y > canvasHeight - halfSize) y = canvasHeight - halfSize;
    }
}


import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class BouncingTextApplet extends Applet implements Runnable {

    private Thread animationThread = null; // The thread used for the animation loop
    private int xCoord = 0;              // Current x-coordinate of the text
    private final int yCoord = 50;           // Fixed y-coordinate for the text
    private final int speed = 5;             // Movement speed (pixels per frame)
    private String textToDisplay = "Your Name Goes Here";
    private final int animationDelay = 100; // Delay in milliseconds for Thread.sleep()

    /**
     * Called by the system to initialize the applet.
     */
    @Override
    public void init() {
        // Set the applet's size (can be overridden by HTML applet tag)
        setSize(400, 100);
        
        // Set a nostalgic background color
        setBackground(new Color(204, 255, 204)); // Pastel Green
        
        // Initialize the text string
        textToDisplay = "MUJE"; 
        
        // Set initial font style
        setFont(new Font("Monospaced", Font.BOLD, 24));
    }

    /**
     * Called when the applet is started (or re-started). Creates and starts the thread.
     */
    @Override
    public void start() {
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    /**
     * The main animation loop run by the thread.
     */
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        
        // Loop forever for continuous animation
        while (currentThread == animationThread) {
            
            // 1. Update the x-coordinate
            xCoord += speed;

            // 2. Check if the text hits the right edge (getTextWidth() - a rough estimate)
            // If the text's starting point is past the applet's width, reset it
            if (xCoord > getWidth()) {
                xCoord = -100; // Reset off-screen to the left (text length adjustment for smooth transition)
            }

            // 3. Request the applet to redraw the screen
            repaint();

            // 4. Pause the animation
            try {
                Thread.sleep(animationDelay);
            } catch (InterruptedException e) {
                // If the thread is interrupted, exit the loop
                break; 
            }
        }
    }

    /**
     * Called when the applet is stopped. Sets the thread to null to stop the loop.
     */
    @Override
    public void stop() {
        animationThread = null;
    }

    /**
     * Called to draw the applet's content.
     * @param g The Graphics context used for drawing.
     */
    @Override
    public void paint(Graphics g) {
        // Set the color for the text
        g.setColor(Color.BLUE.darker()); 
        
        // Draw the text at the current coordinates
        g.drawString(textToDisplay, xCoord, yCoord);
    }
}

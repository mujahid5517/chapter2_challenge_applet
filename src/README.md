##📜 Classic Java Applet: Scrolling Text Animator

This project implements a classic Java Applet using the Abstract Window Toolkit 
(AWT) to display horizontally scrolling text with continuous animation. 
It simulates the nostalgic "marquee" effect commonly seen in early web 
applications.

The text currently hardcoded to "MUJE" scrolls across the screen and resets its 
position once it moves fully off-screen, creating a perpetual looping effect.

###💻 Technology & Core Concepts

This application utilizes Java Applet technology, a legacy system designed for
 embedding small, interactive applications in web pages.

** Technology Stack: Java (AWT), Applet API

** Animation Model: Multithreading is the core of the animation. 
The applet implements the Runnable interface, allowing the animation
 logic to run on a separate thread (animationThread) to ensure smooth and 
consistent text movement independent of the main UI thread.

**Visual Style: The applet uses a Pastel Green background (#CCFFCC) and bold,
 dark blue monospaced text, giving it a nostalgic, retro aesthetic reminiscent
 of early computing.

###🎯 Key Functionality and Implementation

The applet's behavior is managed by overriding its core lifecycle methods.

###1. Initialization (init())

This method sets up the initial state:

Sets the default applet size (400x100 pixels).

Defines the background color to a specific Pastel Green (new Color(204, 255, 204)).

Sets the display text to "MUJE" and configures the font (Monospaced, Bold, 24pt).
###2. Animation Thread (start() & run())

The run() method contains the main animation loop:

| Variable | Description | Value | 
| :--- | :--- | :--- | 
| `speed` | The number of pixels the text moves per frame. | **5** | 
| `animationDelay` | The pause (in milliseconds) between position updates. | **100 ms** | 
| `xCoord` | The current horizontal drawing position of the text. | Varies |


-The core movement logic in run():

Update Position: The xCoord is incremented by speed in every cycle.

Boundary Check: If xCoord exceeds the applet's width (getWidth()), it is reset to -100. This offset ensures the entire length of the text smoothly disappears before reappearing from the left edge.

Redraw: repaint() is called, which triggers the paint() method to draw the text at its new coordinate.

Timing: Thread.sleep(animationDelay) introduces a brief pause to control the frame rate.

3. Rendering (paint(Graphics g))

This method is triggered by the repaint() call to draw the current frame:

It sets the drawing color to dark blue.

It draws the text using g.drawString(textToDisplay, xCoord, yCoord) at the 
calculated horizontal position.

4. Lifecycle Control (stop())

The stop() method safely terminates the animation by setting the animationThread
 reference to null, which causes the while loop in the run() method to exit gracefully.

⚙️ How to Run the Applet

Note: Java Applets are a deprecated technology. This code is best run using the
 appletviewer tool included with the Java Development Kit (JDK) environment.

Compile the Java File:

javac BouncingTextApplet.java


Create an HTML Host File (index.html):
You must create an HTML file in the same directory to instruct the appletviewer 
on how to load the application.

<applet code="BouncingTextApplet.class" width="400" height="100">
</applet>


Execute with Applet Viewer:

appletviewer index.html


This command will open a dedicated, animated window displaying the scrolling text.
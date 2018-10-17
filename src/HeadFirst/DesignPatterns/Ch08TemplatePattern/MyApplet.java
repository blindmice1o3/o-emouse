package HeadFirst.DesignPatterns.Ch08TemplatePattern;

import java.applet.Applet;
import java.awt.*;

// Concrete applets make extensive use of hooks to supply their own behaviors. Because these methods are implemented as
// hooks, the applet isn't required to implement them.
public class MyApplet extends Applet {
    String message;

    // The init hook allows the applet to do whatever it wants to initialize the applet for the first time.
    public void init() {
        message = "Hello World, I'm alive!";
        // repaint() is a concrete method in the Applet class that lets upper-level components know the applet needs to
        // be redrawn.
        repaint();
    }

    // The start hook allows the applet to do something when the applet is just about to be displayed on the web page.
    public void start() {
        message = "Now I'm starting up...";
        repaint();
    }

    // If the use goes to another page, the stop hook is used, and the applet can do whatever it needs to do to stop its actions.
    public void stop() {
        message = "Oh, now I'm being stopped...";
        repaint();
    }

    // And the destroy hook is used when the applet is going to be destroyed, say, when the browser pane is closed. We
    // could try to display something here, but what would be the point?
    public void destroy() {
        // applet is going away...
    }

    // Our old friend the paint() method! Applet also makes use of this method as a hook (like JFrame from Swing API).
    public void paint(Graphics g) {
        g.drawString(message, 5,15);
    }
}

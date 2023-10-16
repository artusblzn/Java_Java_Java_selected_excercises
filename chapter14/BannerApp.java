/**
 * 14.16 Challenge: Create a streaming banner thread that moves a simple message across a panel. The
 * message should repeatedly enter at the left edge of the panel and exit from the right edge.
 * Design the banner as a subclass of JPanel and have it implement the Runnable interface. That way
 * it can be added to any user interface. One of its constructors should take a String argument that
 * lets the user set the banner’s message.
 * 
 * Note: I implemented from the right side to the left side.
 */

package chapter14;

import java.awt.*;
import javax.swing.JFrame;

public class BannerApp extends JFrame {

    private StreamBanner banner;

    public BannerApp(String text) {
        getContentPane().setLayout(new BorderLayout());
        this.banner = new StreamBanner(text, 10);
        getContentPane().add("Center", banner);
    }

    public void startBanner() {
        new Thread(this.banner).start();;
    }

    public static void main(String[] args) {
        BannerApp app = new BannerApp("1234567890");
        app.setSize(500, 70);
        app.setVisible(true);
        app.startBanner();
    }

}

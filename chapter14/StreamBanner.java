package chapter14;

import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StreamBanner extends JPanel implements Runnable {
    private String text;
    private JLabel display;
    private int size;
    private char[] banner;

    public StreamBanner(String text, int size) {
        this.text = text;
        this.size = size;
        this.display = new JLabel();
        this.banner = new char[this.size + this.text.length()];
        Arrays.fill(this.banner, ' ');
        for (int i = 0; i < this.text.length(); i++) {
            this.banner[this.size + i] = this.text.charAt(i);
        }
        this.add(display);
    }

    public void run() {
        draw();
    }

    public void draw() {
        this.display.setText(new String(this.banner).substring(0, this.size));
        try {
            while (true) {
                Thread.sleep(1000);
                for (int i = 0; i < this.banner.length; i++) {
                    this.banner[i] = this.banner[(i + 1) % this.banner.length];
                }
                this.display.setText(new String(this.banner).substring(0, this.size));
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}

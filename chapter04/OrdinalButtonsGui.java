/**
 * EXERCISE 4.19 Modify the GUI in the previous exercise so that it contains three JButtons,
 * initially labeled “First,” “Second,” and “Third.” Each time the user clicks one of the buttons,
 * the labels on the buttons should be rotated. Second should get first’s label, third should get
 * second’s, and first should get third’s label.
 */

package chapter04;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.util.Arrays;

public class OrdinalButtonsGui extends JFrame implements ActionListener {
    private JButton[] buttons = new JButton[4];
    private static String[] ORDINAL_NUMBERS = {"First", "Second", "Third", "Fourth"};

    public OrdinalButtonsGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < OrdinalButtonsGui.ORDINAL_NUMBERS.length; i++) {
            this.buttons[i] = new JButton(OrdinalButtonsGui.ORDINAL_NUMBERS[i]);
        }
        this.buildGui();
        this.pack();
        this.setVisible(true);
    }

    public void buildGui() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        for (JButton button : this.buttons) {
            button.addActionListener(this);
            contentPanel.add(button);
        }
        contentPane.add("Center", contentPanel);
    }


    public void actionPerformed(ActionEvent event) {
        if (Arrays.asList(this.buttons).contains(event.getSource())) {
            String[] buttonTexts = new String[this.buttons.length];
            // Get all the button texts in order.
            for (int i = 0; i < this.buttons.length; i++) {
                buttonTexts[i] = this.buttons[i].getText();
            }
            // Change the texts for each button. Note that I'm using the modulus operator
            for (int i = 0; i < this.buttons.length; i++) {
                this.buttons[i].setText(buttonTexts[(i + 1) % this.buttons.length]);
            }

        }
    }

    public static void main(String[] args) {
        new OrdinalButtonsGui();
    }

}

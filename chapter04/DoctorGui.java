/**
 * EXERCISE 4.17 The JButton class inherits a setText(String s) from its AbstractButton()
 * superclass. Using that method, design and implement a GUI that has a single button labeled
 * initially, “The Doctor is out.” Each time the button is clicked, it should toggle its label to,
 * “The Doctor is in” and vice versa.
 */

package chapter04;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;


public class DoctorGui extends JFrame implements ActionListener {
    private JButton doctorButton;

    public DoctorGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.doctorButton = new JButton("The Doctor is out.");
        this.buildGui();
        this.pack();
        this.setVisible(true);
    }

    public void buildGui() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.doctorButton.addActionListener(this);
        contentPane.add("Center", this.doctorButton);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.doctorButton) {
            if (this.doctorButton.getText() == "The Doctor is out.") {
                this.doctorButton.setText("The Doctor is in");
            } else {
                this.doctorButton.setText("The Doctor is out.");
            }
        }
    }

    public static void main(String[] args) {
        new DoctorGui();
    }
}



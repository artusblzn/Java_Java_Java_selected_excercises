/**
 * EXERCISE 8.7 Design and write a subclass of JTextField called IntegerField that is used for
 * inputting integers but behaves in all other respects like a JTextField. Give the subclass a
 * public method called getInteger().
 */

package chapter08;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class IntegerField extends JTextField {

    public IntegerField() {
        super();
    }

    public IntegerField(int columns) {
        super(columns);
    }

    public IntegerField(String text) {
        // If the text is a number, pass the text to constructor
        // Else, pass an empty string
        super(IntegerField.isNumeric(text) ? text : "");
    }

    public IntegerField(String text, int columns) {
        super(IntegerField.isNumeric(text) ? text : "", columns);
    }

    public IntegerField(Document doc, String text, int columns) {
        super(doc, IntegerField.isNumeric(text) ? text : "", columns);
    }

    private static boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setText(String text) {
        if (IntegerField.isNumeric(text)) {
            super.setText(text);
        }
    }

    public int getInteger() {
        try {
            return Integer.parseInt(this.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

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
        // Zero is the default value
        super("0");
    }

    public IntegerField(int columns) {
        super("0", columns);
    }

    public IntegerField(String text) {
        // If the text is a number, pass the text to constructor
        // Else, pass zero
        super(IntegerField.isNumeric(text) ? text : "0");
    }

    public IntegerField(String text, int columns) {
        super(IntegerField.isNumeric(text) ? text : "0", columns);
    }

    public IntegerField(Document doc, String text, int columns) {
        super(doc, IntegerField.isNumeric(text) ? text : "0", columns);
    }

    private static boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setText(String text) throws IllegalArgumentException {
        if (IntegerField.isNumeric(text)) {
            super.setText(text);
        } else {
            throw new IllegalArgumentException("The text is not a number");
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

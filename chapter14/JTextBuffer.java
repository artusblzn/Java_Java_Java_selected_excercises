/**
 * 14.15 Challenge: One type of producer/consumer problem is the reader/writer problem. 
 * Create a subclass of JTextField that can be shared by threads, one of which writes a random number 
 * to the text field, and the other of which reads the value in the text field. Coordinate the two 
 * threads so that the overall effect of the program will be to print the values from 0 to 100 in the 
 * proper order. In other words, the reader thread shouldn’t read a value from the text field until 
 * there’s a value to be read. The writer thread shouldn’t write a value to the text field until the 
 * reader has read the previous value.
 */

package chapter14;

import javax.swing.JTextField;

public class JTextBuffer extends JTextField {

    public synchronized void write(String number) throws NumberFormatException {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw (new NumberFormatException("The argument is not a number."));
        }
        if (!this.getText().isEmpty()) {
            return;
        }
        this.setText(number);
        notify();
    }

    public synchronized String read() {
        String text = "";
        try {
            while (this.getText().isEmpty()) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            text = this.getText();
            this.setText("");
            return text;
        }
    }

    public static void main(String[] args) {
        JTextBuffer buffer = new JTextBuffer();
        WriterThread writer = new WriterThread(buffer);
        ReaderThread reader = new ReaderThread(buffer);

        writer.start();
        reader.start();
    }

}

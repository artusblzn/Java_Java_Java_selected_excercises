package chapter08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import chapter08.IntegerField;

public class IntegerFieldTests {
    // I'll just test the constructor with the String parameter
    // I'll suppose that the other two with a String parameter will work just fine
    @Test
    public void testConstructorWithString() {
        IntegerField intField = new IntegerField("10");
        assertEquals(intField.getText(), "10");

        intField = new IntegerField("abc");
        assertEquals(intField.getText(), "");
    }

    @Test
    public void testSetText() {
        IntegerField intField = new IntegerField();
        intField.setText("10");
        assertEquals(intField.getText(), "10");

        intField.setText("abc");
        assertEquals(intField.getText(), "10");
    }

    @Test
    public void testGetInteger() {
        IntegerField intField = new IntegerField("10");
        assertEquals(intField.getInteger(), 10);

        IntegerField intField2 = new IntegerField();
        assertEquals(intField2.getInteger(), 0);
    }
}

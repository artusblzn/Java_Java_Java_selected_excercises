package chapter01.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import chapter01.Rectangle;

public class RectangleTests {
    private final Rectangle rect = new Rectangle(10, 10);

    @Test
    public void testCalculateArea() {
        assertEquals(rect.calculateArea(), 100);
    }

    @Test
    public void testCalculatePerimeter() {
        assertEquals(rect.calculatePerimeter(), 40);
    }

}

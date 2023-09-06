package chapter07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import chapter07.StringList;

public class StringListTests {
    private StringList strList = new StringList();

    @BeforeEach
    public void setUp() {
        this.strList.addItem("a");
        this.strList.addItem("b");
        this.strList.addItem(12);
    }

    @Test
    public void testGetItem() {
        assertEquals(this.strList.getItem(0), "a");
        assertEquals(this.strList.getItem(1), "b");
        assertEquals(this.strList.getItem(2), Integer.valueOf(12).toString());
    }

    @Test
    public void testToString() {
        assertEquals(this.strList.toString(), "[0] a,[1] b,[2] 12,");
    }

    @Test
    public void testDeleteItemFromPosition() {
        this.strList.deleteItem(0);
        assertEquals(this.strList.toString(), "[0] b,[1] 12,");
    }

    @Test
    public void testDeleteItem() {
        this.strList.deleteItem("12");
        assertEquals(this.strList.toString(), "[0] a,[1] b,");
    }

    @Test
    public void testGetPosition() {
        assertEquals(this.strList.getPosition("a"), 0);
        assertEquals(this.strList.getPosition("b"), 1);
        assertEquals(this.strList.getPosition("12"), 2);
    }

    @Test
    public void testGetHead() {
        assertEquals(this.strList.getHead(), "a");
    }

    @Test
    public void testGetTail() {
        StringList tail = new StringList("b,12");

        assertEquals(this.strList.getTail().toString(), tail.toString());
    }

    @Test
    public void testLength() {
        assertEquals(this.strList.length(), 3);
    }
}

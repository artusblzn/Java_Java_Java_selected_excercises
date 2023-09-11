package chapter07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import chapter07.StringList;

public class StringListTests {
    private StringList strList = new StringList();

    @BeforeEach
    public void setUp() {
        this.strList.addItem("a");
        this.strList.addItem("b");
        this.strList.addItem(12);
    }

    private static Stream<Arguments> providePositionsAndItems() {
        return Stream.of(Arguments.of(0, "a"), Arguments.of(1, "b"),
                Arguments.of(2, Integer.valueOf(12).toString()));
    }

    @ParameterizedTest
    @MethodSource("providePositionsAndItems")
    public void testGetItem(int position, String item) {
        assertEquals(this.strList.getItem(position), item);

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

    @ParameterizedTest
    @MethodSource("providePositionsAndItems")
    public void testGetPosition(int position, String item) {
        assertEquals(this.strList.getPosition(item), position);
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

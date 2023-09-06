package chapter07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import chapter07.BlockConverter;

public class BlockConverterTests {
    @Test
    public void testConvertion() {
        assertEquals(BlockConverter.convert("This is how we would ordinarily write a sentence."),
                "Thisi showw ewoul dordi naril ywrit easen tence.");
    }

}

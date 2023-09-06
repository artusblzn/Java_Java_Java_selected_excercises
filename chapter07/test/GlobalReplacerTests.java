package chapter07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import chapter07.GlobalReplacer;

public class GlobalReplacerTests {
    @Test
    public void testGlobalReplace() {
        String document = "To be or not to be, that is the question.";
        String replacedDocument = "To see or not to see, that is the question.";

        assertEquals(GlobalReplacer.globalReplace(document, "be", "see"), replacedDocument);
    }
}

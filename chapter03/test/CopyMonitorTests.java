package chapter03.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import chapter03.CopyMonitor;

public class CopyMonitorTests {

    private CopyMonitor cpm = new CopyMonitor();

    @Test
    public void testIsNotOverused() {
        cpm.setNumOfPagesPrinted(10);
        assertFalse(cpm.isOverused());
    }

    @Test
    public void testIsOverused() {
        cpm.setNumOfPagesPrinted(1000);
        assertTrue(cpm.isOverused());
    }

    @Test
    public void testDoNotNeedService() {
        cpm.setNumOfPagesPrinted(10);
        cpm.setTonerLvlIsLow(false);
        assertFalse(cpm.needService());
    }

    private static Stream<Arguments> provideNeedServiceParameters() {
        return Stream.of(Arguments.of(10, true), Arguments.of(1000, false),
                Arguments.of(1000, true));
    }

    @ParameterizedTest
    @MethodSource("provideNeedServiceParameters")
    public void testNeedService(int numOfPagesPrinted, boolean tonnerLvlIsLow) {
        cpm.setNumOfPagesPrinted(numOfPagesPrinted);
        cpm.setTonerLvlIsLow(tonnerLvlIsLow);
        assertTrue(cpm.needService());
    }
}

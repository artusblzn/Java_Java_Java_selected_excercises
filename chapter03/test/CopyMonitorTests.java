package chapter03.test;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import chapter03.CopyMonitor;

public class CopyMonitorTests {

    private CopyMonitor cpm = new CopyMonitor();

    @Test
    public void testIsOverused() {
        cpm.setNumOfPagesPrinted(10);
        assertEquals(cpm.isOverused(), false);

        cpm.setNumOfPagesPrinted(1000);
        assertEquals(cpm.isOverused(), true);
    }

    @Test
    public void testNeedService() {
        cpm.setNumOfPagesPrinted(10);
        cpm.setTonerLvlIsLow(false);
        assertEquals(cpm.needService(), false);

        cpm.setNumOfPagesPrinted(10);
        cpm.setTonerLvlIsLow(true);
        assertEquals(cpm.needService(), true);

        cpm.setNumOfPagesPrinted(1000);
        cpm.setTonerLvlIsLow(false);
        assertEquals(cpm.needService(), true);

        cpm.setNumOfPagesPrinted(1000);
        cpm.setTonerLvlIsLow(true);
        assertEquals(cpm.needService(), true);

    }
}

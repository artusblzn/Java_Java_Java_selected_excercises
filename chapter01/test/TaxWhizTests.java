/**
 * EXERCISE 1.23 Challenge: Define a class named TaxWhiz that computes the sales tax for a purchase.
 * It should store the current tax rate as an instance variable. Following the model of the Riddle
 * class, you can initialize the rate using a TaxWhiz() method. This class should have one public
 * method, calcTax(double purchase), which returns a double, whose value is purchases times the tax
 * rate. For example, if the tax rate is 4 percent, 0.04, and the purchase is $100, then calcTax()
 * should return 4.0.
 */


package chapter01.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import chapter01.TaxWhiz;

public class TaxWhizTests {

    private TaxWhiz tw = new TaxWhiz(0.04);

    @Test
    public void testCalcTax() {
        assertEquals(this.tw.calcTax(100), 4.0);
    }

}

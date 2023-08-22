package chapter01;

public class TaxWhiz {
    private double taxRate;

    public TaxWhiz(double taxRate) {
        this.taxRate = taxRate;
    }

    public double calcTax(double purchase) {
        return purchase * this.taxRate;
    }
}

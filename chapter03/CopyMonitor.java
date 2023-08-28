/**
 * EXERCISE 3.19 Challenge. Define a CopyMonitor class that solves the fol- lowing problem. A
 * company needs a monitor program to keep track of when a particular copy machine needs service.
 * The device has two important (boolean) variables: its toner level (too low or not) and whether it
 * has printed more than 100,000 pages since its last servicing (it either has or has not). The
 * servicing rule that the company uses is that service is needed when either 100,000 pages have
 * been printed or the toner is too low. Your program should contain a method that reports either
 * “service needed” or “service not needed” based on the machine’s state. (Pretend that the machine
 * has other methods that keep track of toner level and page count.)
 */


package chapter03;

public class CopyMonitor {
    // I adapted a little bit here. User not two booleans but a boolean and an int attributes
    private boolean tonerLvlIsLow;
    private int numOfPagesPrinted;

    public CopyMonitor() {
        this.tonerLvlIsLow = false;
        this.numOfPagesPrinted = 0;
    }

    public void setNumOfPagesPrinted(int numOfPagesPrinted) {
        if (numOfPagesPrinted > 0) {
            this.numOfPagesPrinted = numOfPagesPrinted;
        } else {
            this.numOfPagesPrinted = 0;
        }
    }

    public void setTonerLvlIsLow(boolean tonerLvlIsLow) {
        this.tonerLvlIsLow = tonerLvlIsLow;
    }

    public boolean isOverused() {
        return this.numOfPagesPrinted >= 1000;
    }

    public boolean needService() {
        return (this.tonerLvlIsLow == true) || this.isOverused();
    }

}

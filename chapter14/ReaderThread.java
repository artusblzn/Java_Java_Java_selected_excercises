package chapter14;

public class ReaderThread extends Thread {

    private JTextBuffer buffer;

    public ReaderThread(JTextBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 50));
                System.out.println(this.buffer.read());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

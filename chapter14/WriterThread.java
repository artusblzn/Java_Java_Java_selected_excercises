package chapter14;

public class WriterThread extends Thread {
    private JTextBuffer buffer;

    public WriterThread(JTextBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 50));
                int number = (int) (Math.random() * 100);
                this.buffer.write(Integer.toString(number));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

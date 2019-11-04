import java.util.concurrent.*;

public class Decrease extends Thread {
  public Semaphore decrease;
  public Semaphore increase;
  public double fredVelocity;
  public double wilmaVelocity;

  public Decrease(Semaphore decrease, Semaphore increase, double fredVelocity, double wilmaVelocity) {
    this.decrease = decrease;
    this.increase = increase;
    this.fredVelocity = fredVelocity;
    this.wilmaVelocity = wilmaVelocity;
  }

  public void run() {
    try {

      for(int i = 0; i < 10; i++) {
        while (Main.wilmaHeight > 1) {
          decrease.acquire();
          Main.wilmaHeight -= fredVelocity;
          System.out.println("Wilma's Height: " + Main.wilmaHeight);
          Thread.sleep(1);
          increase.release();
        }
        while(Main.fredHeight > 1) {
          decrease.acquire();
          Main.fredHeight -= wilmaVelocity;
          System.out.println("Fred's Height: " + Main.fredHeight);
          Thread.sleep(1);
          increase.release();
        }
      }
    } catch (Exception e) {}
  }
}

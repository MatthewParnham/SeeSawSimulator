import java.util.concurrent.*;

public class Increase extends Thread {
  public Semaphore decrease;
  public Semaphore increase;
  public double fredVelocity;
  public double wilmaVelocity;

  public Increase(Semaphore decrease, Semaphore increase, double fredVelocity, double wilmaVelocity) {
    this.decrease = decrease;
    this.increase = increase;
    this.fredVelocity = fredVelocity;
    this.wilmaVelocity = wilmaVelocity;
  }

  public void run() {
    try {

      for(int i = 0; i < 10; i++) {
        while (Main.fredHeight < 7) {
          increase.acquire();
          Main.fredHeight += fredVelocity;
          System.out.println("Fred's Height: " + Main.fredHeight);
          Thread.sleep(1);
          decrease.release();
        }
        while(Main.wilmaHeight < 7) {
          increase.acquire();
          Main.wilmaHeight += wilmaVelocity;
          System.out.println("Wilma's Height: " + Main.wilmaHeight);
          Thread.sleep(1);
          decrease.release();
        }
      }
    } catch (Exception e) {}
  }
}

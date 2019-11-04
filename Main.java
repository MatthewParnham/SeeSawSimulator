import java.util.concurrent.*;

public class Main {

  public static final double fredVelocity = 1;
  public static final double wilmaVelocity = 1.5;
  public static double fredHeight = 1;
  public static double wilmaHeight = 7;

  public static void main(String[] args) {


    Semaphore decrease = new Semaphore(0);
    Semaphore increase = new Semaphore(1);

    Increase inc = new Increase(decrease, increase, fredVelocity, wilmaVelocity);
    Decrease dec = new Decrease(decrease, increase, fredVelocity, wilmaVelocity);

    inc.start();
    dec.start();

    try {
      inc.join();
      dec.join();
    } catch(Exception e) {}


  }

}

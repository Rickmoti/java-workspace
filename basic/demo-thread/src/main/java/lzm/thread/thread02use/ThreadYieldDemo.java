package lzm.thread.thread02use;

/**
 * <p> 线程礼让  </p>
 * <p> yield 方法只是对线程调度的一个建议，而且也只是建议具有相同优先级的其它线程可以运行 </p>
 *
 * @author liuziming
 * @description
 * @date 2023/5/23 10:47
 */
public class ThreadYieldDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "线程1");
        Thread thread2 = new Thread(myThread, "线程2");
        thread1.start();
        thread2.start();
    }

    static class MyThread implements Runnable {

        public void run() {
            for (int i = 0; i < 10; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + "运行第" + i + "次");

                if (i == 2) {
                    System.out.println("线程礼让");
                    Thread.yield();
                }

            }
        }
    }
}

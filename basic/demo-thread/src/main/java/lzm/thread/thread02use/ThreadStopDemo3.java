package lzm.thread.thread02use;

import java.util.concurrent.TimeUnit;

/**
 * <p> 使用 interrupt 方法和 Thread.interrupted 方法配合使用来控制线程终止 </p>
 *
 * @author liuziming
 * @description
 * @date 2023/5/23 14:43
 */
public class ThreadStopDemo3 {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread, "MyThread");
        thread.start();
        TimeUnit.MILLISECONDS.sleep(50);
        thread.interrupt();
    }


    static class MyThread implements Runnable {
        private volatile int count = 0;

        public void run() {
            System.out.println(Thread.currentThread()
                    .getName() + "线程开始运行");
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程运行中:" + count++);
            }
            System.out.println(Thread.currentThread()
                    .getName() + "线程结束运行");
        }

    }

}

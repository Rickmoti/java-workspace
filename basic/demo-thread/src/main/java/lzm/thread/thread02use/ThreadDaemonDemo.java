package lzm.thread.thread02use;

import java.util.concurrent.TimeUnit;

/**
 * <p> 守护线程 </p>
 *
 * @author liuziming
 * @description
 * @date 2023/5/23 14:43
 */
public class ThreadDaemonDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread, "MyThread");
        thread.setDaemon(true);
        System.out.println(
                "thread.isDaemon() = " + thread.isDaemon());
        thread.start();
    }


    static class MyThread implements Runnable {
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName()+"线程运行中");
            }
        }
    }

}

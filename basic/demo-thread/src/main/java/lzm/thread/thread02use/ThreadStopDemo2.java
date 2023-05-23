package lzm.thread.thread02use;

import java.util.concurrent.TimeUnit;

/**
 * <p> Cancel来停止线程 </p>
 * <p> 定义 volatile 标志位，在 run 方法中使用标志位控制线程终止 </p>
 * @author liuziming
 * @description
 * @date 2023/5/23 14:43
 */
public class ThreadStopDemo2 {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread, "MyThread");
        thread.start();
        TimeUnit.MILLISECONDS.sleep(50);
        myThread.cancel();
    }


    static class MyThread implements Runnable {
        private volatile boolean flag = true;
        private volatile int count = 0;

        public void run() {
            System.out.println(Thread.currentThread()
                    .getName() + "线程开始运行");
            while (flag) {
                System.out.println("线程运行中:" + count++);
            }
            System.out.println(Thread.currentThread()
                    .getName() + "线程结束运行");
        }

        public void cancel() {
            flag = false;
        }
    }

}

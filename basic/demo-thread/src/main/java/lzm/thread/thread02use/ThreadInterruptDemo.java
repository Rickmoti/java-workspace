package lzm.thread.thread02use;

/**
 * <p> 中断线程运行状态 </p>
 *
 * @author liuziming
 * @description
 * @date 2023/5/23 10:58
 */
public class ThreadInterruptDemo {


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread, "MyThread");
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("主线程休眠被中断");
        }
        t.interrupt();
        System.out.println(Thread.currentThread().getName()+"线程中断状态："+Thread.currentThread().isInterrupted());

    }

    static class MyThread implements Runnable{

        public void run() {
            System.out.println("1.线程开始运行");

            try {
                System.out.println("2.线程休眠10秒");
                Thread.sleep(100000);

            } catch (InterruptedException e) {
                //System.out.println("3.MyThread线程休眠被中断,中断状态："+Thread.currentThread().isInterrupted());
                System.out.println("3."+Thread.currentThread().getName()+"线程休眠被中断,中断状态："+Thread.currentThread().isInterrupted());

            }
            System.out.println("4.线程结束运行");
        }
    }

}

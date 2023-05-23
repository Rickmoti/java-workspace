package lzm.thread.thread02use;

/**
 * <p> 休眠 </p>
 *
 * @author liuziming
 * @description
 * @date 2023/5/23 10:40
 */
public class ThreadSleepDemo {

    public static void main(String[] args) {
        new Thread(new MyThread("线程-A", 500)).start();
        new Thread(new MyThread("线程-B", 1000)).start();
        new Thread(new MyThread("线程-C", 1500)).start();
    }


    static class MyThread implements Runnable{
        /**
         * 线程名称
         */
        private String name;
        /**
         * 线程休眠时间
         */
        private int time;

        private MyThread(String name, int time) {
            this.name = name;
            this.time = time;
        }
        public void run() {

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

           // System.out.println(name + " 线程休眠了 " + time + " 毫秒");
            System.out.println(this.name + " 线程休眠了 " + this.time + " 毫秒");
        }
    }

}

package lzm.thread.thread01create;

/**
 * <p> 通过继承Thread创建 </p>
 *
 * @author liuziming
 * @description
 * @date 2023/5/23 9:56
 */
public class CreatThreadWay02 {

    public static void main(String[] args) {

        MyThread tA = new MyThread("Thread-线程A");
        MyThread tB = new MyThread("Thread-线程B");

        tA.start();
        tB.start();
    }

    static class MyThread extends Thread {
        private int ticket = 5;

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket + "张票");
                ticket--;
            }
        }
    }

}

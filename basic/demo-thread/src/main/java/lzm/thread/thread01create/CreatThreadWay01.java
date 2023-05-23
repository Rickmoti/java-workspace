package lzm.thread.thread01create;

/**
 * <p> 通过runnable创建 </p>
 *
 * @author liuziming
 * @description
 * @date 2023/5/23 9:56
 */
public class CreatThreadWay01 {

    public static void main(String[] args) {
        // 实例化对象
        Thread tA = new Thread(new MyThread(), "Runnable 线程-A");
        Thread tB = new Thread(new MyThread(), "Runnable 线程-B");
        // 调用线程主体
        tA.start();
        tB.start();
    }


    static class MyThread implements Runnable {

        private int ticket = 5;

        public void run() {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出了第 " + ticket + " 张票");
                ticket--;
            }
        }

    }

}

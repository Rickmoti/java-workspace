package lzm.thread.thread02use;

/**
 * <p> Join使用 </p>
 *
 * @author liuziming
 * @description
 * @date 2023/5/23 15:53
 */
public class ThreadJoinDemo {


    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread, "线程A");
        thread.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("Main线程运行 --> " + i);
            if (i > 10) {
                try {
                    thread.join(); // 等待线程thread结束
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    static class MyThread implements Runnable {

        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " 运行，i = " + i); // 取得当前线程的名字
            }
        }
    }
}

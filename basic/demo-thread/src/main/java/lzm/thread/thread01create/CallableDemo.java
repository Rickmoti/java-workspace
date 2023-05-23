package lzm.thread.thread01create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p> 通过实现Callable </p>
 * Callable + Future + FutureTask 示例
 * 通过实现 Callable 接口创建线程的步骤：
 * 1.创建 Callable 接口的实现类，并实现 call 方法。该 call 方法将作为线程执行体，并且有返回值。
 * 2.创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call 方法的返回值。
 * 3.使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
 * 4.调用 FutureTask 对象的 get 方法来获得线程执行结束后的返回值。
 * @author liuziming
 * @description
 * @date 2023/5/23 10:22
 */
public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Long>  callable = new MyThread();

        FutureTask<Long> future = new FutureTask<Long>(callable);

        Thread tA = new Thread(future, "Callable 线程-A");
        tA.start();
        System.out.println("任务耗时：" + (future.get()/1000000) + " 毫秒");
    }

    static class MyThread implements Callable<Long> {

        private int ticket = 10000;
        public Long call() {

            long begin = System.nanoTime();
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出了第 " + ticket + " 张票");
                ticket--;
            }
            long end = System.nanoTime();
            return (end - begin);
        }
    }
}

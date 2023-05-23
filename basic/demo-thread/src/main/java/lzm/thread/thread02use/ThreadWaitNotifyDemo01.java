package lzm.thread.thread02use;


import java.util.PriorityQueue;

/**
 * <p> waite、notifie、notifyAll在生产者消费者中使用 </p>
 *
 * @author liuziming
 * @description
 * @date 2023/5/23 15:14
 */
public class ThreadWaitNotifyDemo01 {

    private static final int QUEUE_SIZE = 10;
    private static final PriorityQueue<Integer> queue = new PriorityQueue<Integer>(QUEUE_SIZE);

    public static void main(String[] args) {
        new Producer("生产者A").start();
        new Producer("生产者B").start();
        new Consumer("消费者A").start();
        new Consumer("消费者B").start();
    }


    static class Consumer extends Thread {

        Consumer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列为空，等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notifyAll();
                        }
                    }
                    queue.poll();//每次移走队首元素
                    queue.notifyAll();//唤醒生产者线程
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                }
            }
        }
    }

    static class Producer extends Thread {

        Producer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == QUEUE_SIZE) {
                        try {
                            System.out.println("队列已满，等待消费者消费");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notifyAll();
                        }
                    }
                    queue.offer(1);//每次移走队首元素
                    queue.notifyAll();//唤醒消费者线程
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "向队列放入一个元素，队列剩余" + queue.size() + "个元素");
                }
            }

        }
    }
}
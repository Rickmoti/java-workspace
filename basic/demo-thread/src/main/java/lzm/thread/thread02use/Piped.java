package lzm.thread.thread02use;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道
 * 管道
 * 管道输入/输出流和普通的文件输入/输出流或者网络输入/输出流不同之处在于，
 * 它主要用于线程之间的数据传输，而传输的媒介为内存。
 * 管道输入/输出流主要包括了
 * 如下 4 种具体实现：PipedOutputStream、PipedInputStream、PipedReader 和 PipedWriter，
 * 前两种面向字节，而后两种面向字符。
 *
 * @author liuziming
 * @date 2023/05/23
 */
public class Piped {

    public static void main(String[] args) throws Exception {

        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();

        // 将输出流和输入流进行连接，否则在使用时会抛出IOException
        pipedWriter.connect(pipedReader);
        Thread thread = new Thread(
                new Print(pipedReader), "PrintThread"
        );
        thread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                pipedWriter.write(receive);
            }
        } finally {
            pipedWriter.close();
        }

    }

    static class Print implements Runnable {

        private PipedReader in;

        Print(PipedReader in) {
            this.in = in;
        }

        public void run() {
            int receive = 0;
                try {
                   while ((receive = in.read()) !=-1){
                       System.out.print((char)receive);
                   }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


        }
    }
}
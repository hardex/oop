package lesson_6;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by odogryk on 10.05.2015.
 */
public class CopyTh implements Runnable {
    int tNumber;
    RandomAccessFile in, out;
    volatile long seak;

    public CopyTh(RandomAccessFile in, RandomAccessFile out, long seak) {
//            this.tNumber = tNumber;
        this.in = in;
        this.out = out;
        this.seak = seak;
    }

    @Override
    public void run() {

        synchronized (out) {
            try {
                byte[] buf = new byte[1024]; // 1 KB
                int r;
                in.seek(seak);
                out.seek(seak);
                r = in.read(buf, 0, buf.length);
                if (r > 0) {
                    out.write(buf, 0, r);
                    System.out.print('.');
//                    Thread.sleep(500);
                }
            } catch (IOException ie) {
//            } catch (IOException|InterruptedException ie) {
                System.out.println("Write block Exception, " + seak + " : " + ie.getMessage() + '\n' + ie.getStackTrace());
//            System.out.println("Stop thread Number : "+ tNumber);
//            return;
            }
        }
    }

}

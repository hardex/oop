package lesson_6;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by odogryk on 12.05.2015.
 */
public class CopyThread extends Thread {
    private boolean isLog = false;
    int tNumber;
    RandomAccessFile in, out;
    volatile long seak;

    public CopyThread (RandomAccessFile in, RandomAccessFile out, long seak) {
//            this.tNumber = tNumber;
        this.in = in;
        this.out = out;
        this.seak = seak;
    }

    @Override
    public void run() {

        try {
//                FileOutputStream fLog = new FileOutputStream("i:\\dev\\logs\\" + Integer.toHexString((int) seak)+".byte");

            synchronized (in) {
                byte[] buf = new byte[1024]; // 1 KB
                int r = 0;
                in.seek(seak);
                out.seek(seak);
                r = in.read(buf, 0, buf.length);
//                        if (isLog) fLog.write(buf, 0, r);
                if (r > 0) {
                    out.write(buf, 0, r);
//                            if (isLog) fLog.write(buf, 0, r);
                    System.out.print('.');
                }
//                fLog.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

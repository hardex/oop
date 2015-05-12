package lesson_6;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by odogryk on 12.05.2015.
 */
public class CopyFileThread implements Runnable {
    private boolean isLog = false;
    private final RandomAccessFile inFile, outFile;
    private final long seak;

    public CopyFileThread(RandomAccessFile inFile, RandomAccessFile outFile, long seak) {
//            this.tNumber = tNumber;
        this.inFile = inFile;
        this.outFile = outFile;
        this.seak = seak;
    }

    @Override
    public void run() {

        try {
//                FileOutputStream fLog = new FileOutputStream("i:\\dev\\logs\\" + Integer.toHexString((int) seak)+".byte");

            synchronized (inFile) {
                inFile.seek(seak);
                outFile.seek(seak);
                byte[] buf = new byte[1024]; // 1 KB
                int r = inFile.read(buf);
//                int r = inFile.read(buf, 0, buf.length);
//                        if (isLog) fLog.write(buf, 0, r);
                if (r > 0) {
                    outFile.write(buf, 0, r);
//                            if (isLog) fLog.write(buf, 0, r);
                    System.out.println(Thread.currentThread().getId());
                }
//                fLog.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

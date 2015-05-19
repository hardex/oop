package lesson_6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by odogryk on 12.05.2015.
 */
public class CopyFileThread implements Runnable {
    private boolean isLog = false;
    private final RandomAccessFile inFile, outFile;
    private final long seak;
    byte[] fileBuff;

    public CopyFileThread(RandomAccessFile inFile, RandomAccessFile outFile, long seak) {
        this.inFile = inFile;
        this.outFile = outFile;
        this.seak = seak;
    }

    public CopyFileThread(RandomAccessFile inFile, RandomAccessFile outFile, long seak, boolean isLog) {
        this.inFile = inFile;
        this.outFile = outFile;
        this.seak = seak;
        this.isLog = isLog;
    }

    public CopyFileThread(RandomAccessFile inFile, RandomAccessFile outFile, long seak, byte[] fileBuff) {
        this.inFile = inFile;
        this.outFile = outFile;
        this.seak = seak;
        this.fileBuff = fileBuff;
    }

    @Override
    public void run() {

        try {

            synchronized (inFile) {
                inFile.seek(seak);
                outFile.seek(seak);
                byte[] buf = new byte[1024]; // 1 KB
                if (inFile.getFilePointer() != seak) System.out.println("position source file "+Integer.toHexString((int) inFile.getFilePointer()) + " != " + Integer.toHexString((int) seak) + " seek");
                int r = inFile.read(buf);
                if (r > 0) {
                    // store to global buffer
                    if (fileBuff != null)
                        for (int i = (int) seak; (i < seak + 1024) && (i < fileBuff.length); i++) fileBuff[i] = buf[i- (int)seak];

                    // Log buffer into file
                    if (isLog) {
                        FileOutputStream fLog =
                                new FileOutputStream("i:\\dev\\logs\\" + String.format("%10s", Integer.toHexString((int) seak)).replace(' ', '0') + ".byte");
                        fLog.write(buf, 0, r);
                        fLog.close();
                    }
                    // Write
                    if (outFile.getFilePointer() != seak) System.out.println("position dest file "+Integer.toHexString((int) outFile.getFilePointer()) + " != " + Integer.toHexString((int) seak) + " seek");
                    outFile.write(buf, 0, r);

                    System.out.println(Integer.toHexString((int) seak));
                } else
                    System.out.println("can't read byte: "+Integer.toHexString((int) seak)+ " code:"+r);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package lesson_6;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 */
public class FileBlockCopier implements Runnable {
    public static final int BUFFER_SIZE = 1024;
    private final long firstByteIndex;
    private final long lastByteIndex;
    private final RandomAccessFile readFile;
    private final RandomAccessFile writeFile;

    public FileBlockCopier(long firstByteIndex, long lastByteIndex, RandomAccessFile readFile, RandomAccessFile writeFile) {
        this.firstByteIndex = firstByteIndex;
        this.lastByteIndex = lastByteIndex;
        this.readFile = readFile;
        this.writeFile = writeFile;
    }

    public FileBlockCopier(long firstByteIndex, RandomAccessFile readFile, RandomAccessFile writeFile) {
        this.firstByteIndex = firstByteIndex;
        this.lastByteIndex = firstByteIndex + BUFFER_SIZE - 1;
        this.readFile = readFile;
        this.writeFile = writeFile;
    }

    @Override
    public void run() {
        try {
            synchronized (readFile) {
                readFile.seek(firstByteIndex);
                writeFile.seek(firstByteIndex);
                long k = firstByteIndex; // index of byte must be written
                byte[] buf = new byte[BUFFER_SIZE];
                do {
                    int r = readFile.read(buf);
                    if (r > 0) {
                        writeFile.write(buf, 0, r);
                        k += r;
                    } else {
                        break;
                    }
                } while (k <= lastByteIndex);
                System.out.println(Thread.currentThread().getId());
/*
                System.out.printf("Thread %d has written %d bytes of block [%d - %d] %n",
                        Thread.currentThread().getId(), k - firstByteIndex, firstByteIndex, lastByteIndex);
*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

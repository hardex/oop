package lesson_6;

import java.io.*;
import java.util.Arrays;

/**
 * Created by odogryk on 02.05.2015.
 * 5. * Копирование файла блоками (1 поток на блок).
 */
public class hw_5 {

    static final int BLOCK_SIZE = 1024;

    private static String getHex(byte[] b) {
        StringBuffer st = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            st.append(String.format("%X", b[i]));
        }
        return st.toString();
    }

    public static void TestFile(String src, String dest) throws Exception {
        RandomAccessFile inFile = new RandomAccessFile(src, "r");
        System.out.println("Testing file ...");
        try {
            RandomAccessFile outFile = new RandomAccessFile(dest, "rw");
            try {
                for (int i = 0; i < inFile.length(); i+= 1024) {

                    byte[] bufS = new byte[1024]; // 1 KB
                    byte[] bufD = new byte[1024]; // 1 KB
                    int rSrc, rDest;
                    inFile.seek(i);
                    outFile.seek(i);
                    rSrc = inFile.read(bufS, 0, bufS.length);
                    rDest = outFile.read(bufD, 0, bufD.length);
                    if (rSrc > 0 && rDest > 0) {
                        if (!Arrays.equals(bufD,bufS)) {
                            System.out.println("Wrong Block : " + Integer.toHexString(i) + " byte" +
                                    "\nSource-" + getHex(bufS) + ", \nDest  -" + getHex(bufD));
                            i=(int) inFile.length(); // to end read.

                            // real block number search
                            int j = 0;
                            while (j < inFile.length()) {
                                inFile.seek(j);
                                rSrc = inFile.read(bufS, 0, bufS.length);
                                if (Arrays.equals(bufD, bufS)) {
                                    System.out.println("Real Block : " + Integer.toHexString(j) + " byte" +
                                            "\nSource-" + getHex(bufS));
                                    j = (int) inFile.length(); // to end read.
                                }
                                j += 1024;
                            }
                        }
                    } else {
                        System.out.println("Wrong reading ...");
                    }
                }
            } finally {
                outFile.close();
            }
        } finally {
            inFile.close();
        }
    }

    public static void copyFile(String src, String dest, final int numberOfThreads)
            throws Exception {
        try (
            RandomAccessFile inFile = new RandomAccessFile(src, "r");
            RandomAccessFile outFile = new RandomAccessFile(dest, "rw")
        ) {
            Thread[] threads = new Thread[numberOfThreads];
            long currSeek = 0;
            while (currSeek < inFile.length()) {

                boolean isFoundThreadFree = false;
                while (!isFoundThreadFree) {
                    for (int i = 0; i < numberOfThreads; i++) {
                        if ((threads[i] == null) || !threads[i].isAlive()) {
//                                threads[i] = new CopyThread(inFile, outFile, currSeek);
                            threads[i] = new Thread(new CopyFileThread(inFile, outFile, currSeek));
//                            threads[i] = new Thread(new FileBlockCopier(currSeek, inFile, outFile));
                            threads[i].start();
                            isFoundThreadFree = true;
                        }
                    }
                    if (!isFoundThreadFree) threads[0].join();
                }
                currSeek += BLOCK_SIZE;
            }

            for (int i = 0; i < numberOfThreads; i++) {
                threads[i].join();
            }
        }
    }

    private static void performMultithreadedCopy(String source, String destination, final int numberOfThreads)
            throws IOException, InterruptedException {
        try ( RandomAccessFile sourceFile = new RandomAccessFile(source, "r");
              RandomAccessFile destFile = new RandomAccessFile(destination, "rw"))
        {
            long size = sourceFile.length();
            final long HEAD_BLOCK_SIZE = 1024;
            Thread[] threads = new Thread[numberOfThreads];

            long currSeek = 0;
            while (currSeek < size) {

                boolean isAnyThreadFree = false;
                while (!isAnyThreadFree) {
                    for (int i = 0; i < numberOfThreads; i++) {
                        if ((threads[i] == null) || !threads[i].isAlive() ) {
                            threads[i] = new Thread(new CopyFileThread(sourceFile, destFile, currSeek));
//                            threads[i] = new Thread(new FileBlockCopier(currSeek, sourceFile, destFile));
                            threads[i].start();
                            isAnyThreadFree = true;
                        }
                    }
                    if (!isAnyThreadFree) threads[0].join();
                }

                currSeek += HEAD_BLOCK_SIZE;
            }

            for (int i = 0; i < numberOfThreads; i++) {
                threads[i].join();
            }

            System.out.println("After join() threads result file size is " + destFile.length());
        }
    }

    public static void main(String[] args) {

        try {
            performMultithreadedCopy("I:\\dev\\Filosofiya-Java.pdf", "I:\\dev2\\Filosofiya-Java.pdf", 100);
//            copyFile("I:\\dev\\Filosofiya-Java.pdf", "I:\\dev2\\Filosofiya-Java.pdf", 100);
            TestFile("I:\\dev\\Filosofiya-Java.pdf", "I:\\dev2\\Filosofiya-Java.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

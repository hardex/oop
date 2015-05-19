package lesson_6;

import java.io.*;
import java.util.Arrays;

/**
 * Created by odogryk on 02.05.2015.
 * 5. * Копирование файла блоками (1 поток на блок).
 */
public class hw_5 {

    static byte[] fileBuff;
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
        System.out.print("Testing file ...");
        try {
            RandomAccessFile outFile = new RandomAccessFile(dest, "rw");
            try {
                byte[] bufS = new byte[1024]; // 1 KB
                byte[] bufD = new byte[1024]; // 1 KB
                int rSrc, rDest;
                boolean isEqual = true;

                for (int i = 0; i < inFile.length(); i+= 1024) {
                    inFile.seek(i);
                    outFile.seek(i);
                    rSrc = inFile.read(bufS, 0, bufS.length);
                    rDest = outFile.read(bufD, 0, bufD.length);
                    if (rSrc > 0 && rDest > 0) {
                        if (!Arrays.equals(bufD,bufS)) {
                            System.out.println("\nWrong Block : " + Integer.toHexString(i) + " byte" +
                                    "\nSource-" + getHex(bufS) + ", \nDest  -" + getHex(bufD));

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

                            // check in buffer
                            System.out.println("Buffer Block : " + Integer.toHexString(i) + " byte" +
                                    "\nSource-" + getHex(Arrays.copyOfRange(fileBuff, i, i+1023)));

                            i=(int) inFile.length(); // fori to end.
                            isEqual = false;
                        }
                    } else {
                        System.out.println("\nWrong reading ...");
                    }
                }
                if (isEqual) System.out.println("ok");
            } finally {
                outFile.close();
            }
        } finally {
            inFile.close();
        }
    }

    public static void TestBuff (String src, byte[] dest) throws Exception {
        RandomAccessFile inFile = new RandomAccessFile(src, "r");
        System.out.print("Testing buffer ...");
        try {
                byte[] bufS = new byte[1024]; // 1 KB
                int rSrc, rDest;
                boolean isEqual = true;
                for (int i = 0; i < inFile.length(); i+= 1024) {
                    inFile.seek(i);
                    rSrc = inFile.read(bufS, 0, bufS.length);
                    byte[] bufD = Arrays.copyOfRange(dest, i, i+rSrc);

                    if (rSrc > 0) {
                        if (!Arrays.equals(Arrays.copyOfRange(bufS, 0, rSrc), bufD)) {
                            System.out.println("\nWrong Block : " + Integer.toHexString(i) + " byte" +
                                    "\nSource-" + getHex(bufS) + ", \nDest  -" + getHex(bufD));

                            // real block number search
                            int j = 0;
                            while (j < inFile.length()) {
                                inFile.seek(j);
                                rSrc = inFile.read(bufS, 0, bufS.length);
                                if (Arrays.equals(bufS, bufD)) {
                                    System.out.println("Real Block : " + Integer.toHexString(j) + " byte" +
                                            "\nSource-" + getHex(bufS));
                                    j = (int) inFile.length(); // to end read.
                                }
                                j += 1024;
                            }

                            i=(int) inFile.length(); // fori to end.
                            isEqual = false;
                        }
                    } else {
                        System.out.println("\nWrong reading ...");
                    }
                }
                if (isEqual) System.out.println("ok");

        } finally {
            inFile.close();
        }
    }

    public static void copyFile(String src, String dest, final int numberOfThreads)
            throws IOException, InterruptedException {
        try (
            RandomAccessFile inFile = new RandomAccessFile(src, "r");
            RandomAccessFile outFile = new RandomAccessFile(dest, "rw")
        ) {
            long size = inFile.length();
            Thread[] threads = new Thread[numberOfThreads];
            fileBuff = new byte[(int) size];

            long currSeek = 0;
//  <<<<<<<<<<<<<<<<<<<<<<<          WRONG ACCESS to sync Var "source file" from Main thread               >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//            while (currSeek < size) {
            while (currSeek < inFile.length()) {

                boolean isFoundThreadFree = false;
                while (!isFoundThreadFree) {
                    for (int i = 0; i < numberOfThreads && !isFoundThreadFree; i++) {
                        if ((threads[i] == null) || !threads[i].isAlive()) {
                            threads[i] = new Thread(new CopyFileThread(inFile, outFile, currSeek, fileBuff));
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
            fileBuff = new byte[(int) size];
            final long HEAD_BLOCK_SIZE = 1024;
            Thread[] threads = new Thread[numberOfThreads];

            long currSeek = 0;
            while (currSeek < size) {

                boolean isAnyThreadFree = false;
                while (!isAnyThreadFree) {
                    for (int i = 0; i < numberOfThreads && !isAnyThreadFree; i++) {
                        if ((threads[i] == null) || !threads[i].isAlive() ) {
                            threads[i] = new Thread(new CopyFileThread(sourceFile, destFile, currSeek, fileBuff));
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
//            performMultithreadedCopy("I:\\dev\\Filosofiya-Java.pdf", "I:\\dev2\\Filosofiya-Java.pdf", 100);
            copyFile("I:\\dev\\Filosofiya-Java.pdf", "I:\\dev2\\Filosofiya-Java.pdf", 100);
            TestFile("I:\\dev\\Filosofiya-Java.pdf", "I:\\dev2\\Filosofiya-Java.pdf");
            TestBuff("I:\\dev\\Filosofiya-Java.pdf", fileBuff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

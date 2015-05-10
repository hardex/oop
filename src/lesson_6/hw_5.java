package lesson_6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by odogryk on 02.05.2015.
 * 5. * Копирование файла блоками (1 поток на блок).
 */
public class hw_5 {

    private static String getHex(byte[] b) {
        StringBuffer st = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            st.append(String.format("%X", b[i]));
        }
        return st.toString();
    }

    public static void TestFile(String src, String dest) throws Exception {
        RandomAccessFile in = new RandomAccessFile(src, "r");
        try {
            RandomAccessFile out = new RandomAccessFile(dest, "rw");
            try {
                for (int i = 0; i < in.length(); i+= 1024) {

                    byte[] bufS = new byte[1024]; // 1 KB
                    byte[] bufD = new byte[1024]; // 1 KB
                    int rSrc, rDest;
                    in.seek(i);
                    out.seek(i);
                    rSrc = in.read(bufS, 0, bufS.length);
                    rDest = out.read(bufD, 0, bufD.length);
                    if (rSrc > 0 && rDest > 0) {
                        if (!Arrays.equals(bufD,bufS)) {
                            System.out.println("Wrong Block : " + Integer.toHexString(i) + " byte" +
                                    "\nSource-" + getHex(bufS) + ", \nDest  -" + getHex(bufD));
                            i=(int) in.length(); // end.
                        }
                    } else {
                        System.out.println("Wrong reading ...");
                    }
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static void copyFile(String src, String dest) throws Exception {
        CopyThread ct;
        RandomAccessFile in = new RandomAccessFile(src, "r");
        try {
            RandomAccessFile out = new RandomAccessFile(dest, "rw");
            try {
                ThreadGroup tg = new ThreadGroup("my");
                for (int i = 0; i < in.length(); i+= 1024) {
                    ct = new CopyThread(tg, "Thread-"+i, in, out, i);
                    System.out.println("Active threads : "+tg.activeCount());
                    ct.start(); // запускаем поток
                    while (tg.activeCount()> 100) {
                        System.out.println(tg.activeCount());
                        Thread.sleep(500);
                    }
                }

                while (tg.activeCount()>0) {
                    System.out.println(tg.activeCount());
                    Thread.sleep(500);
                }
                Thread.sleep(5000);

            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static class CopyThread extends Thread {
        int tNumber;
        RandomAccessFile in, out;
        volatile long seak;

        public CopyThread(ThreadGroup tg, String tgName, RandomAccessFile in, RandomAccessFile out, long seak) {
            super(tg, tgName);
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

    public static void main(String[] args) {

        System.out.println("Coping file ...");
        try {
//            copyFile("I:\\dev\\Привет.docx", "I:\\dev2\\Привет.docx");
            copyFile("I:\\dev\\Filosofiya-Java.pdf", "I:\\dev2\\Filosofiya-Java.pdf");
//            TestFile("I:\\dev\\Filosofiya-Java.pdf", "I:\\dev2\\Filosofiya-Java.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

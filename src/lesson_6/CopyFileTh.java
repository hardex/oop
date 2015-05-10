package lesson_6;

import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by odogryk on 10.05.2015.
 */
public class CopyFileTh {

    private static String src;
    private static String dest;

/*
    public CopyFileTh(String src, String dest) {
        this.src = src;
        this.dest = dest;
    }

    public static void Copy() throws Exception {

        Thread ct;
        RandomAccessFile in = new RandomAccessFile(src, "r");
        try {
            RandomAccessFile out = new RandomAccessFile(dest, "rw");
            try {
//                ThreadGroup tg = new ThreadGroup("my");
                ArrayList<Thread> tg;
                for (int i = 0; i < in.length(); i += 1024) {
                    ct = new Thread(new CopyTh(in, out, i));
                    tg.add(ct);
                    System.out.println("Active threads : " + tg.activeCount());
                    ct.start(); // запускаем поток
                    for (Thread j : tg) {
                        j.join();
                    }
                    while (tg.activeCount() > 100) {
                        System.out.println(tg.activeCount());
                        Thread.sleep(500);
                    }
                }

                while (tg.activeCount() > 0) {
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
*/
}

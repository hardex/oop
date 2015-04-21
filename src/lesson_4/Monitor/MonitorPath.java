package lesson_4.Monitor;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Created by odogryk on 21.04.2015.
 */
public class MonitorPath {

    File searchPath;
    String fileExt;
    String[] checkedFileNames;
    String[] currentFileNames;
    IFileEvent event;

        public MonitorPath(String path, final String fileExt, IFileEvent event) {
            this.searchPath = new File(path);
            this.checkedFileNames = searchPath.list(new MyFileFilter(fileExt));
            Arrays.sort(this.checkedFileNames);
            System.out.println("Initial files : " + Arrays.toString(checkedFileNames));
            this.fileExt = fileExt;
            this.event = event;
        }

        public void start() throws IOException {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss,SS");

            boolean isFilePresent = false;
            // ждем, пока не появится один из файлов в списке files[]
            while (!isFilePresent) {
                currentFileNames = searchPath.list(new MyFileFilter(fileExt));

//                System.out.print(Arrays.toString(currentFileNames));

                for (String st : currentFileNames) {
                    int i = Arrays.binarySearch(checkedFileNames, st);
                    if (i < 0) {
                        // new file;
                        File f = new File(searchPath.getName() + "\\" + st);
                        Path path = f.toPath();
                        BasicFileAttributes fAtr = Files.readAttributes(path, BasicFileAttributes.class);
                        event.onFileAdded(st, sdf.format(fAtr.creationTime().toMillis()));
                    }
                }
                checkedFileNames = currentFileNames;
                Arrays.sort(checkedFileNames);

                    try {
                        System.out.println("Waiting...");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        break;
                    }

            }
        }

        private static class MyFileFilter implements FilenameFilter {
            private String ext;

            public MyFileFilter(String ext) {
                this.ext = ext;
            }

            public boolean accept(File dir, String name) {
//                System.out.println(dir + "|" + name);
                return name.endsWith(ext);
            }
        }
}

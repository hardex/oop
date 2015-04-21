package lesson_4.Monitor;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Monitor {
	String[] fileNames;
	IFileEvent event;
	
	public Monitor(String[] fileNames, IFileEvent event) {
		this.fileNames = Arrays.copyOf(fileNames, fileNames.length);
		this.event = event;
	}
	
	public Monitor(String fileName, IFileEvent event) {
		this.fileNames = new String[]{fileName};
		this.event = event;
	}

	public void start() throws IOException  {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss,SS");

		// заполнили массив файлов
		File[] files = new File[fileNames.length];
		for (int x=0; x < files.length; x++) files[x] = new File(fileNames[x]);

		boolean isFilePresent = false;
		// ждем, пока не появится один из файлов в списке files[]
		while (!isFilePresent) {

			for (int x=0; x<files.length; x++) {

				if (files[x].exists() && files[x].isFile()) {
					Path path = files[x].toPath();
					BasicFileAttributes fAtr = Files.readAttributes(path, BasicFileAttributes.class);
					if (event != null)
						event.onFileAdded(fileNames[x], sdf.format(fAtr.creationTime().toMillis()), sdf.format(fAtr.lastModifiedTime().toMillis()));
					isFilePresent = true;
				}
			}

			if (!isFilePresent) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}

				System.out.println("Waiting...");
			}
		}
	}
}

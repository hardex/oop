package lesson_4.Monitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Monitor {
	String file;
	IFileEvent event;
	
	public Monitor(String file, IFileEvent event) {
		this.file = file;
		this.event = event;
	}
	
	public void start() throws IOException  {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss,SS");
		while (true) {
			File f = new File(file);
			Path path = f.toPath();
			BasicFileAttributes fAtr = Files.readAttributes(path, BasicFileAttributes.class);

			if (f.exists() && f.isFile()) {
				if (event != null)
					event.onFileAdded(file, sdf.format(fAtr.creationTime().toMillis()), sdf.format(fAtr.lastModifiedTime().toMillis()));

				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			System.out.println("Waiting...");
		}
	}
}

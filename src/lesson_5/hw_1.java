package lesson_5;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

/*
1. Модифицировать проект FindFiles так, чтобы программа искала в
		каталоге все файлы с расширениями из списка.
*/

public class hw_1 {

	static class MyFileFilter implements FilenameFilter {
		private String[] ext;

		public MyFileFilter(String[] ext) {
			this.ext = ext;
		}

		public boolean accept(File dir, String name) {
			boolean fileMatched = false;
			for (String st : this.ext)
				if (name.endsWith(st)) fileMatched = true;
			return fileMatched;
		}
	}

	private static void findFiles(String srcPath, String[] ext, ArrayList<String> list) throws IOException {
		File dir = new File(srcPath);
		File[] files = dir.listFiles(new MyFileFilter(ext));

		for (int i = 0; i < files.length; i++) {
			list.add(srcPath + files[i].getName());
		}
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		String[] documentes = {".txt",".docx",".doc", ".pdf"};

		try {
			findFiles("I:\\Documents\\", documentes, list);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String s : list)
			System.out.println(s);
	}

}
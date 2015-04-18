package lesson_4.Monitor;

public class FileEvent implements IFileEvent {
	@Override
	public void onFileAdded(String s) {
		System.out.println("File added: " + s);
	}

	@Override
	public void onFileAdded(String s, String d) {
		System.out.println("File added: " + s + ". Creation Date/time :" + d);
	}

	@Override
	public void onFileAdded(String s, String creation_d, String modified_d) {
		System.out.println("File added: " + s + ".\n" + "Creation Date/time :" + creation_d + ".\n" + "Modified Date/time :" + modified_d);
	}
}

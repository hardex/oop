package lesson_4.Monitor;

public interface IFileEvent {
	void onFileAdded(String s);
	void onFileAdded(String s, String d);
	void onFileAdded(String s, String creation_d, String modified_d);
}

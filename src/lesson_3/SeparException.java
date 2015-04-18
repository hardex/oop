package lesson_3;

/**
 * Created by odogryk on 13.04.2015.
 */

public class SeparException extends Exception {

    public SeparException (String message) {
        super(message);
    }

    @Override
        public String getMessage() {
            return "SeparException : Incorrect separator in string - '" + super.getMessage() + "'\n'&' should be...";
            }
        }

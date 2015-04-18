package lesson_3;

/**
 * Created by odogryk on 13.04.2015.
 */

public class ValueException extends Exception {

    public ValueException(String message) {
        super(message);
    }

    @Override
        public String getMessage() {
            return "ValueException : There are no Value for parameter - '" + super.getMessage() + "'\nor '=' should be...";
            }
        }

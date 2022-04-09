package peaksoft.exceptions;

/**
 * @author Beksultan
 */
public class BadInputException extends RuntimeException {
    public BadInputException(String you_give_wrong_input_type) {
        super(you_give_wrong_input_type);
    }
}

package exception;

/*
 * Occurs when an invalid input eg.. negative values are given when values cannot be negative
 */
@SuppressWarnings("serial")
public class InvalidInputException extends RuntimeException {
    
    public InvalidInputException(String message) {
        super(message) ;
    }

}

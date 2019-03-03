package exception;
/*
 * Occurs when a user gives an invalid command. eg C 20 4 is a valid command but P 20 4 is not
 * because P is not defined
 */
@SuppressWarnings("serial")
public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(String message) {
        super(message) ;
    }
}

package exception;

@SuppressWarnings("serial")
public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(String message) {
        super(message) ;
    }
}

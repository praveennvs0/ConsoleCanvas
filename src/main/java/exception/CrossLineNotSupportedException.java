package exception;


/*
 * Occurs when a user tries to draw a 'cross' line, i.e, a line which is neither horizontal nor vertical
 */
@SuppressWarnings("serial")
public class CrossLineNotSupportedException extends RuntimeException {
public CrossLineNotSupportedException(String message) {
    super(message) ;
}
}

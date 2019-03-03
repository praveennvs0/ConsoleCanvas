package exception;
/*
 * Occurs when a user tries to create multiple canvasses
 */
@SuppressWarnings("serial")
public class CanvasAlreadyCreatedException extends RuntimeException {
    public CanvasAlreadyCreatedException(String message) {
        super(message) ;
    }

}

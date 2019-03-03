package exception;
/*
 * Occurs when a user tries to draw something before creating canvas
 */
@SuppressWarnings("serial")
public class CanvasNotCreatedException extends RuntimeException {

    public  CanvasNotCreatedException(String message) {
        super(message) ;
    }
    
}

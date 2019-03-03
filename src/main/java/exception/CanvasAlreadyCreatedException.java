package exception;

@SuppressWarnings("serial")
public class CanvasAlreadyCreatedException extends RuntimeException {
    public CanvasAlreadyCreatedException(String message) {
        super(message) ;
    }

}

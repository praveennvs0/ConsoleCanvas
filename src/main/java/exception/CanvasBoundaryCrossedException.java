package exception;
/*
 * Occurs when the user tries to draw something that goes beyond the boundaries of the canvas
 */
@SuppressWarnings("serial")
public class CanvasBoundaryCrossedException extends RuntimeException {
public CanvasBoundaryCrossedException (String message) {
    super(message) ;
}
}

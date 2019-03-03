package exception;


/*
 * Occurs when user inputs an incorrect no. of fields.
 * eg. L 1 3 1 8 is a valid command that draws lien from (1,3) to (1,8)
 * but L 1 3 is not a valid command as the co-ordinates of the second point are not mentioned
 */
@SuppressWarnings("serial")
public class TooManyOrTooFewArgumentsInCommandException extends RuntimeException {

    public TooManyOrTooFewArgumentsInCommandException(String message) {
        super(message) ;
    }
}

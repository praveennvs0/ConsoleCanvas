package drawing.console.canvas;

import java.util.List;

import exception.*;


public abstract class CommandExecutor {
public abstract Canvas executeCommand(Canvas canvas,String[] cmds) ;
public abstract void validate(String[] cmds) ;

/**Checks whether canvas was created or not
 * @param canvas
 */
public void verifyCanvasCreated(Canvas canvas) {
    if(canvas == null)
        throw new CanvasNotCreatedException("You have not created canvas") ;
}


/**Checks whether the point lies inside the boundaries of the canvas or not
 * @param x
 * @param y
 * @param height
 * @param width
 */
public void validatePointInsideCanvas(int x,int y,int height,int width) {
    if(x<0 || x > height || y < 0 || y > width)
        throw new CanvasBoundaryCrossedException("You are crossing the boundaries of the canvas");
}

/**Performs numeric validations on the commands
 * @param cmds
 */
public void numericValidate(List<String> cmds) {
    for(String s: cmds) {
        try{
        Integer i = Integer.parseInt(s) ;
        if(i<0) {
           throw new InvalidInputException("invalid input entered") ;
        }
        }
        catch(NumberFormatException e) {
            throw new NumberFormatException("Please enter numeric values");
        }
    }
}
}


package drawing.console.canvas;

import exception.CanvasBoundaryCrossedException;
import exception.InvalidInputException;
import exception.TooManyOrTooFewArgumentsInCommandException;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class LineTest 
    extends TestCase
{
    
    DrawingCanvas drawingCanvas = new DrawingCanvas() ; 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LineTest( String testName )
    {
        super( testName );
    }

    
    
    public void testdrawLine() {
        String input = "C 6 3";
        Canvas canvas = drawingCanvas.drawOnCanvas(input);
        Assert.assertNotNull("canvas is null", canvas);
        String lineCommand = "L 1 2 4 2" ;
        canvas = drawingCanvas.drawOnCanvas(lineCommand) ;
        char[][] actualCharArray = canvas.getCharArray() ;
        
        char[][] expectedCharArray = {{'-', '-', '-', '-', '-', '-', '-', '-'},
                {'|',' ' ,' ' ,' ' ,' ' ,' ' ,' ' , '|'},
                {'|', 'x', 'x', 'x', 'x',' ' ,' ' , '|'}, 
                {'|',' ' ,' ' ,' ' ,' ' ,' ' ,' ' , '|'},
                 {'-', '-', '-', '-', '-', '-', '-', '-'}};
        
        TestUtil.validateCharArrays(actualCharArray,expectedCharArray) ;
        
        
    }

    public void testdrawLineNegativeInput() {
        String input = "C 6 3";
        drawingCanvas.drawOnCanvas(input); 
        input = "L -1 2 6 2" ;
        boolean exceptionEncountered = false ;
        try{
        drawingCanvas.drawOnCanvas(input);
        
        }
        catch(InvalidInputException e){
            System.out.println("invalid input given");
            exceptionEncountered = true ;
        }
        
        Assert.assertTrue("wrong exception encountered", exceptionEncountered);
        
    }
    
    public void testdrawLineCrossingBoundary() {
        String input = "C 6 3";
        Canvas canvas = drawingCanvas.drawOnCanvas(input);
        input = "L 1 2 10 2" ;
        boolean exceptionEncountered = false ;
        try{
         canvas = drawingCanvas.drawOnCanvas(input);
        Assert.assertNotNull("canvas is null", canvas);
        }
        catch(CanvasBoundaryCrossedException e){
            System.out.println("canvas boundaries crossed");
            exceptionEncountered = true ;
        }
       
        
        Assert.assertTrue("wrong exception encountered", exceptionEncountered);
        
    }
    
    public void testdrawCanvasIncorrectNoOfFieldsInCommand() {
        String input = "C 6 3";
        drawingCanvas.drawOnCanvas(input); 
        input = "L 1 2" ;
        boolean exceptionEncountered = false ;
        try{
        drawingCanvas.drawOnCanvas(input);
        }
        catch(TooManyOrTooFewArgumentsInCommandException e){
            System.out.println("invalid command given");
            exceptionEncountered = true ;
        }
        Assert.assertTrue("wrong exception encountered", exceptionEncountered);
    }

   

   
}

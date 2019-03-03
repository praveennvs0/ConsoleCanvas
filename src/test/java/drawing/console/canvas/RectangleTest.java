
package drawing.console.canvas;

import exception.InvalidInputException;
import exception.TooManyOrTooFewArgumentsInCommandException;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class RectangleTest 
    extends TestCase
{
    
    DrawingCanvas drawingCanvas = new DrawingCanvas() ; 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RectangleTest( String testName )
    {
        super( testName );
    }

    
    
    public void testdrawRectangle() {
        String input = "C 6 3";
        Canvas canvas = drawingCanvas.drawOnCanvas(input);
        Assert.assertNotNull("canvas is null", canvas);
        input= "R 1 1 4 2" ;
        canvas = drawingCanvas.drawOnCanvas(input) ;
        char[][] actualCharArray = canvas.getCharArray() ;
        
        char[][] expectedCharArray = {{'-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', 'x', 'x', 'x', 'x',' ' ,' ' , '|'}, 
                {'|', 'x', 'x', 'x', 'x',' ' ,' ' , '|'}, 
                {'|',' ' ,' ' ,' ' ,' ' ,' ' ,' ' , '|'}, 
                {'-', '-', '-', '-', '-', '-', '-', '-'}};
        TestUtil.validateCharArrays(actualCharArray,expectedCharArray) ;
        
        
    }

    public void testdrawRectangleNegativeInput() {
        String input = "C 6 3";
        drawingCanvas.drawOnCanvas(input); 
        input = "R -1 1 4 2" ;
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
    
   
    
    public void testdrawCanvasIncorrectNoOfFieldsInCommand() {
        String input = "C 6 3";
        drawingCanvas.drawOnCanvas(input); 
        input = "R 1 2" ;
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

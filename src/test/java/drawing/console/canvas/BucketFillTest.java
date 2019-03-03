
package drawing.console.canvas;

import exception.InvalidInputException;
import exception.TooManyOrTooFewArgumentsInCommandException;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class BucketFillTest 
    extends TestCase
{
    
    DrawingCanvas drawingCanvas = new DrawingCanvas() ; 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BucketFillTest( String testName )
    {
        super( testName );
    }

    
    
    public void testdrawRectangle() {
        String input = "C 6 3";
        Canvas canvas = drawingCanvas.drawOnCanvas(input);
        Assert.assertNotNull("canvas is null", canvas);
        input= "R 1 1 4 2" ;
        canvas = drawingCanvas.drawOnCanvas(input) ;
        input = "B 5 1 o" ;
        canvas = drawingCanvas.drawOnCanvas(input) ;
        char[][] actualCharArray = canvas.getCharArray() ;
        
        char[][] expectedCharArray = {{'-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', 'x', 'x', 'x', 'x', 'o', 'o', '|'},
                {'|', 'x', 'x', 'x', 'x', 'o', 'o', '|'},
                 {'|', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
                  {'-', '-', '-', '-', '-', '-', '-', '-'}} ;
        TestUtil.validateCharArrays(actualCharArray,expectedCharArray) ;
        
        
    }

    public void BucketFillNegativeInput() {
        String input = "C 6 3";
        drawingCanvas.drawOnCanvas(input); 
        input = "B -1 1 o" ;
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
        input = "R 1 2 4 2" ;
        drawingCanvas.drawOnCanvas(input);
        input = "B 1 2 o a" ;
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

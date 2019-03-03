package drawing.console.canvas;

import exception.CanvasNotCreatedException;
import exception.InvalidCommandException;
import exception.InvalidInputException;
import exception.TooManyOrTooFewArgumentsInCommandException;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class CanvasTest 
    extends TestCase
{
    
    DrawingCanvas drawingCanvas = new DrawingCanvas() ; 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CanvasTest( String testName )
    {
        super( testName );
    }

    
    
    public void testdrawCanvas() {
        String input = "C 6 3";
        Canvas canvas = drawingCanvas.drawOnCanvas(input);
        Assert.assertNotNull("canvas is null", canvas);
        char[][] actualCharArray = canvas.getCharArray() ;
        char[][] expectedCharArray = {{'-', '-', '-', '-', '-', '-', '-', '-'}, {'|', ' ',' ' ,' ' ,' ' ,' ' ,' ' , '|'},
                {'|',' ' ,' ' ,' ' ,' ' ,' ' ,' ' , '|'}, {'|',' ' ,' ' ,' ' , ' ',' ' ,' ' , '|'}, 
                {'-', '-', '-', '-', '-', '-', '-', '-'}};
        
        TestUtil.validateCharArrays(actualCharArray,expectedCharArray) ;
        
        
    }

    public void testdrawCanvasNegativeInput() {
        String input = "C -6 3";
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
    
    public void testdrawCanvasWrongCommand() {
        String input = "invalid 6 3";
        boolean exceptionEncountered = false ;
        try{
        drawingCanvas.drawOnCanvas(input);
        }
        catch(InvalidCommandException e){
            System.out.println("invalid command given");
        }
        Assert.assertTrue("wrong exception encountered", exceptionEncountered);
    }
    
    public void testdrawCanvasIncorrectNoOfFieldsInCommand() {
        String input = "C 6 3 10 20 20";
        boolean exceptionEncountered = false ;
        try{
        drawingCanvas.drawOnCanvas(input);
        }
        catch(TooManyOrTooFewArgumentsInCommandException e){
            System.out.println("invalid command given");
        }
        Assert.assertTrue("wrong exception encountered", exceptionEncountered);
    }

    public void testNonNumbericInputs() {
        String input ="C a b" ;
        boolean exceptionEncountered = false ;
        try{
            drawingCanvas.drawOnCanvas(input);
            }
            catch(NumberFormatException e){
                System.out.println("invalid input given");
                exceptionEncountered = true ;
            }
        Assert.assertTrue("wrong exception encountered", exceptionEncountered);
    }
    
    public void testdrawLineWithOutCanvas() {
        String input = "L 1 2 6 2";
        boolean exceptionEncountered = false ;
        try{
        drawingCanvas.drawOnCanvas(input);
        }
        catch(CanvasNotCreatedException e){
            System.out.println("invalid input given");
            exceptionEncountered = true ;
        }
        
        Assert.assertTrue("wrong exception encountered", exceptionEncountered);
        
    }

   
}

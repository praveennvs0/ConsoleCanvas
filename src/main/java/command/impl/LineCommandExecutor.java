package command.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import drawing.console.canvas.Canvas;
import drawing.console.canvas.CommandExecutor;
import enums.CommandName;
import exception.*;

public class LineCommandExecutor extends CommandExecutor {
    
    private int noOfParamsAllowedInCommand = 5 ;
    
    private char lineMarker = 'x' ;

    @Override
    public Canvas executeCommand(Canvas canvas, String[] cmds) {
        verifyCanvasCreated(canvas) ;
        validate(cmds) ;
        /*Pay attention. This is deliberate..User enters L x1 y1 x2 y2 but we interchange x and y to fit the 
         * graphical co-ordinates into our 2D array - matrix type representation
         * 
         */
        int y1 = Integer.parseInt(cmds[1]);
        int x1= Integer.parseInt(cmds[2]);
        int y2 = Integer.parseInt(cmds[3]);
        int x2 = Integer.parseInt(cmds[4]);
        

        
        validatePointInsideCanvas(x1,y1,canvas.getHeight(),canvas.getWidth()) ;
        validatePointInsideCanvas(x2,y2,canvas.getHeight(),canvas.getWidth()) ;
        char[][] charArray = canvas.getCharArray() ;
        drawStraightLine(x1,y1,x2,y2,lineMarker,charArray) ;
        
        canvas.setCharArray(charArray);
        return canvas;
    }

   

    public void drawStraightLine(int x1,int y1,int x2,int y2,char ch,char[][] charArray) {
        if(x1 != x2 && y1 != y2) {
            throw new CrossLineNotSupportedException("No cross or curved lines allowed") ;
        }
        
        if(y1==y2) { //vertical line
        for(int i=x1;i<=x2;i++) {
            charArray[i][y1] = ch ;
        }
    }
        
        if(x1==x2) { //horizontal line
            for(int i=y1;i<=y2;i++) {
                charArray[x1][i] = ch ;
            }
        }
       
        
    }


    @Override
        public void validate(String[] cmds)  {
            String commandName = cmds[0] ;
            if(!commandName.equals(CommandName.LINE.getCommandName())) {
                throw new InvalidCommandException("Invalid Command name entered") ;
            }
            
            if(cmds.length != noOfParamsAllowedInCommand){
                throw new TooManyOrTooFewArgumentsInCommandException("You have entered too many or too less fields in the Line command");
            }
            
            List<String> commandList = new ArrayList<String>(Arrays.asList(cmds));

            //first element in the command will be character. the remaining must be numbers
            numericValidate(commandList.subList(1, commandList.size()-1)) ;
            
         
        
    }



   
    
  
    
}

package command.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import drawing.console.canvas.Canvas;
import drawing.console.canvas.CommandExecutor;
import enums.CommandName;
import exception.*;

public class RectangleCommandExecutor extends CommandExecutor {

    private char marker = 'x' ;
    private int noOfParamsAllowedInCommand = 5 ;
    private LineCommandExecutor lineCommandExecutor = new LineCommandExecutor() ;
    
    @Override
    public Canvas executeCommand(Canvas canvas, String[] cmds) {
        verifyCanvasCreated(canvas) ;
        int y1 = Integer.parseInt(cmds[1]);
        int x1= Integer.parseInt(cmds[2]);
        int y2 = Integer.parseInt(cmds[3]);
        int x2 = Integer.parseInt(cmds[4]);
        

        validatePointInsideCanvas(x1,y1,canvas.getHeight(),canvas.getWidth()) ;
        validatePointInsideCanvas(x2,y2,canvas.getHeight(),canvas.getWidth()) ;
        
        char[][] charArray = canvas.getCharArray() ;
        lineCommandExecutor.drawStraightLine(x1,y1,x1,y2,marker,charArray) ;
        lineCommandExecutor.drawStraightLine(x1,y1,x2,y1,marker,charArray) ;
        lineCommandExecutor.drawStraightLine(x2,y1,x2,y2,marker,charArray) ;
        lineCommandExecutor.drawStraightLine(x1,y2,x2,y2,marker,charArray) ;
        
        canvas.setCharArray(charArray);
        return canvas;
    }

    @Override
    public void validate(String[] cmds) {
        String commandName = cmds[0] ;
        if(!commandName.equals(CommandName.RECTANGLE.getCommandName())) {
            throw new InvalidCommandException("Invalid Command name entered") ;
        }
        
        if(cmds.length != noOfParamsAllowedInCommand){
            throw new TooManyOrTooFewArgumentsInCommandException("You have entered too many or too less fields in the Rectangle command");
        }
        
        List<String> commandList = new ArrayList<String>(Arrays.asList(cmds));

        //first element in the command will be character. the remaining must be numbers
        numericValidate(commandList.subList(1, commandList.size()-1)) ;
        
     
    }

}

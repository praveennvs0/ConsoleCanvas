package command.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import drawing.console.canvas.Canvas;
import drawing.console.canvas.CommandExecutor;
import enums.CommandName;
import exception.*;

public class CreateCanvasCommandExecutor extends CommandExecutor{
    private int noOfParamsInCommand = 3 ;

    @Override
    public Canvas executeCommand(Canvas canvas, String[] cmds)  {
        if(canvas != null) {
          throw new CanvasAlreadyCreatedException("Multiple canvasses not allowed") ;
        }
        validate(cmds) ;
        int height = Integer.parseInt(cmds[1]) ;
        int width = Integer.parseInt(cmds[2]) ;
        Canvas c = new Canvas(height,width) ;
        return c;
    }

    @Override
    public void validate(String[] cmds)  {
        String commandName = cmds[0] ;
        if(!commandName.equals(CommandName.CANVAS.getCommandName())) {
            throw new InvalidCommandException("Invalid Command name entered") ;
        }
        
        if(cmds.length != noOfParamsInCommand){
            throw new TooManyOrTooFewArgumentsInCommandException("You have entered too many or too less fields in the Create Canvas command");
        }
        
        List<String> commandList = new ArrayList<String>(Arrays.asList(cmds));

        //first element in the command will be character. the remaining must be numbers
        numericValidate(commandList.subList(1, commandList.size()-1)) ;
    }

   

}

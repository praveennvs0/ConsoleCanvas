package command.impl;

import drawing.console.canvas.Canvas;
import drawing.console.canvas.CommandExecutor;
import enums.CommandName;
import exception.InvalidCommandException;

public class QuitCommandExecutor extends CommandExecutor {

    @Override
    public Canvas executeCommand(Canvas canvas, String[] cmds) {
        System.out.println("Terminating the canvas");
        System.exit(0);
        return canvas;
    }

    @Override
    public void validate(String[] cmds) {
        if(!cmds[0].equals(CommandName.QUIT.getCommandName())){
            throw new InvalidCommandException("You have entered wrong quit command") ;
        }
        
    }

}

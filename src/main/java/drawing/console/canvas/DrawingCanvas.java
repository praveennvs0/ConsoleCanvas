package drawing.console.canvas;

import java.util.HashMap;
import java.util.Map;

import command.impl.BucketFillCommandExecutor;
import command.impl.CreateCanvasCommandExecutor;
import command.impl.LineCommandExecutor;
import command.impl.QuitCommandExecutor;
import command.impl.RectangleCommandExecutor;
import enums.CommandName;
import exception.*;

public class DrawingCanvas {

    
    Canvas canvas ;
    //this is the delimiter in the input command
    private String commandSeparator = " " ;
    
    private static final Map<String,CommandExecutor> stringCommandExecutorMap = new HashMap<String,CommandExecutor> () ;
    
    static {
    stringCommandExecutorMap.put(CommandName.CANVAS.getCommandName(),new CreateCanvasCommandExecutor()) ;
    stringCommandExecutorMap.put(CommandName.LINE.getCommandName(),new LineCommandExecutor()) ;
    stringCommandExecutorMap.put(CommandName.RECTANGLE.getCommandName(),new RectangleCommandExecutor()) ;
    stringCommandExecutorMap.put(CommandName.BUCKETFILL.getCommandName(),new BucketFillCommandExecutor()) ;
    stringCommandExecutorMap.put(CommandName.QUIT.getCommandName(),new QuitCommandExecutor()) ;
    
    }
    
    
    /**Function that will be called by the users to draw on the canvas
     * @param command
     * @return
     */
    public Canvas drawOnCanvas(String command) {
        String[] cmds=command.split(commandSeparator) ;
        CommandExecutor commandExecutor = stringCommandExecutorMap.get(cmds[0]) ;
        if(commandExecutor==null) {
            throw new InvalidCommandException("Invalid Command name entered.Cannot execute this command") ;
        }
        canvas = commandExecutor.executeCommand(canvas, cmds) ;
        canvas.display();
        return canvas ;
    }
    
}

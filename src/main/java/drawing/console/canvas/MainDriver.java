package drawing.console.canvas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import enums.CommandName;

public class MainDriver {

    public static void main(String args[]) throws IOException {
        String command = "" ;
        DrawingCanvas drawingCanvas = new DrawingCanvas() ;
        while(command != CommandName.QUIT.getCommandName()) {
            System.out.println("enter command");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();

            String inputcmds[] = input.split(" ") ;
            command = inputcmds[0] ;
             drawingCanvas.drawOnCanvas(input);
        }
        
}
}

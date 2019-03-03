package drawing.console.canvas;

import command.impl.LineCommandExecutor;

public class Canvas {

    char[][] charArray ;
    int height,width ;
    
    private LineCommandExecutor lineCommandExecutor = new LineCommandExecutor() ;
    
    private char horizontalLineMarker='-' ;
    private char verticalLineMarker='|';
    public Canvas(int w,int h) {
        height = h ;
        width = w ;
        // this buffer is needed or else, the part of the canvas near the boundary cannot be used
        height = height + 2;
        width= width+2;
        
        charArray = new char[height][width] ;
        initializeCharArray() ;
      
        lineCommandExecutor.drawStraightLine(0,0,0,width-1,horizontalLineMarker,charArray) ;
        lineCommandExecutor.drawStraightLine(1,0,height-2,0,verticalLineMarker,charArray);
        
        lineCommandExecutor.drawStraightLine(height-1,0,height-1,width-1,horizontalLineMarker,charArray);
        lineCommandExecutor.drawStraightLine(1,width-1,height-2,width-1,verticalLineMarker,charArray) ;
    }
    
    private void initializeCharArray() {
        for(int i=0;i<height;i++) 
            for(int j=0;j<width; j++)
                charArray[i][j]=' ';
        
        
    }

    public char[][] getCharArray() {
        return charArray;
    }

    public void setCharArray(char[][] charArray) {
        this.charArray = charArray;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void display() {
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                System.out.print(charArray[i][j]);
            }
            System.out.println("");
        }
    }
    
   
       
}


DESIGN CHOICES/ASSUMPTIONS - 
1. User input must contain only one space between two consecutive values in the command.
eg. C 20 4 is valid but C    20 4 is not valid because of too many spaces
2. The command name must be upper-case. For eg. R 14 1 18 3 is valid but r 14 1 18 3 is not
Rationale: It gives us the option of preserving the lower-case for some other figure starting with the same letter. Say - 'r' for drawing Rhombus.
3. While drawing line, left or top point must be given first and right or bottom point must be given second. Else, no line will be drawn.
Rationale: Our natural tendency to draw a line is from left to right and not from right to left.
4. The above rationale holds good for Rectangle as well. The top-left point must be given before
the bottom-right point.
5. Multiple canvasses are not allowed.
6. At any time, user inputs wrong commands, the program will terminate there by throwing an appropriate exception.
7. Any attempt to go outside the boundaries of the canvas will result in failure.
8. Drawing cross lines is not allowed.


 HOW TO RUN THE CODE - 
 I have used Spring Tool Suite(STS) IDE which brings Eclipse,
 Maven and Junit together. If you are using different IDE, make sure all the three components are integrated with IDE and work well together.
 
 1. Import the code as a maven project in your IDE (preferably STS)
 (the code is also present in https://github.com/praveennvs0/ConsoleCanvas/tree/master) 
 2. Go to MainDriver.java(present in drawing.console.canvas package) and run as a Java file.
 3. For the problem description, go to drawing_program.txt
 4. For sample output, refer to SampleConsoleOutput.txt in the workspace.
 

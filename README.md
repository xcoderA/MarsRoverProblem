# MarsRoverProblem
Java solution for Mars Rover Problem.

INTRODUCTION TO THE PROBLEM
There must be a way to supply the application with the input data via a text file (a textarea is suitable for a JavaScript-based solution). The application must run. You should provide sufficient evidence that your solution is complete by, as a minimum, indicating that it works correctly against the supplied test data. Please note that you will be assessed on your judgment as well as your execution.
 
THE PROBLEM: MARS ROVERS
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.
Assume that the square directly North from (x, y) is (x, y+1).
 
INPUT:
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.
Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.
 
OUTPUT
The output for each rover should be its final co-ordinates and heading.
INPUT AND OUTPUT
Test Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
Expected Output:
1 3 N
5 1 E
 
********************************* SOLUTION *********************************************

Assumptions
1)       The plateau can never have negative coordinates
2)       The lower left coordinates of the plateau will always be (0,0)
3)       There can be n number of rovers.
4)       Rovers are placed on the plateau only when they are ready to move.
5)       Only one rover moves at a time.
6)       After completing its commands, the rover remains in the plateau.
7)       If a rover tries to move to the same coordinates where another rover is positioned, it will result in collision resulting in an error.
8)       If a rover moves beyond the plateau boundary, it will fall off resulting in an error scenario.
9)       Blank line in the input file is considered as end of inputs. The subsequent lines if present are not read.
 
Design
 
The main entities defined are
 
1)       MarsRover : The class that represents a rover. It maintains the current state of the rover .
2)       Plateau : This class represents the plateau. Holds information on the size of the plateau and the coordinates currently occupied by rovers that have finished processing their commands.
3)       MarsRoverController : The entity that sends commands to the MarsRover.
 
State Pattern is used change the state of the rover between commands. State represents the X and Y coordinates and orientation of the rover.
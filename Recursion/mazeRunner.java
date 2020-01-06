import java.io.File;
import java.util.Scanner;

public class mazeRunner 
{

	public static void main(String[] args) 
	{
		// Ask for input text file of maze
		Scanner input = null;
		input = new Scanner(System.in);
		System.out.println("Name of valid 12x12 maze file, we will find the start for you: ");
		String filePath = input.nextLine(); 
		File mazeIn;
		mazeIn = new File(filePath);
		
		// Try and catch in case of user error
		try
		{
			input = new Scanner(mazeIn);
		} 
		catch(Exception e)
		{
			System.out.println("Usage: Need file input name");
			System.out.println(e);
		}
		
		char[][] maze = new char[12][12];
		
		
		for (int i = 0; i < maze.length; ++i) 
		{
	        for(int j = 0; j < maze[i].length; ++j) 
	        {
	        	maze[i][j] = input.next().charAt(0);
	        }
		}
		
		showMaze(maze);
		int[] location = findStart(maze);
		run(maze, location[0], location[1], location[2], location[3]);
				
	}
	
	public static void run(char[][] inMaze, int x, int y, int hX, int hY)
	{
		
		// Pause the program to see the maze steps
		try 
		{
			Thread.sleep(100);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		// Base case to finish the recursion
		if (inMaze[x][y] == 'F')
		{
			System.out.println(" ");
			showMaze(inMaze);
			System.out.println("You won!");
		}
		else
		{
			inMaze[x][y] = 'O'; // Show player marker
			System.out.println("");
			showMaze(inMaze); // Print out maze
			
			// If facing North
			if (getDirection(x, y, hX, hY).equals("north"))
			{
				// If ahead is a wall
				if (inMaze[x-1][y] == '#')
				{
					// If hand is on wall turn left
					if (inMaze[hX][hY] == '#')
					{
						inMaze[x][y] = 'X';
						run(inMaze, x, y, hX-1, hY-1);
					}
					// If hand is on hallway turn right and start going down hallway
					else
					{
						// If hand touches start turn right without going down hallway
						if (hY == 11)
						{
							inMaze[x][y] = 'X';
							run(inMaze, x, y, hX+1, hY-1);
						}
						// Otherwise go down hall
						else
						{
							inMaze[x][y] = 'X';
							run(inMaze, hX, hY, hX+1, hY);
						}
					}
				}
				// If ahead is a hallway
				else
				{
					// If hand is on wall move forward facing north
					if (inMaze[hX][hY] == '#')
					{
						inMaze[x][y] = 'X';
						run(inMaze, x-1, y, hX-1, hY);
					}
					// If hand is on hallway 
					else
					{
						// If hand touches start turn right
						if (hY == 11)
						{
							inMaze[x][y] = 'X';
							run(inMaze, x, y, hX+1, hY-1);
						}
						// Otherwise go down hallway
						else
						{
							inMaze[x][y] = 'X';
							run(inMaze, hX, hY, hX+1, hY);
						}
					}
				}
			}
			// If facing East
			else if (getDirection(x, y, hX, hY).equals("east"))
			{
				// If ahead is a wall
				if (inMaze[x][y+1] == '#')
				{
					// If hand is on wall turn left
					if (inMaze[hX][hY] == '#')
					{
						inMaze[x][y] = 'X';
						run (inMaze, x, y, hX-1, hY+1);
					}
					// If hand is on open hallway turn right and start going down hallway
					else
					{
						// If hand touches start turn right and do not go down hall
						if (hX == 11)
						{
							inMaze[x][y] = 'X';
							run(inMaze, x, y, hX-1, hY-1);
						}
						// Otherwise go down hall
						else
						{
							inMaze[x][y] = 'X';
							run(inMaze, hX, hY, hX, hY-1);
						}
					}
				}
				// If ahead is a hallway
				else
				{
					// If hand is on wall move forward facing east
					if (inMaze[hX][hY] == '#')
					{
						inMaze[x][y] = 'X';
						run(inMaze, x, y+1, hX, hY+1);
					}
					// If hand is on open hallway 
					else
					{
						// If hand touches start turn right
						if (hX == 11)
						{
							inMaze[x][y] = 'X';
							run(inMaze, x, y, hX-1, hY-1);
						}
						// Otherwise go in hallway
						else
						{
							inMaze[x][y] = 'X';
							run(inMaze, hX, hY, hX, hY-1);
						}
					}
				}
			}
			// If facing South
			else if (getDirection(x, y, hX, hY).equals("south"))
			{
				// If ahead is a wall
				if (inMaze[x+1][y] == '#')
				{
					// If hand is on a wall turn left
					if (inMaze[hX][hY] == '#')
					{
						inMaze[x][y] = 'X';
						run(inMaze, x, y, hX+1, hY+1);
					}
					// If hand is on open hallway
					else
					{
						// If hand touches start, turn right and do not go down hall
						if (hY == 0)
						{
							inMaze[x][y] = 'X';
							run (inMaze, x, y, hX-1, hY+1);
						}
						// Otherwise go down hall
						else
						{
							inMaze[x][y] = 'X';
							run(inMaze, hX, hY, hX-1, hY);
						}
					}
				}
				// If ahead is a open hallway or finish
				else
				{
					// If hand is on a wall move forward facing south
					if (inMaze[hX][hY] == '#')
					{
						inMaze[x][y] = 'X';
						run(inMaze, x+1, y, hX+1, hY);
					}
					// If hand is on open hallway 
					else
					{
						// Turn right if hand touches start
						if (hY == 0)
						{
							inMaze[x][y] = 'X';
							run (inMaze, x, y, hX-1, hY+1);
						}
						// Go down hallway
						else
						{
							inMaze[x][y] = 'X';
							run (inMaze, hX, hY, hX-1, hY);
						}
					}
				}
			}
			// If facing West
			else if (getDirection(x, y, hX, hY).contentEquals("west"))
			{
				// If ahead is a wall
				if (inMaze[x][y-1] == '#')
				{
					// If hand is on a wall turn left
					if (inMaze[hX][hY] == '#')
					{
						inMaze[x][y] = 'X';
						run(inMaze, x, y, hX+1, hY-1);
					}
					// If hand is on a hallway go in it
					else
					{
						// If hand touches start, turn right without going down hall
						if (hX == 0)
						{
							inMaze[x][y] = 'X';
							run (inMaze, x, y, hX+1, hY+1);
						}
						// Otherwise send it down the hall
						else
						{
							inMaze[x][y] = 'X';
							run(inMaze, hX, hY, hX, hY+1);
						}
					}
				}
				//If ahead is a hallway
				else
				{
					// If hand is on a wall move forward facing west
					if (inMaze[hX][hY] == '#')
					{
						inMaze[x][y] = 'X';
						run(inMaze, x, y-1, hX, hY-1);
					}
					
					// If hand is on a hallway 
					else
					{
						// Turn right if hand touches the start
						if (hX == 0)
						{
							inMaze[x][y] = 'X';
							run (inMaze, x, y, hX+1, hY+1);
						}
						// Go down hallway
						else
						{
							inMaze[x][y] = 'X';
							run(inMaze, hX, hY, hX, hY+1);
						}
					}
				}
			}
		}
	}
	
	public static String getDirection(int x, int y, int hX, int hY)
	{
		if (x < hX) {return "east";}
		else if (x > hX) {return "west";}
		else if (y > hY) {return "south";}
		else {return "north";}
	}
	
	public static int[] findStart(char[][] inMaze)
	{
		int[] list = new int[4];
		for (int i=0; i<12; i++)
		{
			// Left side
			if (inMaze[i][0] == '.')
			{
				list[0] = i;
				list[1] = 0;
				list[2] = i+1;
				list[3] = 0;
				return list;
			}
			// Right side
			if (inMaze[i][11] == '.')
			{
				list[0] = i;
				list[1] = 11;
				list[2] = i-1;
				list[3] = 11;
				return list;
			}
			// Top side
			if (inMaze[0][i] == '.')
			{
				list[0] = 0;
				list[1] = i;
				list[2] = 0;
				list[3] = i-1;
				return list;
			}
			// Bottom side
			if (inMaze[11][i] == '.')
			{
				list[0] = 11;
				list[1] = i;
				list[2] = 11;
				list[3] = i+1;
				return list;
			}
		}
		return list;
	}
	
	public static void showMaze(char[][] inMaze)
	{
		for (int i = 0; i < inMaze.length; i++) 
		{
	        for(int j = 0; j < inMaze[i].length; j++) 
	        {
	        	System.out.print(inMaze[i][j] +" ");
	        }
	        System.out.println();
		}
	}
}

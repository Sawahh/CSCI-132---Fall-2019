import java.util.Scanner;
import java.util.Random;
public class Nim 
{
	public static void main(String[] args)
	{
		Nim n = new Nim();
		n.gameStart(n);
	}
	
	// instance field 
	
	Random number = new Random();
	int createMarbles;
	int whoIsFirst;
	int smartOrStupid;
	int marblePile;
	
	// constructor
	
	public Nim()
	{
		createMarbles = number.nextInt(100-10)+10;
		whoIsFirst = number.nextInt(2);
		smartOrStupid = number.nextInt(2);
		marblePile = createMarbles;
	}
	
	// methods
	
	public void gameStart(Nim n) 
	{
		System.out.println("Welcome to NIM!");
		System.out.println("There are " + marblePile + " marbles.");
		// Player has their turn first if whoIsFirst is 0
		if (whoIsFirst == 0)
		{
			System.out.println("You play first!");
			marblePile = n.playerTurn();
			while (marblePile != 1)
			{
				marblePile = n.computerTurn();
				if (marblePile == 1)
				{
					System.out.println("You lost! There is only " + marblePile + " marble left");
					break;
				}
				if (marblePile > 1)
				{
					System.out.println("There are now " + marblePile + " marbles after the computer's turn.");
					marblePile = n.playerTurn();
				}
				if (marblePile == 1)
				{
					System.out.println("You win! Congrats! There is only 1 marble left!");
					break;
				}
			}
		}
		// Computer has it's turn first if whoIsFirst is 1
		else 
		{
			System.out.println("Computer plays first!");
			marblePile = n.computerTurn();
			System.out.println("There are now " + marblePile + " marbles.");
			while (marblePile != 1)
			{
				marblePile = n.playerTurn();
				if (marblePile == 1)
				{
					System.out.println("You win! Congrats! There is only 1 marble left!");
					break;
				}
				if (marblePile > 1)
				{
					marblePile = n.computerTurn();
					System.out.println("There are now " + marblePile + " marbles after the computer's turn.");
				}
				if (marblePile == 1)
				{
					System.out.println("You lost! There is only " + marblePile + " marble left");
					break;
				}
			}
		}
	}
	// Method for the player's turn
	public int playerTurn()
	{
		int marblesLeft = 0;
		
		// Proofing for correct user input
		boolean status = true;
		while (status == true)
		{
			// Ask for user's amount of marbles
			Scanner taken = new Scanner(System.in);
			System.out.println("How many marbles are you going to take from the pile?");
			int marblesPTaking = taken.nextInt();
			if ((marblesPTaking < marblePile) && (marblesPTaking >= 1) && (marblesPTaking <= (marblePile/2)))
			{
				status = false;
			}
			else
			{
				System.out.println("That is not a valid amount, try again");
			}
			marblesLeft = marblePile - marblesPTaking;
		}
		
		return marblesLeft;
	}
	
	// Method for the computer's turn
	public int computerTurn()
	{
		int marblesCTaking = 0;
		int marblesLeft = 0;
		int[] powers = new int[] {2,4,8,16,32,64,101};
		
		// If smart
		if (smartOrStupid == 0)
		{
			System.out.println("Computer is playing smart mode.");
			for (int y = 0; y < powers.length - 1; y++)
			{
				if (marblePile == (powers[y] - 1))
				{
					marblesCTaking = number.nextInt((marblePile/2)-1)+1;
				}
				else if (marblePile == powers[y])
				{
					marblesCTaking = 1;
				}
				else if ((marblePile > powers[y]) && (marblePile < powers[y+1]))
				{
					marblesCTaking = (marblePile - powers[y]) + 1;
				}
			}
		}
		// If stupid
		else
		{
			System.out.println("Computer is playing stupid mode.");
			if (marblePile <= 3)
			{
				marblesCTaking = 1;
			}
			else
			{
			marblesCTaking = number.nextInt((marblePile/2)-1)+1;
			}
		}
		marblesLeft = marblePile - marblesCTaking;
		return marblesLeft; 
	}
}

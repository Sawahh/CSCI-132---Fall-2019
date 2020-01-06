import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{        
		LinkedList list;
		
		// Get the input file from the user
		Scanner input = null;
		input = new Scanner(System.in);
		System.out.println("Name of valid input file: ");
		String filePath = input.nextLine(); 
		File fin;
		fin = new File(filePath);
		
		// Try and catch in case of user error
		try
		{
			input = new Scanner(fin);
		} 
		catch(Exception e)
		{
			System.out.println("Usage: Need file input name");
			System.out.println(e);
		}

		// Create output file
		File fout;
		fout = new File("LinkedListProgram.txt");
		// Try and catch in case of error of creating file
		try
		{
			fout.createNewFile();
		}
		catch(IOException e)
		{
			System.out.println("Failed to create file");
			System.out.println(e);
		}

		// Try and catch in case of error in finding file
		PrintWriter textOut = null;
		try
		{
			textOut = new PrintWriter(fout);	
		}
		catch(Exception e)
		{
			System.out.println("File not found");
			System.out.println(e);
		}

		// Return output into output file
		textOut.println("Program 4");
		textOut.println("---------");
		
		// use data to print out with loop
		
		// Move pointers as long as there is another line in the input file
		while(input.hasNext()) 
		{
			ArrayList<String> Output = new ArrayList<String>();
			int N = input.nextInt();
			int k = input.nextInt();
			int m = input.nextInt();
			if (N == 0)
			{
				break;
			}
			list = new LinkedList();

			textOut.println("N = " + N + ", k = " + k + ", m = " + m);
			for (int i = 0; i < N; i++)
			{
				list.add(new Node(i+1));
			}
			textOut.println("Output");
			textOut.println("------");

			Output = list.movePointer(k, m);

			for (int i=0; i<Output.size(); i++)
			{
				textOut.println(Output.get(i));
			}
		}

		textOut.close();
		input.close();
		
		
	}
}

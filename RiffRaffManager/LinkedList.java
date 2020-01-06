import java.util.ArrayList;

public class LinkedList 
{
	// Fields
	private Node first;
	
	// Constructor
	public LinkedList()
	{
		first = null;
	}
	
	// Methods 
	
	// Method to find length of list
	public int listLength (Node current)
	{
		if (first == null) {return 0;}
		if (current == first.getPrevious()) {return 1;}
		else {return (listLength(current.getNext()) + 1);}
		/*
		if (first == null)
		{
			return 0;
		}
		int count = 1;
		Node start;
		start = first.getNext();
		while (start != first)
		{
			count ++;
			start = start.getNext();
		}
		return count;
		*/
	}
	
	// Method to add node(s)
	public void add (Node data)
	{
		if(first == null)
        {
            first = data;
            data.setNext(data);
            data.setPrevious(data);
        }
		
		else
		{
	        Node before = first.getPrevious();
	        Node after = first;
	        
	        before.setNext(data);
	        after.setPrevious(data);
	        data.setNext(after);
	        data.setPrevious(before);
		}
	}
	
	// Method to remove node(s)
	public void remove (Node data)
	{
		data.getPrevious().setNext(data.getNext());
		data.getNext().setPrevious(data.getPrevious());
		
		if (data == first)
		{
			first = first.getNext();
		}
		if (listLength(first) == 1)
		{
			first = null;
		}
	}
	
	// Method to move the pointers
	public ArrayList<String> movePointer(int distancek, int distancem)
	{	
		ArrayList<String> Output = new ArrayList<String>(); // ArrayList to print out at the end to the output file
		Node nodek = first;
		Node nodem = first.getPrevious();
		while (listLength(first) != 0)
		{
			// Move k pointer
			for (int i=0; i<distancek-1; i++)
			{
				nodek = nodek.getNext();
			}
			// Move m pointer
			for (int i=0; i<distancem-1; i++)
			{
				nodem = nodem.getPrevious();
			}
			// Check if pointers are pointing at same node
			if (nodek.getData() == nodem.getData())
			{
				Output.add("" + nodek.getData());
				remove(nodek);
				nodek = nodek.getNext();
				nodem = nodem.getPrevious();
			}
			// Otherwise pointers are not pointing to same node
			else
			{
				Output.add(nodek.getData() + " " + nodem.getData());
				remove(nodek);
				remove(nodem);
				nodek = nodek.getNext();
				// If statement so that k pointer does not get lost
				if (nodek.getData() == nodem.getData())
				{
					nodek = nodek.getNext();
				}
				nodem = nodem.getPrevious();
			}
		}
		return Output;
	}
}


public class Node 
{
	// Field
	private int data;
	private Node next;
	private Node previous;
	
	// Constructor
	public Node(int d) 
	{
		this.data = d;
	}
	
	// Methods
	public int getData()
	{
		return this.data;
	}
	
	public Node getNext()
	{
		return this.next;
	}
	
	public void setNext(Node temp)
	{
		this.next = temp;
	}
	
	public Node getPrevious()
	{
		return this.previous;
	}
	
	public void setPrevious(Node temp)
	{
		this.previous = temp;
	}
}

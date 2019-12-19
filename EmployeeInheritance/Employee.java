
abstract class Employee 
{
	// Instance variables
	protected int id;
	protected String first;
	protected String last;
	String type;
	
	// Constructor
	public Employee(String name1, String name2, int num, String t)
	{
		first = name1;
		last = name2;
		id = num;
		type = t;
	}
	
	// Methods for get and set and to String
	protected String getFirst() {return first;}
	
	protected String getLast() {return last;}
	
	public String getType() {return type;}
	
	public void setFirst(String newFirst) {first = newFirst;}
	
	public void setLast(String newLast) {last = newLast;}
		
	public abstract String toString();
	
}


public class Hourly extends Employee
{
	// Instance variables
	private int wage;
	private int hours;
	
	// Constructor
	public Hourly(String fname, String lname, int Id, int pay, int time)
	{
		super(fname,lname,Id, "H");
		wage = pay;
		hours = time;
	}
	
	// Methods to get and set and send to string
	private int getWage() {return wage;}
	
	private int getHours() {return hours;}
	
	public void setWage(int newPay) {wage = newPay;}
	
	public void setHours(int newHours) {hours = newHours;}
	
	public String toString()
	{
		String line = ("First: " + first + " Last: " + last + " ID: " + id + "\nWage: " + wage + " Hours: " + hours);
		return line;
	}
	
}

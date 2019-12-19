
public class Commission extends Employee
{
	// Instance variables
	protected int commRate;
	protected int grossSales;
	
	// Constructors
	public Commission(String fname, String lname, int Id, int rate, int sales)
	{
		super(fname,lname,Id, "C");
		commRate = rate;
		grossSales = sales;
	}
	
	public Commission(String fname, String lname, int id, String t) 
	{
		super(fname,lname,id,t);
	}
	
	// Methods for get and set and send to string
	private int getCommRate() {return commRate;}
	
	int getGrossSales() {return grossSales;}
	
	public void setCommRate(int newCommRate) {commRate = newCommRate;}
	
	public void setGrossSales(int newGrossSales) {grossSales = newGrossSales;} 
	
	public void addGrossSales(int addedSale) {grossSales += addedSale;}
	
	public String toString()
	{
		String line = ("First: " + first + " Last: " + last + " ID: " + id + "\nCommission Rate: " + commRate + " Gross Sales: " + grossSales);
		return line;
	}
}

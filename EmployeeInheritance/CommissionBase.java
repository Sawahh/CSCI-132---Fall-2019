
public class CommissionBase extends Commission
{
	// Instance variable
	private int baseSalary;
	
	// Constructor
	public CommissionBase(String fname, String lname, int Id, int rate, int sales, int salary)
	{
		super(fname, lname, Id, "CB");
		baseSalary = salary;
		commRate = rate;
		grossSales = sales;
	}
	
	// Methods to get and set and send to string
	private int getBaseSalary() {return baseSalary;}
	
	public void setBaseSalary(int newBaseSalary) {baseSalary = newBaseSalary;} 
	
	public String toString()
	{
		String line = ("First: " + first + " Last: " + last + " ID: " + id + "\nCommission Rate: " + commRate + " Gross Sales: " + grossSales +"\nBase Salary: " + baseSalary);
		return line;
	}
}

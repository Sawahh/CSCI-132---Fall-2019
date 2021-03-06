import java.util.HashMap;
import java.util.Scanner;

public class Driver 
{
	// Instance field for HashMap to store all employees
	static HashMap<Integer, Employee> storage = new HashMap<Integer, Employee>();
	
	// Main method that calls the menu that runs the program
	public static void main(String[] args)
	{
		menu();		
	}
	
	// Methods used to run program
	public static void menu()
	{
		Scanner userChoice = new Scanner(System.in);
		// do while loop for continuing the program or closing it
		do {
			System.out.println("Welcome! Enter the number to the choice you would like to do: ");
			System.out.println("1. Add Employee\n2. Edit Employee\n3. Add new Sales Totals\n4. Get Sales Report\n5. Exit");
			// switch to do different methods based on user input
			switch (userChoice.nextInt())
			{
				case 1:
					addEmployee(userChoice);
					break;
				case 2:
					editEmployee();
					break;
				case 3:
					newSalesTotals();
					break;
				case 4: 
					salesReport();
					break;
				case 5:
					System.exit(0);
				default:
					// Incorrect input check
					System.out.println("Incorrect input, try again.");
			}
		} while(true);
		
	}
	
	// Adds up the gross sales and prints it
	private static void salesReport() 
	{
		int sum = 0;
		for (Employee i : storage.values())
		{
			if (!(i.getType().equals("H")))
			{
				sum += ((Commission)i).getGrossSales();
			}
		}
		System.out.println("Here is your Sales Report: "+sum);
	}

	// Adds a sale to an employee's gross sales
	private static void newSalesTotals() 
	{
		int id;
		int newSales;
		int sales;
		Scanner manager = new Scanner(System.in);
		System.out.println("Enter the ID of the employee you would like to add sales to: ");
		id = manager.nextInt();
		System.out.println("Enter the amount you would like to add: ");
		newSales = manager.nextInt();
		((Commission)storage.get(id)).addGrossSales(newSales);
		System.out.println(storage.get(id));
	}

	// Change different set values to an employee
	private static void editEmployee() 
	{
		int type;
		int num;
		Scanner choiceEmp = new Scanner(System.in);
		// Find out what class needs to be accessed
		System.out.println("Is this employee 1. Hourly 2. Commission 3. Commission Base");
		type = choiceEmp.nextInt();
		// Get ID for access to specific employee
		System.out.println("Please enter the ID number of the employee you would like to edit");
		num = choiceEmp.nextInt();
		int edit;
		Scanner edited = new Scanner(System.in);
		Scanner change = new Scanner(System.in);
		// First switch for specific types of employees
		switch(type)
		{
			case 1: // Hourly Employee edits
				System.out.println("What would you like to edit?");
				System.out.println("1.First Name\n2.Last Name\n3.Wage\n4.Hours");
				edit = edited.nextInt();
				// Second switch for specifics within the class
				switch(edit)
				{
					// Change first name
					case 1:
						System.out.println("Enter new first name: ");
						String newFirst = change.nextLine();
						storage.get(num).setFirst(newFirst);
						break;
					// Change last name
					case 2:
						System.out.println("Enter new last name: ");
						String newLast = change.nextLine();
						storage.get(num).setLast(newLast);
						break;
					// Change wage
					case 3:
						System.out.println("Enter new wage: ");
						int newWage = change.nextInt();
						((Hourly)storage.get(num)).setWage(newWage);
						System.out.println(storage.get(num));
						break;
					// Change hours worked
					case 4:
						System.out.println("Enter new hours: ");
						int newHours = change.nextInt();
						((Hourly)storage.get(num)).setHours(newHours);
						System.out.println(storage.get(num));
						break;
					// In case of incorrect input
					default:
						System.out.println("Incorrect input, try again.");
						editEmployee();
				}
				break;
			case 2: // Commission Employee edits
				System.out.println("What would you like to edit?");
				System.out.println("1.First Name\n2.Last Name\n3.Commission Rate\n4.Gross Sales");
				edit = edited.nextInt();
				// Second switch for specifics within the class
				switch(edit)
				{
				// Change first name
				case 1:
					System.out.println("Enter new first name: ");
					String newFirst = change.nextLine();
					storage.get(num).setFirst(newFirst);
					break;
				// Change last name
				case 2:
					System.out.println("Enter new last name: ");
					String newLast = change.nextLine();
					storage.get(num).setLast(newLast);
					break;
				// Change commission rate
				case 3:
					System.out.println("Enter new commission rate: ");
					int newRate = change.nextInt();
					((Commission)storage.get(num)).setCommRate(newRate);
					break;
				// Change gross sales
				case 4:
					System.out.println("Enter new gross sales: ");
					int newGross = change.nextInt();
					((Commission)storage.get(num)).setGrossSales(newGross);
					break;
				// In case of wrong input
				default:
					System.out.println("Incorrect input, try again.");
					editEmployee();
				}
				break;
			case 3: // Commission Base Employee edits
				System.out.println("What would you like to edit?");
				System.out.println("1.First Name\n2.Last Name\n3.Base Salary\n4.Commission Rate\n5.Gross Sales");
				edit = edited.nextInt();
				// Second switch for specifics within the class
				switch(edit)
				{
					// Change first name
					case 1:
						System.out.println("Enter new first name: ");
						String newFirst = change.nextLine();
						storage.get(num).setFirst(newFirst);
						break;
					// Change last name
					case 2:
						System.out.println("Enter new last name: ");
						String newLast = change.nextLine();
						storage.get(num).setLast(newLast);
						break;
					// Change base salary
					case 3:
						System.out.println("Enter new base salary: ");
						int newSal = change.nextInt();
						((CommissionBase)storage.get(num)).setBaseSalary(newSal);
						break;
					// Change commission rate
					case 4:
						System.out.println("Enter new commission rate: ");
						int newRate = change.nextInt();
						((Commission)storage.get(num)).setCommRate(newRate);
						break;
					// Change gross sales
					case 5:
						System.out.println("Enter new gross sales: ");
						int newGross = change.nextInt();
						((Commission)storage.get(num)).setGrossSales(newGross);
						break;
					// In case of bad input
					default:
						System.out.println("Incorrect input, try again.");
						editEmployee();
				}
				break;
		}
		System.out.println(storage.get(num));
	}

	// Add an employee to the HashMaps storage
	public static void addEmployee(Scanner userChoice)
	{
		Scanner choiceEmp = new Scanner(System.in);
		String fname;
		String lname;
		int id;
		int choice;
		System.out.println("Here is a menu of employees: ");
		System.out.println("1. Hourly Employee \n2. Commission Employee \n3. Commission Base Employee" );
		System.out.println("Choose a corresponding number to the employee you would like to create");
		choice = userChoice.nextInt();
		// Switch for type of employee
		switch(choice)
		{
			case 1:
				System.out.println("Enter first name: ");
				fname = choiceEmp.nextLine();
				System.out.println("Enter last name: ");
				lname = choiceEmp.nextLine();
				System.out.println("Enter ID number: ");
				id = choiceEmp.nextInt();
				System.out.println("Enter wage: ");
				int wage = choiceEmp.nextInt();
				System.out.println("Enter hours worked: ");
				int hours = choiceEmp.nextInt();
				storage.put(id, new Hourly(fname, lname, id, wage, hours));
				System.out.println("New hourly employee:");
				System.out.println(storage.get(id));
				break;
			case 2:
				System.out.println("Enter first name: ");
				fname = choiceEmp.nextLine();
				System.out.println("Enter last name: ");
				lname = choiceEmp.nextLine();
				System.out.println("Enter ID number: ");
				id = choiceEmp.nextInt();
				System.out.println("Enter commission rate: ");
				int rate = choiceEmp.nextInt();
				System.out.println("Enter gross sales: ");
				int sales = choiceEmp.nextInt();
				storage.put(id, new Commission(fname, lname, id, rate, sales));
				System.out.println("New commission employee:");
				System.out.println(storage.get(id));
				break;
			case 3:
				System.out.println("Enter first name: ");
				fname = choiceEmp.nextLine();
				System.out.println("Enter last name: ");
				lname = choiceEmp.nextLine();
				System.out.println("Enter ID number: ");
				id = choiceEmp.nextInt();
				System.out.println("Enter commission rate: ");
				int commBaseRate = choiceEmp.nextInt();
				System.out.println("Enter gross sales: ");
				int commBaseSales = choiceEmp.nextInt();
				System.out.println("Enter base salary: ");
				int baseSalary = choiceEmp.nextInt();
				storage.put(id, new CommissionBase(fname, lname, id, commBaseRate, commBaseSales, baseSalary));
				System.out.println("New commission base employee:");
				System.out.println(storage.get(id));
				break;
			// Check for good input
			default:
				System.out.println("Incorrect input try again.");
				addEmployee(userChoice);
		}
		
	}

}

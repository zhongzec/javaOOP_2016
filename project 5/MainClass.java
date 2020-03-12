//George Koutsogiannakis
package Client;
import java.util.*;
import Client.Services.Enums.Help.*;
import Client.Services.*;
public class  MainClass
{
	public static void main(String[] args) 
	{
		AllExpenses exp=new AllExpenses();
		ArrayList<Worker> l=exp.listOfWorkers();
		System.out.println("FROM THE INVOCATIONS IN MAIN CLASS");
		exp.displayData(l);
		exp.createExpenses();
		System.out.println("BACK TO MAIN CLASS");
		System.out.println("The total salaries paid is:"+" "+exp.totalBenefits());
		System.out.println("The total recurring expenses is:"+" "+exp.getRecurringExpenses());
		System.out.println("The sum of all benefits and recurring expenses is:"+" "+exp.getTotalExpenses());
	}
}

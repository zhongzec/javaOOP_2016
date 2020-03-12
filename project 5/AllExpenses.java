//George Koutsogiannakis
package Client.Services.Enums.Help;
import Client.*;

public class AllExpenses extends WorkerBenefits implements ExpenseInterface 
{
	public void createExpenses()
	{
		ExpenseImpl ex1=new ExpenseImpl();
		System.out.println("FROM THE ALLEXPENSES CLASS");
		ex1.createExpenses();
	}
	
	public double getRecurringExpenses()
	{
		ExpenseImpl ex=new ExpenseImpl();
		
		return ex.totalRecurringExpenses();

	}
	public double getTotalExpenses()
	{
		double total=totalBenefits()+getRecurringExpenses();
		return total;
	}
}

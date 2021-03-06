//George Koutsogiannakis
package Client.Services.Enums.Help;
import Client.Services.*;
public class RecurringExpenses extends Rent implements UtilityCostsInterface, MaterialCostsInterface 
{	
	public double getUtilityExpenses()
	{
		UtilImpl r=new UtilImpl();
		return r.getUtilityExpenses();
	}

	public double getMaterialExpenses()
	{
		MaterialImpl m=new MaterialImpl();
		return m.getMaterialExpenses();
	}

	public void createExpenses()
	{
		UtilityCosts u1=new UtilityCosts(100.00, 100.00, 100.00);
	
		System.out.println("The firts utility object has:"+" "+ u1.totalUtil());
		UtilityCosts u2=new UtilityCosts(150.00, 150.00, 150.00);
		System.out.println("The second utility object  has:"+" "+u2.totalUtil());

		Rent r1=new Rent("2", 3, 4);
		System.out.println("The first rent object has:"+" "+r1.rent());
		Rent r2=new Rent("4", 1, 1);
		System.out.println("The second rent object has:"+" "+r2.rent());
		Material m1=new Material("Paper", 3.0, 1000);
		System.out.println("The first Material object has:"+" "+m1.materialPrice());
		Material m2=new Material("Ink", 2.0, 200);
		System.out.println("The second Material object has:"+" "+m2.materialPrice());
	}

	public double totalRecurringExpenses()
	{
		
       // UtilImpl r2=new UtilImpl();
		//MaterialImpl m2=new MaterialImpl();
		double total=getRent()+getUtilityExpenses()+getMaterialExpenses();
		System.out.println("The total operating expenses are:"+total);
		return total;
	}
}

//George Koutsogiannakis
package Client;
import Client.Services.*;
import Client.Services.Enums.*;
import java.util.*;
import java.io.*;
public class WorkerBenefits  
{
	public ArrayList<Worker> listOfWorkers()
	{

		ArrayList<Worker> al=new ArrayList<Worker>();
		Jobs et=null;
		try
		{
		   File file=new File("worker.txt");
		   Scanner scan=new Scanner(file);
		   while(scan.hasNextLine())
		   {
				String line=scan.nextLine();
				StringTokenizer strtok=new StringTokenizer(line, ",");
				String emp=strtok.nextToken();
				if(emp.equals("ELECTRICAL_ENGINEER")||emp.equals("MECHANICAL_ENGINEER"))
				{
					if(emp.equals("ELECTRICAL_ENGINEER"))
						et=Jobs.ELECTRICAL_ENGINEER;
					else
						et=Jobs.MECHANICAL_ENGINEER;
					String name=strtok.nextToken();
					String ssstr=strtok.nextToken();
					int ss=Integer.parseInt(ssstr);
					String yestr=strtok.nextToken();
					int ye=Integer.parseInt(yestr);
					String wsstr=strtok.nextToken();
					double ws=Double.parseDouble(wsstr);
					
					Engineer eng=new Engineer(name,ss,ye,et,ws);
					al.add(eng);
				}
				else if(emp.equals("ENGINEERING_MANAGER")||emp.equals("ADMINISTRATIVE_MANAGER"))
				{
					
					if(emp.equals("ENGINEERING_MANAGER"))
						et=Jobs.ENGINEERING_MANAGER;
					else
						et=Jobs.ADMINISTRATIVE_MANAGER;
					String name=strtok.nextToken();
					String ssstr=strtok.nextToken();
					int ss=Integer.parseInt(ssstr);
					String years=strtok.nextToken();
					int yearsi=Integer.parseInt(years);
					String wsstr=strtok.nextToken();
					double ws=Double.parseDouble(wsstr);
					String bonusstr=strtok.nextToken();
					double bonus=Double.parseDouble(bonusstr);
					Management man=new Management(name,ss,yearsi,et,ws,bonus);
					al.add(man);

				}
				else if(emp.equals("ADMINISTRATIVE_SECRETARY")||emp.equals("ADMINISTRATIVE_ASSISTANT"))
				{
					if(emp.equals("ADMINISTRATIVE_SECRETARY"))
						et=Jobs.ADMINISTRATIVE_SECRETARY;
					else
						et=Jobs.ADMINISTRATIVE_ASSISTANT;
					String name=strtok.nextToken();
					String ssstr=strtok.nextToken();
					int ss=Integer.parseInt(ssstr);
					String years=strtok.nextToken();
					int yearsi=Integer.parseInt(years);
					String ratestr=strtok.nextToken();
					double rate=Double.parseDouble(ratestr);
					String hoursstr=strtok.nextToken();
					double hours=Double.parseDouble(hoursstr);
					AdministrativePersonnel adminp=new AdministrativePersonnel(name,ss,yearsi,et,rate,hours);
					al.add(adminp);

				}
			  }//end of while loop
			}
			catch(IOException ioe)
			{
				System.out.println("Something is wrong");
			}
		
		return al;

	}

	public void displayData(ArrayList<Worker> ale)
	{
		
		for(Worker e: ale)
		{
			
			double sal=e.benefitsCalculation(e.getJobs());
			String name=e.getName();
			int id=e.getCurrentID();
			Jobs et=e.getJobs();
			System.out.println("The benefit is"+" "+sal+" "+
			"The name is:"+" "+name+" "+" "+"The Job type type is"+" "+
				et+" "+"The id is:"+" "+id);
			
		}
		
	}

	
	public static void main(String[] args)
	{
		WorkerBenefits pay=new WorkerBenefits();
		ArrayList<Worker> arl=pay.listOfWorkers();
		pay.displayData(arl);
		
	}
		

}

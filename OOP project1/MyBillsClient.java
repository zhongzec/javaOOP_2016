//George koutsogiannakis

package Client;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import Client.Services.BillsType;
import Client.Services.Classes.MyBills;
public class MyBillsClient
{
	
	public static void main(String[] args) 
	{
		NumberFormat form=NumberFormat.getCurrencyInstance();
	
		
		MyBills [] exparray=null;
		int count=0;
		int countDays=0;
		String mon=" ";
		BillsType expenseType=null;
		String lineNum=" ";
		double [] numarray=null;
		int index=0;
		int objectarrayindex=-1;
		
		
		try
		{
			File file=new File("myexpenses.txt");
			Scanner scan=new Scanner(file);
			
		    // Need to find out how many Expense objects need to be created
			//The array exparray will have its size determined by counting only the 
			//headers for all expenses in all months. The reason is that there are going to be as many
			//MyBills objects as there are ExpenseTypes in the data file for all months listed.
			
			while (scan.hasNextLine())
			{
				
				String line=scan.nextLine();
				StringTokenizer stk=new StringTokenizer(line, ":");
				if(stk.nextToken().equals("MONTH"))
				{
				
				    count++;
				}
			}
			exparray=new MyBills[count];
			

			//Now, let us create another scanner object go through the text file this time and create MyBills objects
			// and sav ethem into the array of MyBills objects data type.
			
			
			Scanner scan1=new Scanner(file);
			
			while(scan1.hasNextLine())
			{
				String line=scan1.nextLine();
				
				if(line.charAt(0)=='M')
				{
					
					StringTokenizer strtok=new StringTokenizer(line, ":");
					//get the month name and the type of expense
				
					strtok.nextToken();
					mon=strtok.nextToken();
				    strtok.nextToken();
					expenseType=BillsType.valueOf(strtok.nextToken());
					objectarrayindex++;
				}
				else
				{ 

					 //Now, let us get the nextt line which the numbers for the expense found
					 
					 
					 StringTokenizer strtok1=new StringTokenizer(line, ",");
					
					 countDays=strtok1.countTokens();
					
					 numarray=new double[countDays];
					 index=0;
					 while(strtok1.hasMoreTokens())
					 {
						 numarray[index]=Double.parseDouble(strtok1.nextToken());
							 index++;
					 }

					  //Now we have all the information we need to create a MyBills object

					MyBills e=new MyBills(mon, expenseType, numarray, countDays);
					//enter the object into the array exparray

				    exparray[objectarrayindex]=e;
				 }

				
					
			    
				
				 

				

				

			}//end of while loop	
			
		
		}// end of try
		catch(IOException ioe)
		{ 
			System.out.println("Something is wrong with the text file");
		}

		System.out.println("________________OUTPUT # 1_________________");
		for(int f=0; f<=exparray.length-1; f++)
			System.out.println(exparray[f]);

		System.out.println("________________OUTPUT # 2_________________");
		MyBillsClient expcl=new MyBillsClient();
		String[] monthlyexpe=expcl.totalExpensesPerMonth(exparray);
		for(int e=0; e<=monthlyexpe.length-1; e++)
			System.out.println(monthlyexpe[e]);
	}

	public String[] totalExpensesPerMonth(MyBills[] expe)
	{
		NumberFormat form=NumberFormat.getCurrencyInstance();
	
		
	  
	  //Discover how many months are involved in the present data in order to set teh size of the array forthe totals.
	  
		String[] totalpermonth=null;;
		MyBills[] expenew=new MyBills[expe.length];
		for(int a=0; a<=expe.length-1; a++)
			expenew[a]=expe[a];
		
		double sum=0;
		double sumj=0;
		double sumf=0;
		double summ=0;
		double suma=0;
		double summay=0;
		double sumjune=0;
		double sumju=0;
		double sumau=0;
		double sums=0;
		double sumo=0;
		double sumn=0;
		double sumd=0;
		//For each month calculate the total expenses
		int countmonths=0;
		for(int i=0; i<=expenew.length-1; i++)
		{
			//get the month
			String m=expenew[i].getMonth();
			
			if(m.equals("JANUARY"))
			{
				//get the sum of the expenses for that month
			
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				
				sumj=sumj+sum;
				
				sum=0;
				if(countmonths==0)
				  countmonths++;
			}
			else if(m.equals("FEBRUARY"))
			{
			
				
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				sumf=sumf+sum;
				sum=0;
				if(countmonths==1)
				  countmonths++;
			}
			else if(m.equals("MARCH"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				summ=summ+sum;
				sum=0;
				if(countmonths==2)
				  countmonths++;
			}
			else if(m.equals("APRIL"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				suma=suma+sum;
				sum=0;
				if(countmonths==3)
				    countmonths++;
			}
			else if(m.equals("MAY"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				summay=summay+sum;
				sum=0;
				if(countmonths==4)
				   countmonths++;
			}
			else if(m.equals("JUNE"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				sumjune=sumjune+sum;
				sum=0;
				if(countmonths==5)
				   countmonths++;
			}
			else if(m.equals("JULY"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				sumju=sumju+sum;
				sumju=0;
				if(countmonths==6)
				   countmonths++;
			}
			else if(m.equals("AUGUST"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				sumau=sumau+sum;
				sum=0;
				if(countmonths==7)
				  countmonths++;
			}
			else if(m.equals("SEPTEMBER"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				sums=sums+sum;
				sums=0;
				if(countmonths==8)
				  countmonths++;
			}
			else if(m.equals("OCTOBER"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				sumo=sumo+sum;
				sum=0;
				if(countmonths==9)
				  countmonths++;
			}
			else if(m.equals("NOVEMBER"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				sumn=sumn+sum;
				sum=0;
				if(countmonths==10)
				  countmonths++;
			}
			else if(m.equals("DECEMBER"))
			{
				double[] am=expenew[i].getAmount();
				for(int f=0; f<=am.length-1; f++)
					sum=sum+am[f];
				sumd=sumd+sum;
				sum=0;
				if(countmonths==11)
				   countmonths++;
			}
		}
		
       //System.out.println(countmonths);
		totalpermonth=new String[countmonths];
        for(int j=0; j<totalpermonth.length; j++)
		{
				if(j==0)
			    {
						String avj=form.format(sumj);
						String str1="The total of all the expenses for the month of January is:"+" "+avj;
						totalpermonth[0]=str1;
				}	
				else if(j==1)
				{
					String avf=form.format(sumf);
					String str2="The total of all the expenses for the month of February is:"+" "+avf;
					totalpermonth[1]=str2;
				}
				else if(j==2)
				{
					String avm=form.format(summ);
					String str3="The total of all the expenses for the month of March is:"+" "+avm;
					totalpermonth[2]=str3;
				}
				else if(j==3)
				{	
					String ava=form.format(suma);
					String str4="The total of all the expenses for the month of April is:"+" "+ava;
					totalpermonth[3]=str4;
				}
				else if(j==4)
				{
					String avmay=form.format(summay);
					String str4="The total of all the expenses for the month of May is:"+" "+avmay;
					totalpermonth[4]=str4;
				}
				else if(j==5)
			    {
					String avjune=form.format(sumjune);
					String str4="The total of all the expenses for the month of June is:"+" "+avjune;
					totalpermonth[5]=str4;
				}
				else if(j==6)
			    {
					String avjuly=form.format(sumju);
					String str4="The total of all the expenses for the month of July is:"+" "+avjuly;
					totalpermonth[6]=str4;
				}
				else if(j==7)
			    {
					 
					String avaug=form.format(sumau);
					String str4="The total of all the expenses for the month of August is:"+" "+avaug;
					totalpermonth[7]=str4;
				}
				else if(j==8)
				{
					
					String avs=form.format(sums);
					String str4="The total of all the expenses for the month of September is:"+" "+avs;
					totalpermonth[8]=str4;
				}
				else if(j==9)
				{ 
						
					String avo=form.format(sumo);
					String str4="The total of all the expenses for the month of October is:"+" "+avo;
					totalpermonth[9]=str4;
				}
				else if(j==10)
			    {
					
					String avn=form.format(sumn);
					String str4="The total of all the expenses for the month of November is:"+" "+avn;
					totalpermonth[10]=str4;
				}
				else if(j==11)
			    {
					
					String avd=form.format(sumd);
					String str4="The total of all the expenses for the month of December is:"+" "+avd;
					totalpermonth[11]=str4;
				}
		}

		return totalpermonth;
	}
	
}

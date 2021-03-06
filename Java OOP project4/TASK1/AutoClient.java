//George Koutsogiannakis
package main;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.ArrayList;

//enter import statements for other needed classes
import main.service.*;
import main.service.enums.*;
public class AutoClient
{
	public static void main(String[] args) 
	{
		//Add code as you decide that itis required
		AutoClient vc=new AutoClient();
		System.out.println("-------------FIRST OUTPUT ----------------");
		
		// ADD CODE
		// transfer objects from array to array list
		//Get the Store information so that the AutoStore instance variable reference of Auto can be set to a specific AutoStore object 

		//Display contents of array list using the new for loop. Display the id of each Auto object, the sale price a sdefined in the AutoStore class and teh status (is it sold?-right now none is sold)
		Auto [] vobjs=vc.carData();
		
		ArrayList<Auto> arlcd=new ArrayList<Auto>();
		for(int i=0; i<vobjs.length; i++)
		{
			
			arlcd.add(vobjs[i]);
		}
		//Get the AutoStore information so that the AutoStore instance variable reference of Auto can be set to a specific AutoStore object 

		AutoStore [] dealers=storeData();

		for(int j=0; j<dealers.length; j++)
		{
			arlcd.get(j).setAutoStore(dealers[j]);
		}
		for(Auto cade: arlcd)
			System.out.println("The price of car with id= "+cade.getCurrentID()+" "+"is : "+cade.getAutoStore().getSale()+" "+"The sale status is: "+cade.getSold());
		
		
	System.out.println("-------------SECOND OUTPUT----------------");
	
		double[][][] s=vc.storeSales(arlcd);
		System.out.println("\n");
		System.out.println("\t"+"\t"+"MON"+"\t"+"\t"+"TUE"+"\t"+"\t"+"WED"+"\t"+"\t"+"THU"+"\t"+"\t"+"FRI"+"\t"+"\t"+"SAT");
		for(int i=0; i<=s.length-1; i++)
		{   if(i==0)
			{
			  System.out.println("\n");
			  System.out.print("ID1");
			  System.out.println("\n");
			}
			else if(i==1)
			{
				System.out.println("\n");
				System.out.print("ID2"+"\t");
				System.out.println("\n");
			}
			else if(i==2)
			{
				System.out.println("\n");
				System.out.print("ID3"+"\t");	
				System.out.println("\n");
			}
			else if(i==3)
			{
				System.out.println("\n");
			    System.out.print("ID4"+"\t");
				System.out.println("\n");
			}
			else if(i==4)
			{
				System.out.println("\n");
			    System.out.print("ID5"+"\t");
				System.out.println("\n");

			}
			for(int j=0; j<=s[i].length-1; j++)
			{	
				if(j==0)
				{
					System.out.print("week 1:"+"\t");
					
				}
				else if(j==1)
				{
					System.out.print("\n");
					System.out.print("week 2:"+"\t");
				}
				for(int k=0; k<=s[i][j].length-1; k++)
				{
					if(k==1||k==3||k==5)
					  System.out.print("\t"+"\t"+s[i][j][k]+"\t");
					else
					  System.out.print("\t"+s[i][j][k]);
				}
			}
		}
		System.out.println("\n");
		System.out.println("-------------THIRD OUTPUT----------------");
		ArrayList<Auto> sorted=vc.sortAutoList(arlcd);
	    for(Auto cade: sorted)
			System.out.println("The auto is"+" "+cade.toString()+" "+"The price of car with id= "+cade.getCurrentID()+" "+"The sale status is: "+cade.getSold());
	}
	

	///////////////END OF MAIN METHOD //////////////////////////////////////////

	public Auto[] carData()
	{
		
		Auto [] veharray=null;
		//double[] varray=null;
		//double[] darray=null;
		//double[] farray=null;
		int count=0;
		try
		{
			File file =new File("data.txt");
			Scanner scan=new Scanner(file);
			CarType vehe=null;
			while(scan.hasNextLine())
			{
				scan.nextLine();
				count++;
			}

			veharray=new Auto[count];
			//varray=new double[count];
			//darray=new double[count];
			//farray=new double[count];
			Scanner scan1=new Scanner(file);
			int index=0;
			while(scan1.hasNextLine())
			{
				String line=scan1.nextLine();
				StringTokenizer strtok=new StringTokenizer(line,"#");
				String tok1=strtok.nextToken();
				//System.out.println(tok1);
				double a=Double.parseDouble(tok1);
				String tok2=strtok.nextToken();
				//System.out.println(tok2);
				int t=Integer.parseInt(tok2);
				String tok3=strtok.nextToken();
				//System.out.println(tok3);
				String tok4=strtok.nextToken();
				//System.out.println(tok4);
				if(tok4.equals("Type1"))
				{
					
					vehe=CarType.Type1;
				}
				else if(tok4.equals("Type2"))
				{
					
					vehe=CarType.Type2;
				}
				else if(tok4.equals("Type3"))
				{
				   vehe=CarType.Type3;
				}
				else if(tok4.equals("Type4"))
				{
					vehe=CarType.Type4;
				}
				String tok5=strtok.nextToken();
				//System.out.println(tok5);
				String tok6=strtok.nextToken();
				//System.out.println(tok6);
				 
				Auto v=new Auto(a,t,tok3,vehe);
				
				veharray[index]=v;
				
				index++;
			}
		}//end of try
		catch(IOException ioe)
		{
		   System.out.println("Something is wrong");
		}
		return veharray;
	}

	public static AutoStore[] storeData()
	{
		AutoStore[] dealarray=null;
		Store d=null;
		int count=0;
		try
		{
			File file =new File("data.txt");
			Scanner scan=new Scanner(file);
			CarType vehe=null;
			while(scan.hasNextLine())
			{
				scan.nextLine();
				count++;
			}

			dealarray=new AutoStore[count];
			
			Scanner scan1=new Scanner(file);
			int index=0;
			while(scan1.hasNextLine())
			{
				//add code to capture the required data to create AutoStore objects and save them in an array.

				String line=scan1.nextLine();
				StringTokenizer strtok=new StringTokenizer(line,"#");
				strtok.nextToken();
				strtok.nextToken();
				strtok.nextToken();
				strtok.nextToken();
				String tok1=strtok.nextToken();
				
				String tok2=strtok.nextToken();
				double sal=Double.parseDouble(tok2);
				
				if(tok1.equals("ID1"))
				{
					
					d=Store.ID1;
				}
				else if(tok1.equals("ID2"))
				{
					
					d=Store.ID2;
				}
				else if(tok1.equals("ID3"))
				{
				   d=Store.ID3;
				}
				else if(tok1.equals("ID4"))
				{
					d=Store.ID4;
				}
				else if(tok1.equals("ID5"))
				{
					d=Store.ID5;
				}

				AutoStore cd=new AutoStore(sal);
				cd.setStore(d);
				dealarray[index]=cd;
		
				index++;
			}
		}
		catch(IOException ioe)
		{
		   System.out.println("Something is wrong");
		}
		
		
		return dealarray;
	}

	
	

	public ArrayList<Auto> sortAutoList(ArrayList<Auto> ald)
	{
		//ADD CODE TO SORT AN ARRAY LIST OF AUTO OBJECTS ACCOPRDING TO THE ACCELERATION AND RETURN THE SORTED ARRAY LIST OBJECT
		// MAKE SURE THAT THE ARGUMENT ARRAY LIST HAS FIRST BEEN TRANSFERRED TO A NEW ARRAY LIST OBJECT.
	
		ArrayList<Auto> list=new ArrayList<Auto>();
		for(int i=0; i<ald.size(); i++)
			list.add(ald.get(i));

        Auto  temp;
		int sublistlength=0;
		
		for (int j=0; j<=list.size()-1; j++ )
		{
			sublistlength=list.size()-j;
                  //find index of largest element in subarray
			int index=0;
			for (int k=1; k<sublistlength; k++)
			{   
				Auto obj=list.get(k);
				
				Auto obj1=list.get(index);
				
				
				double sale=obj.getAutoStore().getSale();
				
				double sale1=obj1.getAutoStore().getSale();
				if (sale> sale1)
				{
					index=k;					
				}
			}
			//swap code for the vector
			temp=list.get(index);
			
			list.set(index,list.get(list.size()-j-1));
			list.set(list.size()-j-1,temp);
			
		}

	return list;
		
	
	}

	

	public double[][][] storeSales(ArrayList<Auto> al)
	{


		// ADD CODE
		double[][][] sales=new double[5][2][6];
			double total=0.0;
			int countw1=0;
			int countw2=0;
			//i is dealers , j is weeks, h is days of week
			
			for(int i=0; i<=sales.length-1; i++)
			{
				for(int j=0; j<=sales[i].length-1; j++)
				{
					for(int h=0; h<=sales[i][j].length-1; h++)
					{
						//if oneDealer and day is M,W,or F
						if((i==0)&&(h==0||h==2||h==4))
						{
							
							if(j==0)
							{
								sales[i][j][h]=sales[i][j][h]+al.get(countw1).getAutoStore().getSale();
								al.get(countw1).setSold(true);
								//System.out.println(al.get(countw1).getCurrentID());
								countw1++;
								countw2=countw1;
							}
							else
							{
									
								
								sales[i][j][h]=sales[i][j][h]+al.get(countw2+12).getAutoStore().getSale();
								al.get(countw2+12).setSold(true);
								//System.out.println(al.get(countw2+12).getCurrentID());
								countw2++;
							}
						}
						//if twoDealer and day is T, TH or S
						else if((i==1)&&(h==1||h==3||h==5))
						{   
							//if week=1
							if(j==0)
							{
								
								sales[i][j][h]=sales[i][j][h]+al.get(countw1).getAutoStore().getSale();
								al.get(countw1).setSold(true);
								//System.out.println(al.get(countw1).getCurrentID());
								countw1++;
								countw2=countw1;
							}
							//else if week =2
							else
							{
								
								sales[i][j][h]=sales[i][j][h]+al.get(countw2+12).getAutoStore().getSale();
								al.get(countw2+12).setSold(true);
								//System.out.println(al.get(countw2+12).getCurrentID());
								countw2++;
							}
						}

						///if threeDealer and day =M,W or F
						else if((i==2)&&(h==0||h==2||h==4))
						{   
							//if week=1
							if(j==0)
							{
								sales[i][j][h]=sales[i][j][h]+al.get(countw1).getAutoStore().getSale();
								al.get(countw1).setSold(true);
								//System.out.println(al.get(countw1).getCurrentID());
								countw1++;
								countw2=countw1;
							}
							//else if week =2
							else
							{
								
								sales[i][j][h]=sales[i][j][h]+al.get(countw2+12).getAutoStore().getSale();
								al.get(countw2+12).setSold(true);
								//System.out.println(al.get(countw2+12).getCurrentID());
								countw2++;
							}
						}
						//if fourDealer and day=T,Th,S
						else if((i==3)&&(h==1||h==3||h==5))
						{   
							//if week=1
							if(j==0)
							{
								sales[i][j][h]=sales[i][j][h]+al.get(countw1).getAutoStore().getSale();
								al.get(countw1).setSold(true);
								//System.out.println(al.get(countw1).getCurrentID());
								countw1++;
								countw2=countw1;
							}
							//else if week =2
							else
							{
								
								sales[i][j][h]=sales[i][j][h]+al.get(countw2+12).getAutoStore().getSale();
								al.get(countw2+12).setSold(true);
								//System.out.println(al.get(countw2+12).getCurrentID());
								countw2++;
							}
						}
						//if five Dealer and Day=M,W,F
						else if((i==4)&&(h==0||h==2||h==4))
						{   
							//if week=1
							if(j==0)
							{
								sales[i][j][h]=sales[i][j][h]+al.get(countw1).getAutoStore().getSale();
								al.get(countw1).setSold(true);
								//System.out.println(al.get(countw1).getCurrentID());
								countw1++;
								countw2=countw1;
							}
							//else if week =2
							else
							{
								
								sales[i][j][h]=sales[i][j][h]+al.get(countw2+12).getAutoStore().getSale();
								al.get(countw2+12).setSold(true);
								//System.out.println(al.get(countw2+12).getCurrentID());
								countw2++;
							}
						}
						
						
					}
				}
			}
			return sales;
			

	}
}

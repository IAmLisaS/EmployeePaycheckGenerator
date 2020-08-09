// Lisa Sinn
// Intro to Java - CSCI 1146 
// CSCI 1146-241
// Final Project
// MyPay2.java


import java.util.*;
import java.io.*;

public class MyPay2
{
   public static void main (String[] args) throws FileNotFoundException
   {
       String[] firstName = new String[10];
       String[] lastName = new String[10];
       double[] hoursWorked = new double[10];
       double[] payRate = new double[10];
      
       //Method that process the input
       int cnt = 0;
      
       //Scanner class object
       Scanner reader = new Scanner(System.in);
      
       //Displaying menu
       while(true)
       {
           //Printing menu
           menu();
           System.out.print(" Your option: ");
           int opt = reader.nextInt();
          
           switch(opt)
           {  
               case 1:   cnt = processInput(firstName, lastName, hoursWorked, payRate); break;
               case 2:   consoleOutput(firstName, lastName, hoursWorked, payRate, cnt); break;
               case 3:   fileOutput(firstName, lastName, hoursWorked, payRate, cnt); break;
               case 4:   return;
               default: System.out.println("\n Invalid Option entered... \n");   break;
           }
       }
   }
  
   //Menu method
   public static void menu()
   {
       System.out.println("\n ***** MENU ***** \n 1-Read data from file \n 2-Print to console \n 3-Print to Output file \n 4-Exit \n");
   }
  
   //Method that process the input file
   public static int processInput(String[] firstName, String[] lastName, double[] hoursWorked, double[] payRate) throws FileNotFoundException
   {
       //Opening file for reading
       Scanner inFile = new Scanner (new FileReader("employee.txt"));
       int i=0;
      
       //Iterating over file
       while(inFile.hasNext())
       {
           //Reading data from file
           firstName[i] = inFile.next();
           lastName[i] = inFile.next();
           hoursWorked[i] = inFile.nextDouble();
           payRate[i] = inFile.nextDouble();          
           i++;
       }
       inFile.close();
      
       return i;
   }
  
   //Method that process the output to console
   public static void consoleOutput(String[] firstName, String[] lastName, double[] hoursWorked, double[] payRate, int cnt)
   {
       //Iterating over line by line
       for(int i=0; i<cnt; i++)
       {
           double wages = hoursWorked[i] * payRate[i];
           double taxAmount = wages * .05;
           double netAmount = wages - taxAmount;
           System.out.println("\nPaycheck for " + firstName[i] + lastName[i] + ". Hours worked = " + hoursWorked[i] + " at rate of $" + payRate[i] + ". Gross Amount = " + wages + " Tax Amount = " + taxAmount + " Total Pay = " + netAmount);
       }
   }
  
   //Method that process the output to file
   public static void fileOutput(String[] firstName, String[] lastName, double[] hoursWorked, double[] payRate, int cnt) throws FileNotFoundException
   {
       PrintWriter outFile = new PrintWriter("outpay.txt");
       //Iterating over line by line
       for(int i=0; i<cnt; i++)
       {
           double wages = hoursWorked[i] * payRate[i];
           double taxAmount = wages * .05;
           double netAmount = wages - taxAmount;
           outFile.println("\nPaycheck for " + firstName[i] + lastName[i] + ". Hours worked = " + hoursWorked[i] + " at rate of $" + payRate[i] + ". Gross Amount = " + wages + " Tax Amount = " + taxAmount + " Total Pay = " + netAmount);
       }
      
       outFile.close();
      
       System.out.println("\n Successfully written to file... \n");
   }
}
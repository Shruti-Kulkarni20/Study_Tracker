
///////////////////////////////////////////////////////////////////////////////////
/// 
///  Author      : Shruti Shrinivas Kulkarni.
///  File Name   : StudyTrackerStarter.java
///  Description : This is the main driver class for the Study Tracker application.
///                 It provides a menu for the user to:
///                  1. Insert a new study log.
///                  2. View all study logs.
///                  3. View summary of study logs by date.
///                  4. View summary of study logs by subject.
///                  5. Export study logs to a CSV file.
///                  6. Exit the application.
///
///  User input  : - Menu choice (1 to 6)
///                - Subject name
///                - Study duration (in hours)
///                - Study description
/// 
/////////////////////////////////////////////////////////////////////////////////////

package Study_Tracker;

import java.util.*;


public class StudyTrackerStarter
{
    public static void main(String A[]) 
    {
        try
        {
             StudyTracker stobj = new StudyTracker();

                Scanner ScanerObj = new Scanner(System.in);

                int iChoice = 0;

                System.out.println("---------------------------------------------------------------");   
                System.out.println("------------Welcome to Study Tracker Application---------------");   
                System.out.println("---------------------------------------------------------------");   

            do
            {
                System.out.println("Please select the appropriate option : ");
                System.out.println("1 : Insert new study log into database");
                System.out.println("2 : View all study logs");
                System.out.println("3 : Summary of Study log by date");
                System.out.println("4 : Summary of study log by subject");
                System.out.println("5 : Export Study Log to CSV file");
                System.out.println("6 : Exit the application");

                iChoice = ScanerObj.nextInt();
                ScanerObj.nextLine();

                switch(iChoice)
                {
                    case 1:       //Insert new study log into database
                        stobj.InsertLog(ScanerObj);
                        break;
                    case 2:       //View all study logs
                        stobj.DisplayLog();
                        break;
                    case 3:       //Summaery of study log by date
                        stobj.SummaryByDate();               
                        break;
                    case 4:       //summary of study log by subject
                        stobj.SummaryBySubject();
                        break;
                    case 5:       //Export study log to csv file
                        stobj.ExportCSV();
                        break;
                    case 6:       //Exit the application
                        System.out.println("---------------------------------------------------------------");   
                        System.out.println("------Thank you for using Study Tracker Application------------");   
                        System.out.println("---------------------------------------------------------------");
                        break;   
                    default:
                        System.out.println("Please enter a valid option");
                        break;
                }
            }while(iChoice != 6);

            ScanerObj.close();

        }
        catch(Exception e)
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    } 
}

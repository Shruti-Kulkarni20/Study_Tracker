//////////////////////////////////////////////////////////////////////////////////////
/// 
///  Author      : Shruti shrinivas kulkarni
///  File Name   : StudyTracker.java
///  Description : This class contains the core logic of the Study
///                 Tracker application. 
///                 It manages study records,
///                 performs data processing,
///                 and generates reports.
///  Constructors:
///       - StudyTracker() : Initializes the internal database (ArrayList of StudyLog)
///  Methods:
///       - void InsertLog()       : Takes user input and adds a new StudyLog to the database
///       - void DisplayLog()      : Displays all study logs
///       - void ExportCSV()       : Exports study logs to a CSV file
///       - void SummaryByDate()   : Displays total study hours grouped by date
///       - void SummaryBySubject(): Displays total study hours grouped by subject
///  User Input:
///       - Subject name (C, C++, Java, DS, etc.)
///       - Duration in hours
///       - Description for future reference
/// 
/////////////////////////////////////////////////////////////////////////////////////////



package Study_Tracker;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.*;


public class StudyTracker
{
    //Data structure to hold the data about study
    private ArrayList<StudyLog> Database = new ArrayList<StudyLog>();

    public void InsertLog(Scanner ScanerObj)
    {

        System.out.println("--------------------------------------------------------------");
        System.out.println("--------please enter the valid details of your study----------");
        System.out.println("--------------------------------------------------------------");

        LocalDate Dateobj = LocalDate.now();

        System.out.println("Please Provide the name of subject like C/C++/Java/DS :");
        String sub = ScanerObj.nextLine();

        System.out.println("Enter the time period of your study in hours : ");
        Double dur =ScanerObj.nextDouble();
        ScanerObj.nextLine();

        System.out.println("Please provide the description about study for future reference :");
        String desc = ScanerObj.nextLine();

        StudyLog StudyObj = new StudyLog(Dateobj, sub, dur, desc);

        Database.add(StudyObj);

        System.out.println("---------------------------------------------------------------");
        System.out.println("Study logs gets stored successfully");
        System.out.println("---------------------------------------------------------------");
    }

    public void DisplayLog()
    {
        System.out.println("---------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("---------------------------------------------------------------");
            System.out.println("------------Nothing to Display as database is empty------------");
            System.out.println("---------------------------------------------------------------");
            return;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("----------Log Report from Marvellous Study Tracker-------------");
        System.out.println("---------------------------------------------------------------");

        for(StudyLog sobj : Database)
        {
            System.out.println(sobj);
        }
        System.out.println("---------------------------------------------------------------");     
    }

    public void ExportCSV()
    {
        if(Database.isEmpty())
        {
            System.out.println("---------------------------------------------------------------");
            System.out.println("------------Nothing to Export  as database is empty------------");
            System.out.println("---------------------------------------------------------------");
            return;   
        }

        String FileName = "StudyTracker_Report.csv";

        //create new csv file
        try(FileWriter fwobj = new FileWriter(FileName))
        {
            //write CSV header
            fwobj.write("Date    |  Subject  |  Duration  |  Description\n");

            //Travel database
            for(StudyLog sobj : Database)
            {
                //write each record in CSV
                fwobj.write(sobj.getDate()+ " , "+
                            sobj.getSubject().replace(",", " ")+ " , "+
                            sobj.getDuration()+" ,- "+
                            sobj.getDescription().replace(",", " ")+"\n"
                           );
            }

            System.out.println("Log created successfully");
        }
        catch(Exception eobj)
        {
            System.out.println("Exception occured while creating the CSV");
            System.out.println("Report this issue to StudyTracker Application");
        }
    }

    public void SummaryByDate()
    {
        System.out.println("---------------------------------------------------------------"); 

        if(Database.isEmpty())
        {
            System.out.println("---------------------------------------------------------------");
            System.out.println("------------Nothing to Display as database is empty------------");
            System.out.println("---------------------------------------------------------------");
            return;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("--------------Summary By Date from StudyTracker ---------------");
        System.out.println("---------------------------------------------------------------");

        TreeMap <LocalDate,Double> tobj = new TreeMap<LocalDate,Double>();

        LocalDate lobj = null;
        double d,old;

        for(StudyLog sobj : Database)
        {
            lobj = sobj.getDate();
            d = sobj.getDuration();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);
                tobj.put(lobj,d+old);
            }
            else
            {
                tobj.put(lobj,d);
            }
        }
        //Display the details as per date
        for(LocalDate ldobj : tobj.keySet())
        {
            System.out.println("Date : "+lobj+" Total Study "+tobj.get(ldobj));
        }

        System.out.println("---------------------------------------------------------------"); 
    }

    public void SummaryBySubject()
    {
        System.out.println("---------------------------------------------------------------"); 

        if(Database.isEmpty())
        {
            System.out.println("---------------------------------------------------------------");
            System.out.println("------------Nothing to Display as database is empty------------");
            System.out.println("---------------------------------------------------------------");
            return;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("--------------Summary By Subject from StudyTracker ------------");
        System.out.println("---------------------------------------------------------------");

        TreeMap<String,Double>tobj = new TreeMap<String,Double>();

        double d , old;
        String s;

        for(StudyLog sobj : Database)
        {
            s = sobj.getSubject();
            d = sobj.getDuration();

            if(tobj.containsKey(s))
            {
                old = tobj.get(s);
                tobj.put(s, d+old);
            }
            else
            {
                tobj.put(s,d);
            }
        }
        //Display the details as per subject
        for(String str : tobj.keySet())
        {
            System.out.println("Subject : "+str+" Total Study "+tobj.get(str));
        }

        System.out.println("---------------------------------------------------------------"); 
    }

}
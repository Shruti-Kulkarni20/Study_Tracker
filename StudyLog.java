///////////////////////////////////////////////////////////////////////////////////////////////
///
/// Author      : Shruti kulkarni.
/// File Name   : StudyLog.java
/// Description : Represents a single study session entry.
/// Constructors:
///           - StudyLog(LocalDate date, String subject, double duration, String description)
///             : Initializes a study log with the given details
/// Methods     :
///           - LocalDate getDate()       : Returns the date of the study session
///           - String getSubject()         : Returns the subject studied
///           - double getDuration()        : Returns the duration in hours
///           - String getDescription()     : Returns the description
///           - String toString()           : Returns a formatted string representation of the log
/// User Input:
///     - Provided via StudyTracker when creating a new log
/// 
///////////////////////////////////////////////////////////////////////////////////////////


package Study_Tracker;

import java.time.LocalDate;

public class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public double Duration;
    public String Description;

    public StudyLog(LocalDate A,String B,double C, String D)
    {
        this.Date = A;
        this.Subject = B;
        this.Duration = C;
        this.Description = D;
    }

    @Override
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    }

    public LocalDate getDate()
    {
        return Date;
    }

    public String getSubject()
    {
        return Subject;
    }

    public double getDuration()
    {
        return Duration;
    }

    public String getDescription()
    {
        return Description;
    }
}

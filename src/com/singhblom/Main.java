package com.singhblom;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * The main code for the todo list
 * -- To do
 * @author Amrita Singh-Blom
 *
 */


//

public class Main
{
    public static void main (String[] args)
    {
        PrintedThings.welcomeMessage(PrintedThings.getUserName());

        String taskName = PrintedThings.getTask();
        LocalDate taskDate = PrintedThings.getDueDate();

        Task task1 = new Task(taskName,taskDate);

        System.out.println(task1.getTaskName() +" "+ task1.getDueDate().toString());
        task1.whichProject();




    }
}
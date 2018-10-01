package com.singhblom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main code for the to-do list
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

        //System.out.println(task1.getTaskName() +" due on "+ task1.getDueDate().toString());

        //System.out.println(task1.getTaskName() + task1.getDueDate().toString() + task1.getProjectName());

        //setting up an loop that only ends when the user enters "bye"
        //The to-do list options are executed via a switch-case

        String option;
        ArrayList<Task> toDoList = new ArrayList<>();

        do
        {
            PrintedThings.options();
            Scanner userInput = new Scanner(System.in);
            option= userInput.nextLine();

            switch (option)
            {
                case "1":
                {
                    String taskName = PrintedThings.getTask();
                    LocalDate taskDate = PrintedThings.getDueDate();
                    Task newTask = new Task(taskName,taskDate);
                    newTask.whichProject();
                    //System.out.println(newTask.getTaskName() + newTask.getDueDate().toString() + newTask.getProjectName());
                    toDoList.add(newTask);
                    System.out.println(toDoList.toString()); //todo: write to string method for task
                    break;
                }

                case "2":
                {

                }
            }
        }
        while (!option.equalsIgnoreCase("bye"));







    }
}
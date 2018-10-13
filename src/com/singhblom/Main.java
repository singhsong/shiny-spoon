package com.singhblom;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The main code for the to-do list
 * -- To do
 * @author Amrita Singh-Blom
 *
 */

public class Main
{
    public static void main (String[] args)
    {
        PrintedThings.welcomeMessage(PrintedThings.getUserName());

        ArrayList<Task> toDoList = WriteAndRead.readAndRestore();

        //setting up an loop that only ends when the user enters "bye"
        //The to-do list mainUserOptions are executed via a switch-case

        String option;

        do
        {
            PrintedThings.mainUserOptions();
            option= PrintedThings.getUserInput();

            switch (option)
            {
                // Enter new task
                case "1":
                {
                    PrintedThings.enterNewTask(toDoList);
                    break;
                }

                // View task list by project or due date
                case "2":
                {
                    PrintedThings.viewList(toDoList);
                    break;
                }

                // Edit task, mark task as done or remove task from the list
                case "3":
                {
                    PrintedThings.updateTaskList(toDoList);
                    break;
                }

                case "4":
                {
                    WriteAndRead.saveAndQuit(toDoList);
                    break;
                }
            }
        }
        while (!option.equalsIgnoreCase("bye"));
    }


}
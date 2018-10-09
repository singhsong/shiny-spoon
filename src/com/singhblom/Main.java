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

public class Main
{
    public static void main (String[] args)
    {
        PrintedThings.welcomeMessage(PrintedThings.getUserName());

        //System.out.println(task1.getTaskName() +" due on "+ task1.getDueDate().toString());

        //System.out.println(task1.getTaskName() + task1.getDueDate().toString() + task1.getProjectName());

        //setting up an loop that only ends when the user enters "bye"
        //The to-do list mainUserOptions are executed via a switch-case

        String option;
        ArrayList<Task> toDoList = new ArrayList<>();

        do
        {
            PrintedThings.mainUserOptions();
            Scanner userInput = new Scanner(System.in);
            option= userInput.nextLine();

            switch (option)
            {
                // Enter new task
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
            }
        }
        while (!option.equalsIgnoreCase("bye"));







    }
}
package com.singhblom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

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
        toDoList.add(new Task("Complete code", "Studies", LocalDate.parse("2019-11-04"), true));
        toDoList.add(new Task("Cook", "life", LocalDate.parse("2018-10-05"), true));
        toDoList.add(new Task("Wash the dog", "life", LocalDate.parse("2018-09-01"), false));
        toDoList.add(new Task("Book tickets", "life", LocalDate.parse("2019-01-26"), true));
        toDoList.add(new Task("Book dentists appointment","life", LocalDate.parse("2018-11-13"), true));
        toDoList.add(new Task("Go to the gym", "studies", LocalDate.parse("2019-08-21"), true));
        toDoList.add(new Task("first draft","professional", LocalDate.parse("2018-11-13"), true));
        toDoList.add(new Task("kill reviewer #2","professional", LocalDate.parse("2018-11-13"), true));
        toDoList.add(new Task("Hang out with friends","No project", LocalDate.parse("2018-06-10"), true));
        toDoList.add(new Task("Go on vacation","No project", LocalDate.parse("2018-02-01"), true));


        do
        {
            PrintedThings.mainUserOptions();
            option= PrintedThings.getUserInput();

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
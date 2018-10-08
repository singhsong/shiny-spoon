package com.singhblom;

import java.time.LocalDate;
import java.util.*;

/**
 * This file contains the instructions and prompts given to the to-do list user
 * Intent is to centralize the "chatter" methods
 */

public abstract class PrintedThings
{
    public static String getUserName()
    {
        System.out.println("Hi! Whats your name?");
        System.out.print("> ");
        Scanner userInput = new Scanner(System.in);
        String userName = userInput.nextLine();
        return userName;
    }
    public static void welcomeMessage(String userName)
    {
        System.out.println("Hello "+ userName + " and welcome to your ToDo list");
        System.out.println("Please enter your tasks below");
        System.out.println("At any time, enter bye if you would like to quit");
    }

    public static String getTask()
    {
        System.out.print("To Do: ");
        System.out.print("> ");
        Scanner userInput = new Scanner(System.in);
        String taskName = userInput.nextLine();
        return taskName;
    }

    public static LocalDate getDueDate()
    {
        System.out.print("Due on: (YYYY-MM-DD) ");
        System.out.print("> ");
        Scanner userInput = new Scanner(System.in);
        LocalDate taskDueDate = LocalDate.parse(userInput.nextLine());
        return taskDueDate;
    }

    public static void mainUserOptions()
    {
        System.out.println("Pick an option:\n" +
                "(1) Add New Task\n" +
                "(2) Show Task List (by date or project)\n" +
                "(3) Edit Task (update, mark as done, remove)\n" +
                "(4) Save and Quit\n" +
                ">>");
    }

    /**
     * Implements the logic to print the array list of tasks sorted by due date or project as
     * desired by the user
     * This is option 2 of the To-Do main user menu
     */

    public static void viewList(ArrayList<Task> toDoList)
    {
        System.out.println("View tasks by date or project? (Enter 1 or 2)");
        Scanner userInput = new Scanner(System.in);
        String sortBy = userInput.nextLine();

        //Sorts by due date, ascending
        if (sortBy.equals("1"))
        {
            Collections.sort(toDoList, Comparator.comparing(Task::getDueDate));
            System.out.println(toDoList.toString());
        }

        //Sorts by project name first and within a project, by due date, ascending
        else if (sortBy.equals("2"))
        {
            Collections.sort(toDoList, Comparator.comparing(Task::getProjectName).thenComparing(Task::getDueDate));
            System.out.println(toDoList.toString());
        }


    }


}

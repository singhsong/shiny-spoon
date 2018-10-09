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
     * @param toDoList
     * @return void
     */

    public static void viewList(ArrayList<Task> toDoList)
    {
        System.out.println("View tasks by date or project? (Enter 1 or 2)");

        String sortBy = getUserInput();

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
        // todo add an error exception handling here to send back to main menu or while loop?
    }

    /**
     * Implements the logic for option two of the main menu : making changes to the task list viz.
     *  edit a task, mark as done or remove a task
     * Editing a task can include changes to any fields: changing the task name, adding a project,
     *  updating the due date
     * @param toDoList
     * @return void
     */
    public static void updateTaskList(ArrayList<Task> toDoList)
    {
        System.out.println("Pick an option:\n" +
                "(1) Update task\n" +
                "(2) Mark task as done\n" +
                "(3) Remove task from list\n");

        String editType = getUserInput();

        System.out.println("Which task would you like to edit?: \n");
        System.out.println("Task : Due date : Pending? : Project name");
        for (int i = 0; i < toDoList.size(); i++)
        {
            System.out.print(i+1 + ": ");
            System.out.println(toDoList.get(i).toString());
        }

        String taskNumber = getUserInput();
        int taskNumberInt = Integer.parseInt(taskNumber);

        if (editType.equals("1"))
        {
            System.out.println("What do you want to update:\n" +
                    "(1) Task name\n" +
                    "(2) Due date\n" +
                    "(3) Status\n" +
                    "(4) Project name");

            String taskAttribute = getUserInput();

            // Edit task name
            if (taskAttribute.equals("1"))
            {
                System.out.println("Enter new task name here: ");
                String newTaskName = getUserInput();
                toDoList.get(taskNumberInt-1).setTaskName(newTaskName);
            }

            // Edit due date
            else if (taskAttribute.equals("2"))
            {
                System.out.println("Enter new due date here: ");
                LocalDate newDueDate = getDueDate();
                toDoList.get(taskNumberInt-1).setDueDate(newDueDate);
            }

            // Change project status
            // Gets current status and changes it to the opposite status
            else if (taskAttribute.equals("3"))
            {
                System.out.println("Change current task status? (Y/N)");
                String areYouSure = getUserInput().toUpperCase();

                if (areYouSure.equals("Y") || areYouSure.equals("YES"))
                {
                    Boolean oldStatus = toDoList.get(taskNumberInt).getTaskPending();
                    Boolean newStatus = oldStatus ? false : true;
                    toDoList.get(taskNumberInt-1).setTaskPending(newStatus);
                }
            }

            // Edit project name
            else if(taskAttribute.equals("4"));
            {
                System.out.println("Enter edited project name here: \n" +
                                    "Press enter if there is no project ");
                String newProjectName = getUserInput();
                if (newProjectName.length() > 0)
                {
                    toDoList.get(taskNumberInt-1).setProjectName(newProjectName);
                }
                else
                {
                    newProjectName = "No project";
                    toDoList.get(taskNumberInt-1).setProjectName(newProjectName);
                }
            }
        }

        // user wants to update task status
        else if (editType.equals("2"))
        {

        }

    }

    /**
     * Simple scanner to get user input and return as string
     * @return String
     */
    public static String getUserInput()
    {
        Scanner userInput = new Scanner(System.in);
        String userChoice = userInput.nextLine();
        return userChoice;
    }



}
//todo change all scanner code to pull the getUserInput method instead

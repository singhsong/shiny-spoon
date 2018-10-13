package com.singhblom;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * This file contains the instructions and prompts given to the to-do list user
 * Intent is to centralize the "chatter" methods
 */

public abstract class PrintedThings
{
    public static void enterNewTask(ArrayList<Task> toDoList) {
        String taskName = PrintedThings.queryTaskName();
        LocalDate taskDate = PrintedThings.queryDueDate();
        Task newTask = new Task(taskName,taskDate);
        newTask.whichProject();
        toDoList.add(newTask);
    }

    public static String getUserName()
    {
        System.out.println("Hi! Whats your name?");
        System.out.print("> ");
        String userName = getUserInput();
        return userName;
    }
    public static void welcomeMessage(String userName)
    {
        System.out.println("Hello "+ userName + " and welcome to your ToDo list");
    }

    public static String queryTaskName()
    {
        System.out.print("To Do: ");
        System.out.print("> ");
        String taskName = getUserInput();
        return taskName;
    }

    public static LocalDate queryDueDate()
    {
        System.out.print("Due on: (YYYY-MM-DD) ");
        System.out.print("> ");
        LocalDate taskDueDate;
        try
        {
            taskDueDate = LocalDate.parse(getUserInput());
        }
        catch (DateTimeParseException ex)
        {
            System.out.println("Uh Oh! You need to enter the date as YYYY-MM-DD!!");
            taskDueDate = queryDueDate();
        }

        return taskDueDate;
    }

    public static void mainUserOptions()
    {
        System.out.println("\nPick an option: (...or type bye to exit!)\n" +
                "(1) Add New Task\n" +
                "(2) Show Task List (by date or project)\n" +
                "(3) Edit Task (update, mark as done, remove)\n" +
                "(4) Save and Quit\n" +
                ">>");
    }

    /**
     * Implements the logic to print the array list of tasks sorted by due date or project as
     *  desired by the user
     * This is option 2 of the To-Do main user menu
     * @param toDoList //todo fix this; what does it want?? Look at Javadocs
     */

    //Todo: write a for each loop to make the tasks display line by line
    public static void viewList(ArrayList<Task> toDoList)
    {
        System.out.println("View tasks by date or project? (Enter 1 or 2)");

        String sortBy = getUserInput();

        //Sorts by due date, ascending
        if (sortBy.equals("1"))
        {
            Collections.sort(toDoList, Comparator.comparing(Task::getDueDate));
        }

        //Sorts by project name first and within a project, by due date, ascending
        else if (sortBy.equals("2"))
        {
            Collections.sort(toDoList, Comparator.comparing(Task::getProjectName).thenComparing(Task::getDueDate));
        }
        formattedTaskList(toDoList);
    }

    /**
     * Implements the logic for option two of the main menu : making changes to the task list viz.
     *  edit a task, mark as done or remove a task
     * Editing a task can include changes to any fields: changing the task name, adding a project,
     *  updating the due date
     * @param toDoList arrayList
     */
    public static void updateTaskList(ArrayList<Task> toDoList)
    {
        System.out.println("Pick an option:\n" +
                "(1) Update task\n" +
                "(2) Mark task as done\n" +
                "(3) Remove task from list\n");

        String editType = getUserInput();

        System.out.println("Which task would you like to edit?: \n");
        formattedTaskList(toDoList);

        String taskNumber = getUserInput();
        // Since getUserInput returns strings, need to cast this to an int to use as arraylist index number
        int taskNumberInt = Integer.parseInt(taskNumber);

        switch(editType)
        {
            case("1"): //Update task
            {
                updateTaskSubOptions(toDoList, taskNumberInt);
                break;
            }

            case ("2"): //Mark task as done
            {
                changeTaskStatus(toDoList, taskNumberInt, "Change chosen task status? (Y/N)");
                break;
            }

            case("3"): //Remove task from list
            {
                System.out.println("Are you sure you want to remove " +
                        toDoList.get(taskNumberInt-1).getTaskName() +
                        " from the list? (Y/N)");
                String areYouSure = getUserInput().toUpperCase();
                if (areYouSure.equals("Y") || areYouSure.equals("YES"))
                {
                    toDoList.remove(taskNumberInt-1);
                }
                break;
            }

        }
        }

    public static void updateTaskSubOptions(ArrayList<Task> toDoList, int taskNumberInt)
    {
        System.out.println("\nWhat do you want to update:\n" +
                "(1) Task name\n" +
                "(2) Due date\n" +
                "(3) Status\n" +
                "(4) Project name");

        String taskAttributeToEdit = getUserInput();

        switch(taskAttributeToEdit)
        {
            case("1"): //Update task name
            {
                System.out.println("Enter new task name here: ");
                String newTaskName = getUserInput();
                toDoList.get(taskNumberInt-1).setTaskName(newTaskName);
                break;
            }
            case("2"): //Update Due date
            {
                System.out.println("Enter new due date here: ");
                LocalDate newDueDate = queryDueDate();
                toDoList.get(taskNumberInt-1).setDueDate(newDueDate);
                break;
            }

            case("3"): // Update task status
            {
                changeTaskStatus(toDoList, taskNumberInt, "Change current task status? (Y/N)");
                break;
            }
            case("4"): //Update project name
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
                break;
            }
        }
    }

    public static void formattedTaskList(ArrayList<Task> toDoList) {
        System.out.println("#: Task : Due date : Pending? : Project name");
        for (int i = 0; i < toDoList.size(); i++)
        {
            System.out.print(i+1 + ": ");
            System.out.println(toDoList.get(i).toString());
        }
    }

    private static void changeTaskStatus(ArrayList<Task> toDoList, int taskNumberInt, String s) {
        System.out.println(s);
        String areYouSure = getUserInput().toUpperCase();

        if (areYouSure.equals("Y") || areYouSure.equals("YES")) {
            Boolean oldStatus = toDoList.get(taskNumberInt).getTaskPending();
            Boolean newStatus = !oldStatus;
            toDoList.get(taskNumberInt - 1).setTaskPending(newStatus);
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
        userInput.close();
        return userChoice;
    }
}


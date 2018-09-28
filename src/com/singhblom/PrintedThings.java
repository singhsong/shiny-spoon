package com.singhblom;

import java.time.LocalDate;
import java.util.Scanner;

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


}

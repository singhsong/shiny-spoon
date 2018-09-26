package com.singhblom;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * The main code for the todo list
 * -- To do
 * @author Amrita Singh-Blom
 *
 */


//For now this is just a space saver main function

public class Main
{
    public static void main (String[] args)
    {
        System.out.println("Hi! Whats your name?");
        System.out.print("> ");
        Scanner userInput = new Scanner(System.in);
        String userName = userInput.nextLine();
        PrintedThings.welcomeMessage(userName);

        String taskName = PrintedThings.getTask();
        LocalDate taskDate = PrintedThings.getDueDate();

        Task task1 = new Task(taskName,taskDate);

        System.out.println(task1.getTaskName() + task1.getDueDate().toString());




    }
}
package com.singhblom;

/**
 * This file contains the instructions and prompts given to the todo list user
 * Intent is to centralize the "chatter" methods
 */

public abstract class PrintedThings
{
    public static void welcomeMessage(String userName)
    {
        System.out.println("Hello "+ userName + " and welcome to your ToDo list");
        System.out.println("Please enter your tasks below");
        System.out.println("At any time, enter bye if you would like to quit");
    }
}

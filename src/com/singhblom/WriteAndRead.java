package com.singhblom;

import java.io.*;
import java.util.ArrayList;

public class WriteAndRead
{
    public static ArrayList<Task> readAndRestore()
    {
        ArrayList<Task> toDoList = null;
        File newFile = new File("ToDoList4.txt");
        if (newFile.isFile() && newFile.canRead())
        try
        {
            FileInputStream openFile = new FileInputStream("ToDoList4.txt");

            ObjectInputStream saved = new ObjectInputStream(openFile);

            toDoList = (ArrayList<Task>) saved.readObject();

            saved.close();
            openFile.close();
        }
        catch(Exception ex)
        {
            //ex.printStackTrace();
            System.out.println("Problems opening the previously saved file");
            toDoList = new ArrayList<Task>();
        }
        return toDoList;
    }


    /**
     * This method saves the to-do list and quits the program
     * @param toDoList
     */
    public static void saveAndQuit(ArrayList<Task> toDoList)
    {
        try
        {
//            File newFile = new File("/Users/tmp-sda-1159/IdeaProjects/shiny-spoon/ToDoList");
//            newFile.createNewFile();
            FileOutputStream saveToDoList = new FileOutputStream("/Users/tmp-sda-1159/IdeaProjects/shiny-spoon/ToDoList4.txt");

            ObjectOutputStream saveList = new ObjectOutputStream(saveToDoList);

            saveList.writeObject(toDoList);

            saveList.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Problems with in/out");
        }

        System.exit(0);


    }
}

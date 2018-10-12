package com.singhblom;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * This class contains methods to save the to-do list and quit the program
 * It also contains methods to read saved to-do lists and load them for use
 * @param
 */
public class WriteAndRead
{
    /**
     * This method gets a file name and then saves the to-do list and quits the program
     * @param toDoList
     */
    public static void saveAndQuit(ArrayList<Task> toDoList)
    {
        System.out.println("Enter own filename? (Y/N)\n" +
                "(To Do list will be saved as the current date and time at saving by default");
        String enterOwnFilename = PrintedThings.getUserInput().toUpperCase();

        // Setting the filename to be the string passed by the user or the date and time
        String filename;

        if(enterOwnFilename.equals("Y") || enterOwnFilename.equals("YES"))
        {
            filename = PrintedThings.getUserInput();
        }
        else
        {
            filename = LocalDateTime.now().toString();
        }

        filename = makeLegitFilenameWithSerExtension(filename);

        // Making a serialized file of the to-do arrayList
        FileOutputStream fos;
        ObjectOutputStream out;
        try
        {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(toDoList);
            out.close();
            System.out.format("Your to-do list was saved as %s\nBye!", filename);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        System.exit(0);

    }

    /**
     * Accepts a string and returns it with illegal chars replaced with _ and with a .ser extension
     * @param filename string and returns it with illegal chars replaced with _
     * @return legal filename as string.ser
     */
    public static String makeLegitFilenameWithSerExtension(String filename)
    {
        filename.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
        filename += ".ser";
        return filename;
    }
}

package com.singhblom;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Modeling the task class.
 *
 * The fields are
 * - name of the task and project as strings
 * - and date as LocalDate
 * - and status as boolean
 * @author Amrita Singh-Blom
 */

public class Task implements Serializable
{
    // By default, the task is assumed to be pending at the time of the task-object instantiation
    private String taskName;
    private String projectName = "";
    private LocalDate dueDate;
    private Boolean taskPending = true;

    /**
     * This Task constructor makes a Task object with Task name and the due date
     *  supplied as arguments and project and task pending status set to default values
     * @param taskName
     * @param dueDate
     */
    public Task (String taskName, LocalDate dueDate)
    {
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    /**
     * This Task constructor makes a task with all fields being supplied as arguments
     * @param taskName
     * @param projectName
     * @param dueDate
     * @param taskPending
     */
    public Task (String taskName, String projectName, LocalDate dueDate, Boolean taskPending)
    {
        this.taskName = taskName;
        this.projectName = projectName;
        this.dueDate = dueDate;
        this.taskPending = taskPending;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getTaskPending() {
        return taskPending;
    }

    public void setTaskPending(Boolean taskPending) {
        this.taskPending = taskPending;
    }

    //Gets user-input project and assigns it to a task
    public void whichProject()
    {
        System.out.print("Project: ");
        System.out.println(">");
        System.out.print("No project, no problem, just hit enter");
        String projectName = PrintedThings.getUserInput();

        if (projectName.length() > 0)
        {
            this.setProjectName(projectName);
        }
        else
        {
            projectName = "No project";
            this.setProjectName(projectName);
        }
    }

    // To print out the task details instead of the hashed code of the task
    @Override
    public String toString()
    {
        return String.format("%s\t%s\t%s\t%s", taskName, dueDate, taskPending, projectName);
    }
}
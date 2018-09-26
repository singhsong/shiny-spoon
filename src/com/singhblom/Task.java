package com.singhblom;

import java.time.LocalDate;

/**
 * Modeling the task class.
 *
 * The fields are
 * - name of the task and project as strings
 * - and date as LocalDate
 * - and status as boolean
 */



public class Task
{
    private String taskName;
    private String projectName = "";
    private LocalDate dueDate;
    private Boolean taskPending = true;

    // The task is assumed to be pending at the time of the task-object instantiation
    public Task (String taskName, LocalDate dueDate)
    {
        this.taskName = taskName;
        this.dueDate = dueDate;
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
}
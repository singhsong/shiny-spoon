# shiny-spoon

> In a minute there is time
> For decisions and revisions which a minute will reverse.
>
> For I have known them all already, known them all:
> Have known the evenings, mornings, afternoons,
> I have measured out my life with coffee spoons;
> I know the voices dying with a dying fall
> Beneath the music from a farther room.
>                So how should I presume?

####IP Specification (Received)
#####Project Brief
Your task is to build a ​todo list application​.
The application will allow a user to:
 - create new tasks,
 - assign them a title
 - and due date,
 - and choose a project for that task to belong to.

They will need to use a text based user interface via the command-line
(hint: see ​World of Zuul project for some ideas on this).

Once they are using the application, the user should be able to:
 - also edit,
 - mark as done
 - or remove tasks.
 - They can also quit and save the current task list to file,
 - and then restart the application with the former state restored.

The interface should look similar to the mockup below:

```>> Welcome to ToDoly
>> You have X tasks todo and Y tasks are done!
>> Pick an option:
>> (1) Show Task List (by date or project)
>> (2) Add New Task
>> (3) Edit Task (update, mark as done, remove)
>> (4) Save and Quit
>>
```
#####Requirements
The solution __must__ achieve the following requirements:
- Model a task with
  - a task title,
  - due date,
  - status
  - and project
- Display a collection of tasks,
  - sorted by date
  - or filtered by project
- Support the ability to
  - add,
  - edit,
  - mark as done,
  - or remove tasks
- Support a text-based user interface
- Load and save task list to file

The solution *may* also include other creative features at your discretion
in case you wish to show some flair(​but this will not affect the default
evaluation -- see checklist​).

#### ToDo

- [ ] Set up task class
     - [ ] Done, removed, pending subclasses?

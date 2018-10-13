# shiny-spoon

> In a minute there is time  
> For decisions and revisions which a minute will reverse.  
>  
> For I have known them all already, known them all:  
> Have known the evenings, mornings, afternoons,  
> I have measured out my life with coffee spoons;  
> I know the voices dying with a dying fall  
> Beneath the music from a farther room.  
> So how should I presume?  

#### IP Specification (Received)
##### Project Brief
Your task is to build a ​todo list application​.
The application will allow a user to:
 - create new tasks,
 - assign them a title
 - and due date,
 - and choose a project for that task to belong to.

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
##### Requirements
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

#### Solution

The final to-do list application contained three classes as follows (see class diagram).
![To-do List Class diagram](uml.png)

##### User Manual
- On starting the program, the user's previous to-do List is loaded
- The user is prompted to enter their names and are greeted with a message and options
- By entering the number of the option as displayed, the user can choose what they would like to do, viz, 
    * Enter a new task
    * Edit/update a preexisting task
    * View a sorted task list
    * Save and exit the program
- In the main menu, the user has the option to enter bye to exit the program.
    
##### Known limitations
- The user cannot create multiple to-do lists. This is because I couldn't figure out how to search for all the saved task lists and then offer the user the option of selecting a specific one to load. 
- The text-based interface is not visually appealing. This is definitely something I need to learn and try out.


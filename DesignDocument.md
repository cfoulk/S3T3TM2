# Odin Project

## Introduction
Odin is a project management software designed for use by small technical businesses to help organize their work towards large goals. It's leadership based structure allows for different responsibilities to be held by different workers. Managers organize the Project Leads who manage the employees. Managers create, delete, and define projects. Project leads give tasks to employees to work towards the project. Employees log their work through starting, stopping, and describing.

## Product Reviews
Basecamp is a business management tool used to keep company projects organized and employees informed. It utilizes message boards and project pages to keep work organized and communicative. The software can be used for scheduling, sharing workloads, chatting, file sharing, and work logging. All work is divided into different teams and projects. Remember The Milk is a much more personal task management software that is meant for families to keep track of everyone's responsibilities. It includes the ability to add tasks through single lines that define everything from the name, to what it is, to a due date, and a priority size. It reminds the user of their tasks through a computer using IM and email, or a phone through texting and push apps. Each task can be broken up into smaller subtasks and lists of tasks can be shared with others using the app. Producteev is another group project manager with useful tools for keeping a project rolling. Deadlines, reminders, priorities, tags, labels, and following all help keep the project participants knowledgeable of the work their peers are doing. In addition, team members can assign each other tasks to give everyone an idea of what they should be doing in the project. Asana separates itself from other project management tools by being one of the most visual ones we could find.

## Project Overview
From our research on various project management tools we will be using a couple of ideas. First, our present Task Management software has no way of recognizing when a task is finished, so we will be adding support for finished tasks as well as due dates for the tasks. In addition, projects without priorities lack structure and guidance, so we will be adding priorities to our tasks. As a project is composed of many tasks, a progression check for how close a project is to completion will be added. We will be also adding support for logging in under different users to keep track of everyone's participation separately as well as keeping the responsibilities in line.Finally, we will be adding a GUI to make the product more suitable for general use by non computer specialists.

## Project Architecture
The core ideas of our prior task management software will remain the same. The tool will be used to manage the progression of tasks. Our first deviation is that we will be using JavaFX for a GUI and Jfoenix for material design. We will be storing our project data using an SQL Database. We will be also implementing a login system and as such we will keep user login information. Where we previously had only one set of data to store, this new product will have many. Each project will have its own data, so only tasks related to that project will be held together. In addition, we will have another data set to hold our login information.

<div style="page-break-after: always;"></div>

## Requirements
ID|Priority|Description
:-:|:-:|---|
REQ1	|5|The system will store all task and project data to a SQL database for future access .
REQ2	|2|The system will allow access to only the authorized users through a user login page.
REQ3	|4|The system will allow authorized users for the creation and modification of projects as a container for tasks.
REQ4	|1|The system will allow administrative users to create and manage temporary logins for new users.
REQ5	|3|The system shall allow authorized users to create, define due date, and assign tasks/projects to users.
REQ6	|2|The system shall allow users to redefine tasks (description and size)
REQ7	|1|The system shall allow users to change their login information.
REQ8	|4|The system will allow users to start and stop work on a task and log subsuquent information associated with the action.
REQ9	|2|The system will keep track of user created projects and assoicated tasks for generating user statistics and reports.
REQ10	|3|The system will provide statistics on available task and project data. Such as, minimum time, maximum time, average time, durations etc.
REQ11	|1|The system shall display messages set by authorized users ("Your performance is subpar and you are risking termination, fyi") on login.
REQ12	|2|The system will limit project and task view to users specfic to that project.
REQ13	|1|The system will notify authorized users (project lead) when a task is marked as complete by regular user (employee) on login.
REQ14	|3|The system will allow authorized users to conclude items such as projects and tasks to prevent access to sub-users

<div style="page-break-after: always;"></div>

## Use Cases
ID|Name|Description
---|---|---
UC-1    |Create Project         | Create a project, defining its name, group, and project leader. Optional: Due date, description, and status.
UC-2    |Edit Project           | Change any data of a project excluding the project ID. Can change name, group, lead, due date, status, and description.
UC-3    |Summarize Project      | View all of the information that a project contains, including a list of its tasks and the time spent on it.
UC-4    |Create Task            | Create a task, defining its name, associated project, and employee assigned. Optional: Due date, description, and size.
UC-5    |Edit Task              | Change any data of a task excluding the task ID. Can change name, associated project, employee assigned, due date, description, and size.
UC-6    |Summarize Task         | View all of the information that a task contains, including the time spent on it.
UC-7    |Start a work session   | Log the beginning of a working session.
UC-8    |End a work session     | Log the end of a work session, including a description of the work done. May request closure of task.
UC-9    |Edit a work session    | Change any data of a work log excluding the work log ID. Can change the entry type, the description, the timestamp, the employee assigned, and the task assigned
UC-10   |Create Employee        | Create an employee, defining its name, position, username, and password. Optional: Group.
UC-11   |Edit Employee          | Change any data of an employee excluding the employee ID. Can change name, group, position, username, and password.
UC-12   |Change Login           | Change the login information of the logged in user.

## Accountability Matrix
Requirement |PW |UC1|UC2|UC3|UC4|UC5|UC6|UC7|UC8|UC9|UC10|UC11|UC12
---         |:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:
REQ1|   5|  X   |X  |X  |X  |X  |X  |X  |X  |X  |X  |X  |X
REQ2|   2|  X   |X  |X  |X  |X  |X  |X  |X  |X  |X  |X  |X
REQ3|   4|  X   |X  |X  |   |   |   |   |   |   |   |   |
REQ4|   1|      |   |   |   |   |   |   |   |   |X  |X  |X
REQ5|   3|      |X  |   |   |X  |   |   |   |   |X  |X  |
REQ6|   2|      |X  |   |   |X  |   |   |   |   |   |   |
REQ7|   1|      |   |   |   |   |   |   |   |   |   |X  |X
REQ8|   4|      |   |   |   |   |   |X  |X  |X  |   |   |
REQ9|   2|      |   |X  |   |   |X  |   |   |   |   |   |
REQ10|  3|      |   |X  |   |   |X  |   |   |   |   |   |
REQ11|  1|      |   |   |   |   |   |   |   |   |   |   |
REQ12|  2|  X   |X  |X  |X  |X  |X  |X  |X  |X  |   |   |
REQ13|  1|      |X  |   |   |X  |   |   |   |   |   |   |
REQ14|  3|      |X  |   |   |X  |   |   |   |   |   |   |
Max PW||    5  |5  |5  |5  |5  |5  |5  |5  |5  |5  |5  |5
Total PW||  13 |22 |18 |9  |18 |14 |13 |18 |13 |11 |12 |9

## Use Case Blocks

Use Case UC - 1| Create a project
---|---
Initiating Actor:|Manager
Actor's Goal:|To create a new project.
Participating Actors:|Odin
Preconditions:|None worth mentioning.
Postconditions:|A new project is added to the database.
Event Flow for Main:|- - -
1   |**Manager** arrives at the terminal and is prompted for a log in.
2   |**Manager** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Manager** of its validity.
4   |**Odin** (a) displays options available to the **Manager**, (b) and prompts the **Manager** to make a selection.
5   |**Manager** selects the "Create a project" option and enters the new data.
6   |**Odin** (a) stores the new data and (b) signals completion.
Event Flow for Extension:|- - -
2a  |**Manager** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Manager**.
2   |**Manager** supplies his login information.
3   |Same as in step 3 above.

Use Case UC - 2| Editing a project
---|---
Initiating Actor:|Manager or Project Lead
Actor's Goal:|Change properties of the project, including its name, group number, description, status, and due date.
Participating Actors:|Odin
Preconditions:|There is a project to edit.
Postconditions:|Changes are made to the project in accordance to what the actor inputs.
Event Flow for Main:|- - -
1   |**Actor** arrives at the terminal and is prompted for a log in.
2   |**Actor** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Actor** of its validity.
4   |**Odin** (a) displays options available to the **Actor**, (b) and prompts the **Actor** to make a selection.
5   |**Actor** selects the "Edit a project" option and enters the project's name.
6   |**Odin** (a) verifies the project exists, (b) displays options available to the **Actor**, and (c) prompts the **Actor** to make a selection.
7   |**Actor** selects one of the options, and provides new information for the selection.
8   |**Odin** (a) stores the new information in the database, and (b) signals completion.
Event Flow for Extension:|- - -
2a|**Actor** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Actor**.
2   |**Actor** supplies his login information.
3   |Same as in step 3 above.
5a  |
1   |**Odin** (a) finds no project with the given name and (b) signals the **Actor**.
2   |**Actor** enters the project's name.
3   |Same as in Step 6 above.

Use Case UC - 3| Summarize a project
---|---
Initiating Actor:|Manager, Project Lead, or Employee
Actor's Goal:|See a summary of a project.
Participating Actors:|Odin
Preconditions:|There is a project to summarize.
Postconditions:|The Actor sees a summary of the project.
Event Flow for Main:|- - -
1   |**Actor** arrives at the terminal and is prompted for a log in.
2   |**Actor** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Actor** of its validity.
4   |**Odin** (a) displays options available to the **Actor**, (b) and prompts the Actor to make a selection.
5   |**Actor** selects the "See time spent on a project" option and enters the project's name.
6   |**Odin** (a) verifies the project exists, (b) displays a summary of the project.
Event Flow for Extension:|- - -
2a  |**Actor** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Actor**.
2   |**Actor** supplies his login information.
3   |Same as in step 3 above.
5a  |
1   |**Odin** (a) finds no project with the given name and (b) signals the **Actor**.
2   |**Actor** enters the project's name.
3   |Same as in Step 6 above.

Use Case UC - 4| Create a task
---|---
Initiating Actor:|Project Lead
Actor's Goal:|To create a new task.
Participating Actors:|Odin
Preconditions:|There is a project for the task to be associated with.
Postconditions:|A new task is added to the database.
Event Flow for Main:|- - -
1   |**Project Lead** arrives at the terminal and is prompted for a log in.
2   |**Project Lead** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Project Lead** of its validity.
4   |**Odin** (a) displays options available to the **Project Lead**, (b) and prompts the **Project Lead** to make a selection.
5   |**Project Lead** selects the "Create a task" option.
6   |Odin prompts the user for a project name to link the task to.
7   |**Project Lead** enters a project name.
8   |**Odin** (a) verifies the project exists, (b) and prompts the **Project Lead** to enter data for the task.
9   |**Odin** (a) stores the new data and (b) signals completion.
Event Flow for Extension:|- - -
2a  |**Project Lead** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Project Lead**.
2   |**Project Lead** supplies his login information.
3   |Same as in step 3 above.
7a  |
1   |**Odin** (a) finds no project with the given name and (b) signals the **Project Lead**.
2   |**Project Lead** enters the project's name.
3   |Same as in Step 8 above.

Use Case UC - 5| Editing a task
---|---
Initiating Actor:|Project Lead
Actor's Goal:|Change properties of the task, including its name, due date, description, size, project association, employee association, and status.
Participating Actors:|Odin
Preconditions:|There is a task to edit.
Postconditions:|Changes are made to the task in accordance to what the Project Lead inputs.
Event Flow for Main:|- - -
1   |**Project Lead** arrives at the terminal and is prompted for a log in.
2   |**Project Lead** supplies his login information.
3   |**Odin** (a) verifies the login information, and (b) signals the **Project Lead** of its validity.
4   |**Odin** (a) displays options available to the **Project Lead**, (b) and prompts the **Project Lead** to make a selection.
5   |**Project Lead** selects the "Edit a task" option and enters the task's name.
6   |**Odin** (a) displays a list of projects with tasks of the given name, and (b) prompts the user to select a the project associated with the task.
7   |**Project Lead**d enters the project name.
8   |**Odin** Displays options available to the **Project Lead**, and (b) prompts the **Project Lead** to make a selection.
9   |**Project Lead** selects one of the options, and provides new information for the selection.
10  |**Odin** (a) stores the new information in the database, and (b) signals completion.
Event Flow for Extension:|- - -
2a  |**Project Lead** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Project Lead**.
2   |**Project Lead** supplies his login information.
3   |Same as in step 3 above.
5a  |
1   |**Odin** (a) finds no task with the given name and (b) signals the **Project Lead**.
2   |**Project Lead** enters the task's name.
3   |Same as in Step 6 above.
7a  |
1   |**Odin** (a) finds no project with the given name and (b) signals the **Project Lead**.
2   |**Project Lead** enters the project's name.
3   |Same as in Step 8 above.

Use Case UC - 6| Summarize a task
---|---
Initiating Actor:|Project Lead or Employee
Actor's Goal:|See a summary of a task.
Participating Actors:|Odin
Preconditions:|There is a task to summarize.
Postconditions:|The Actor sees a summary of the task.
Event Flow for Main:|- - -
1   |**Actor** arrives at the terminal and is prompted for a log in.
2   |**Actor** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Actor** of its validity.
4   |**Odin** (a) displays options available to the **Actor**, (b) and prompts the **Actor** to make a selection.
5   |**Actor** selects the "See time spent on a task" option and enters the task's name.
6   |**Odin** (a) displays a list of projects with tasks of the given name, and (b) prompts the user to select a the project associated with the task.
7   |Project Lead enters the project name.
8   |**Odin** Displays a summary of the task.
Event Flow for Extension:|- - -
2a  |**Actor** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Actor**.
2   |**Actor** supplies his login information.
3   |Same as in step 3 above.
5a  |
1   |**Odin** (a) finds no task with the given name and (b) signals the **Actor**.
2   |**Actor** enters the task's name.
3   |Same as in Step 6 above.
7a  |
1   |**Odin** (a) finds no project with the given name and (b) signals the **Actor**.
2   |**Actor** enters the project's name.
3   |Same as in Step 8 above.

Use Case UC - 7| Start working on a task
---|---
Initiating Actor:|Project Lead or Employee
Actor's Goal:|Log the beginning of an actor's work.
Participating Actors:|Odin
Preconditions:|There is a task to start work on.
Postconditions:|A timestamp of the start of work is logged.
Event Flow for Main:|- - -
1   |**Actor** arrives at the terminal and is prompted for a log in.
2   |**Actor** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Actor** of its validity.
4   |**Odin** (a) displays options available to the **Actor**, (b) and prompts the **Actor** to make a selection.
5   |**Actor** selects the "Describe a task" option and enters the task's name.
6   |**Odin** (a) displays a list of projects with tasks of the given name, and (b) prompts the user to select a the project associated with the task.
7   |**Actor** enters the project name.
8   |**Odin** (a) stores a timestamp into the database, and (b) signals completion.
Event Flow for Extension:|- - -
2a  |**Actor** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Actor**.
2   |**Actor** supplies his login information.
3   |Same as in step 3 above.
5a  |
1   |**Odin** (a) finds no task with the given name and (b) signals the **Actor**.
2   |**Actor** enters the task's name.
3   |Same as in Step 6 above.
7a  |
1   |**Odin** (a) finds no project with the given name and (b) signals the **Actor**.
2   |**Actor** enters the project's name.
3   |Same as in Step 8 above.

Use Case UC - 8| Stop working on a task
---|---
Initiating Actor:|Project Lead or Employee
Actor's Goal:|Log the end of an actor's work.
Participating Actors:|Odin
Preconditions:|There is a task to end work on.
Postconditions:|A timestamp of the end of work, and a quick summary of the work is logged.
Event Flow for Main:|- - -
1   |**Actor** arrives at the terminal and is prompted for a log in.
2   |**Actor** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Actor** of its validity.
4   |**Odin** (a) displays options available to the **Actor**, (b) and prompts the **Actor** to make a selection.
5   |**Actor** selects the "Describe a task" option and enters the task's name.
6   |**Odin** (a) displays a list of projects with tasks of the given name, and (b) prompts the user to select a the project associated with the task.
7   |**Actor** enters the project name.
8   |**Odin** prompts the user for a summary of the work session.
9   |**Actor** enters the work summary.
10  |**Odin** (a) stores the summary and timestamp into the database, and (b) signals completion.
Event Flow for Extension:|- - -
2a  |**Actor** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Actor**.
2   |**Actor** supplies his login information.
3   |Same as in step 3 above.
5a  |
1   |**Odin** (a) finds no task with the given name and (b) signals the **Actor**.
2   |**Actor** enters the task's name.
3   |Same as in Step 6 above.
7a  |
1   |**Odin** (a) finds no project with the given name and (b) signals the **Actor**.
2   |**Actor** enters the project's name.
3   |Same as in Step 8 above.

Use Case UC - 9 | Editing a work log
---|---
Initiating Actor:|Project Lead
Actor's Goal:|Change properties of the work log,entry type, task association, description, and time stamp.
Participating Actors:|Odin
Preconditions:|There is a task to edit.
Postconditions:|Changes are made to the task in accordance to what the **Project Lead** inputs.
Event Flow for Main:|- - -
1   |**Project Lead** arrives at the terminal and is prompted for a log in.
2   |**Project Lead** supplies his login information.
3   |**Odin** (a) verifies the login information, and (b) signals the **Project Lead** of its validity.
4   |**Odin** (a) displays options available to the **Project Lead**, (b) and prompts the **Project Lead** to make a selection.
5   |**Project Lead** selects the "Edit a Work Log" option and enters the work log's ID.
8   |**Odin** displays the work log with editable fields.
9   |**Project Lead** provides new information for the log.
10  |**Odin** (a) stores the new information in the database, and (b) signals completion.
Event Flow for Extension:|- - -
2a  |**Project Lead** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Project Lead**.
2   |**Project Lead** supplies his login information.
3   |Same as in step 3 above.
5a  |
1   |**Odin** (a) finds  work log with the given ID and (b) signals the **Project Lead**.
2   |**Project Lead** enters the work log's ID.
3   |Same as in Step 6 above.

Use Case UC - 10| Create an Employee
---|---
Initiating Actor:|Manager
Actor's Goal:|To create a new employee.
Participating Actors:|Odin
Preconditions:|None worth mentioning.
Postconditions:|A new employee is added to the database.
Event Flow for Main:|- - -
1   |**Manager** arrives at the terminal and is prompted for a log in.
2   |**Manager** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Manager** of its validity.
4   |**Odin** (a) displays options available to the **Manager**, (b) and prompts the **Manager** to make a selection.
5   |**Manager** selects the "Create an employee" option and enters the new data.
6   |**Odin** (a) stores the new data and (b) signals completion.
Event Flow for Extension:|- - -
2a  |**Manager** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Manager**.
2   |**Manager** supplies his login information.
3   |Same as in step 3 above.

Use Case UC - 11| Editing an Employee
---|---
Initiating Actor:|Manager
Actor's Goal:|Change properties of an employee, including its name, position, group, username, and password
Participating Actors:|Odin
Preconditions:|There is a employee to edit.
Postconditions:|Changes are made to the employee in accordance to what the manager inputs.
Event Flow for Main:|- - -
1   |**Manager** arrives at the terminal and is prompted for a log in.
2   |**Manager** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Manager** of its validity.
4   |**Odin** (a) displays options available to the **Manager**, (b) and prompts the **Manager** to make a selection.
5   |**Manager** selects the "Edit an employee" option and enters the employee's name.
6   |**Odin** (a) verifies the employee exists, (b) displays options available to the **Manager**, and (c) prompts the **Manager** to make a selection.
7   |**Manager** provides new information for the selection.
8   |**Odin** (a) stores the new information in the database, and (b) signals completion.
Event Flow for Extension:|- - -
2a  |**Manager** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Manager**.
2   |**Manager** supplies his login information.
3   |Same as in step 3 above.
5a  |
1   |**Odin** (a) finds no project with the given name and (b) signals the **Manager**.
2   |**Manager** enters the employee's name.
3   |Same as in Step 6 above.

Use Case UC - 12| Changing Login
---|---
Initiating Actor:|Manager, Project Lead, or Employee
Actor's Goal:|Change the login information for the actor.
Participating Actors:|Odin
Preconditions:|The actor is able to log in.
Postconditions:|"The actor's login information is updated on the database.
Event Flow for Main:|- - -
1   |**Actor** arrives at the terminal and is prompted for a log in.
2   |**Actor** supplies his login information.
3   |(a) **Odin** verifies the login information, and (b) signals the **Actor** of its validity.
4   |**Odin** (a) displays options available to the Actor, (b) and prompts the **Actor** to make a selection.
5   |**Actor** selects the "Change Login".
6   |**Odin** presents **Actor** with text fields for username and password.
7   |**Actor** provides new login information.
8   |**Odin** (a) stores the new information in the database, and (b) signals completion.
Event Flow for Extension:|- - -
2a  |**Actor** supplies invalid login information.
1   |**Odin** (a) detects an error and (b) signals the **Actor**.
2   |**Actor** supplies his login information.
3   |Same as in step 3 above.

<div style="page-break-after: always;"></div>

## Domain Model

### Generic Domain Model

![alt text](https://raw.githubusercontent.com/CSUS-CSC-131-Spring2018/S3T3TM2/master/Design%20Model/images/Generic%20Domain%20Model.png "Generic Domain Model")

<div style="page-break-after: always;"></div>

### UC Add Employ

```mermaid
sequenceDiagram
User ->> GUI: User sends login info.
GUI -->> Model: GUI sends login info to Model.
Model -->> Server: Model requests employee info for username.
Server -->> Model: Sends employee info if username exists.
Model -->> Model: Checks if password is valid for username.
Model -->> GUI: User is valid.
GUI ->> User: GUI displays status window.
User ->> GUI: Selects view employees.
GUI ->> User: Displays employees window.
User ->> GUI: Selects add employee.
GUI ->> User: Displays employee info window.
User ->> GUI: Fills in employee information and selects save.
GUI -->> Model: Sends employee info to Model.
Model -->> Server: Asks if an employee exists with username.
Server -->> Model: Confirms username is new.
Model -->> Server: Sends employee info.
Server -->> Server: Saves employee info.
```

<div style="page-break-after: always;"></div>

### UC Edit Employ

```mermaid
sequenceDiagram
User ->> GUI: User sends login info.
GUI -->> Model: GUI sends login info to Model.
Model -->> Server: Model requests employee info for username.
Server -->> Model: Sends employee info if username exists.
Model -->> Model: Checks if password is valid for username.
Model -->> GUI: User is valid.
GUI ->> User: GUI displays status window.
User ->> GUI: Selects view employees.
GUI ->> User: Displays employees window.
User ->> GUI: Selects an employee to edit.
GUI ->> User: Displays employee info window.
User ->> GUI: Fills in employee information and selects save.
GUI -->> Model: Sends employee info to Model.
Model -->> Server: Asks if an employee exists with username.
Server -->> Model: Confirms username is new.
Model -->> Server: Sends employee info.
Server -->> Server: Saves employee info.
GUI -->> Server: GUI requests update.
Server -->> GUI: Server sends update.
GUI -->> GUI: GUI updates.
GUI ->> User: Displays confirmation and new info.
```

<div style="page-break-after: always;"></div>

### UC Add Project

```mermaid
sequenceDiagram
User ->> GUI: User sends login info
GUI -->> Model: GUI sends login info to Model
Model -->> Server: Model requests employee info for username
Server -->> Model: Sends employee info if username exists
Model -->> Model: Checks if password is valid for username
Model -->> GUI: User is valid
GUI ->> User: GUI displays status window
User ->> GUI: User selects add project
GUI ->> User: GUI opens a project info window.
User ->> GUI: User inputs project info and clicks save.
GUI -->> Model: GUI sends info to Model.
Model -->> Server: Model asks if project lead with employeeID exists.
Server -->> Model: Server confirms project lead exists.
Model -->> Server: Model sends project info to server.
Server -->> Server: Server saves project.
```

<div style="page-break-after: always;"></div>

### UC Edit Project

```mermaid
sequenceDiagram
User ->> GUI: User sends login info.
GUI -->> Model: GUI sends login info to Model.
Model -->> Server: Model requests employee info for username.
Server -->> Model: Sends employee info if username exists.
Model -->> Model: Checks if password is valid for username.
Model -->> GUI: User is valid.
GUI ->> User: GUI displays status window.
User ->> GUI: Select a project to edit.
GUI ->> User: GUI opens a project edit window.
User ->> GUI: User inputs project info and clicks save.
GUI -->> Model: GUI sends info to Model.
Model -->> Server: Model asks if project lead with employeeID exists.
Server -->> Model: Server confirms project lead exists.
Model -->> Server: Model sends project info to server.
GUI -->> Server: GUI requests update.
Server -->> GUI: Server sends update.
GUI -->> GUI: GUI updates.
GUI ->> User: Displays confirmation and new info.
```

<div style="page-break-after: always;"></div>

### UC Project Summary

```mermaid
sequenceDiagram
User ->> GUI: User sends login info
GUI -->> Model: GUI sends login info to Model
 Model -->> Server: Model requests employee info for username
 Server -->> Model: Sends employee info if username exists
 Model -->> Model: Checks if password is valid for username
 Model -->> GUI: User is valid
 GUI ->> User: GUI displays status window
User ->> GUI: selects a project
GUI --> Model: sends selected project info to the Model
Model-->>Server: requests project info
Server-->> Model: sends project info to the Model
Model -->> GUI : display the project summary
 ```

<div style="page-break-after: always;"></div>

### UC Add Task

```mermaid
sequenceDiagram
User ->> GUI: User sends login info
GUI -->> Model: GUI sends login info to Model
Model -->> Server: Model requests employee info for username
Server -->> Model: Sends employee info if username exists
Model -->> Model: Checks if password is valid for username
Model -->> GUI: User is valid
GUI ->> User: GUI displays status window
User ->> GUI: Select a project to view
GUI ->> User: Display project window
User ->> GUI: User selects add task
GUI ->> User: GUI opens a task info window.
User ->> GUI: User inputs task info and clicks save.
GUI -->> Model: GUI sends info to Model.
Model -->> Server: Model asks if employee with employeeID exists.
Server -->> Model: Server confirms employee exists.
Model -->> Server: Model asks if project with projectID exists.
Server -->> Model: Server confirms project exists.
Model -->> Server: Model sends task info to server.
Server -->> Server: Server saves task.
```

<div style="page-break-after: always;"></div>

### UC Edit Task

```mermaid
sequenceDiagram
User ->> GUI: User sends login info
GUI -->> Model: GUI sends login info to Model
Model -->> Server: Model requests employee info for username
Server -->> Model: Sends employee info if username exists
Model -->> Model: Checks if password is valid for username
Model -->> GUI: User is valid
GUI ->> User: GUI displays status window
User ->> GUI: Select a project to view
GUI ->> User: Display project window
User ->> GUI: User selects task to edit
GUI ->> User: Opens task edit windows
User ->> GUI: Change task info
GUI -->> Model: Sends new task info
Model -->> Server: Asks if employee with employeeID exists
Server -->> Model: Confirms employee exits
Model -->> Server: Asks if project with projectID exists
Server -->> Model: Confirms project exists
Model -->> Server: Sends new task info
Server -->> Server: Updates task with new info
GUI -->> Server: GUI requests update.
Server -->> GUI: Server sends update.
GUI -->> GUI: GUI updates.
GUI ->> User: Displays confirmation and new info.
```

<div style="page-break-after: always;"></div>

### UC Start Task

```mermaid
sequenceDiagram
User ->> GUI: User sends login info
GUI -->> Model: GUI sends login info to Model
Model -->> Server: Model requests employee info for username
Server -->> Model: Sends employee info if username exists
Model -->> Model: Checks if password is valid for username
Model -->> GUI: User is valid
GUI ->> User: GUI displays status window
User ->>GUI: selects view project
GUI ->> User : shows user project window
User->>GUI : user selects task and starts work
GUI --> Model: sends work session info
Model -->Server: sends work log info and stores for record
User ->>GUI: user stops work
GUI-->User: requests work session summary
User-->GUI: send work session summary
GUI->> Model: sends work session summary
Model ->> Server: records work session and stores
```

<div style="page-break-after: always;"></div>

### UC Task Summary

```mermaid
sequenceDiagram
User ->> GUI: User sends login info
GUI -->> Model: GUI sends login info to Model
 Model -->> Server: Model requests employee info for username
 Server -->> Model: Sends employee info if username exists
 Model -->> Model: Checks if password is valid for username
 Model -->> GUI: User is valid
 GUI ->> User: GUI displays status window
User ->> GUI: selects a project
GUI -->> Model: sends selected project info to the Model
Model-->>Server: requests project info
Server-->> Model: sends project info to the Model
Model -->> GUI : display the project summary
User ->> GUI : selects task from task list
GUI -->> Model: sends selected task info to the Model
Model-->>Server : request task info
Server-->>Model :sends task info
Model -->>GUI : displays the task summary
```

<div style="page-break-after: always;"></div>

## System Design

The first diagram shows the general breakdown of the program and how each of the classes is derived from each other (associations). The classes we are working with here include the Server Class(Server, Employee, Task, Worklog), Model, and the Interface. The GUI is the external portion that is represented here by the server.

The following diagrams represent the each individual diagram of a class. Showing individual parameters and methods being used in that class.


![alt text](https://raw.githubusercontent.com/CSUS-CSC-131-Spring2018/S3T3TM2/master/Design%20Model/images/GeneralDiagramOverview.PNG "Generic Domain Model")
![alt text](https://raw.githubusercontent.com/CSUS-CSC-131-Spring2018/S3T3TM2/master/Design%20Model/images/ServerClassDiagram.PNG "Server Class Diagram")
![alt text](https://raw.githubusercontent.com/CSUS-CSC-131-Spring2018/S3T3TM2/master/Design%20Model/images/OdinServer_Diagram.PNG "Server Method Diagrams")

<div style="page-break-after: always;"></div>

## System Design

![alt text](https://raw.githubusercontent.com/CSUS-CSC-131-Spring2018/S3T3TM2/master/Design%20Model/images/OdinServer_Diagram.PNG "Server Diagram")
![alt text](https://raw.githubusercontent.com/CSUS-CSC-131-Spring2018/S3T3TM2/master/Design%20Model/images/ModelServerDiagram1.png "Model Diagram")
![alt text](https://raw.githubusercontent.com/CSUS-CSC-131-Spring2018/S3T3TM2/master/Design%20Model/images/ModelServerDiagramMethods.PNG "Model Diagram Methods")

<div style="page-break-after: always;"></div>

## Progress Report
### Implemented Use Cases:
No use cases have been completely implemented. GUI work has been going in parallel,
so even though the back end for the following use cases is in place, the GUI still
needs to implement them. All necessary methods for getting and sending information
to the server have also been implemented, but need Model and GUI support before
the use cases can be considered implemented fully.
* (UC-1) Create Project
* (UC-9) Create Employee
* (UC-10) Edit Employee

### Already Functional
The OdinServer.java is completely done or only needing minor tweaks for the future.
It already has all the necessary methods for getting entries, creating new entries,
and editing already existing data. This includes all the searches that are deemed
necessary for querying the data for specific lists of data.

### Currently Being Tackled
The GUI is taking some work, but is being worked on steadily. The GUI supports
a login, but nothing beyond that for now. OdinModel.java is being worked on as well,
it is intended to make sure that the server only gets valid queries and that
the user does not try to push duplicate data onto the server.

## Plan of Work
The View and Add methods of OdinModel should be done by the end of this week on
April 21st. The initial status page and employee page is planned to be finished
by the 21st as well. Using the completing of these milestones, we should be able
to more accurately estimate future dates.

## Breakdown of Responsibilities
* GUI Work: David Henning
* Edit Methods: Yusuf Amani
* Add Methods: Joel Sanchez
* Get Methods: Ramya Singamsetty & Charles Foulk

* Coordinator/Server: Joel Sanchez

* Testing: Charles Foulk





package App.gui;

import App.gui.component.DashboardController;
import Server.*;
import Model.OdinModel;
import com.jfoenix.controls.JFXDecorator;
import javafx.scene.Parent;

import java.util.List;

public class persistentUser {

    public static JFXDecorator DECORATOR;
    public static Parent PARENT_LOGIN;
    public static Parent PARENT_DASHBOARD;

    public static Employee currentUser;
    public static List<Employee> EmployeeList = null;
    public static List<Project> ProjectList = null;
    public static List<Task> TaskList = null;
    public static List<WorkLog> WorkLogList = null;
    public static List<Message> MessageList = null;

    private static DashboardController Dashboard;
    private static OdinModel OM = null;
    private static Thread persistanceThread = null;


    public static void initiateSampleData(){
        Project user1 = new Project(1,22,131,"Finish Dashboard", "Testing class", "In-Progress", "5/11/2018");
        Project user2 = new Project(33,22,131,"Show Headers", "Testing class", "In-Progress", "5/4/2018");
        Task task1 = new Task(1, "Task Name","2000-1-1",3,"69", "Task description", 1, "Open");
//        WorkLog wl1 = new WorkLog(1,2,3,"Open","worklog");
        TaskList.add(task1);
        ProjectList.add(user1);
        ProjectList.add(user2);
    }

    public static void initiateServerData(OdinModel om,DashboardController dashboard){
        OM = om;
        Dashboard = dashboard;
        EmployeeList = OM.getEmployees();
        ProjectList = OM.getProjects();
        TaskList = OM.getTasks();
        WorkLogList = OM.getWorkLogs();
        MessageList = OM.getMessages();
    }

    public static void runLiveUpdater(){
        if (persistanceThread == null) {
            persistanceThread = new persistenceThread();
            persistanceThread.setDaemon(true);
            persistanceThread.start();
        }
    }

    private static class persistenceThread extends Thread {
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                comparator();
                try {
                    Thread.sleep((long) 2000);
                } catch (InterruptedException e) {
                    System.out.println("End");
                }
            }
        }
    }

//    public static void initListerners() {
//        EmployeeList = FXCollections.observableList(OM.getEmployees());
//        ProjectList = FXCollections.observableList(OM.getProjects());
//        TaskList = FXCollections.observableList(OM.getTasks());
//        WorkLogList = FXCollections.observableList(OM.getWorkLogs());
//        MessageList = FXCollections.observableList(OM.getMessages());
//
//        EmployeeList.addListener(new ListChangeListener<Employee>() {
//            public void onChanged(ListChangeListener.Change c) {
//                while (c.next()) {
//                    if(c.wasUpdated()){
//                        System.out.println("Updated: " + c);
//                    }
//                    else if (c.wasAdded()){
//                        System.out.println("Added: " + c);
//                    }
//                    else if(c.wasRemoved()){
//                        System.out.println("Removed: " + c);
//                    }
//                }
//            }
//        });
//    }

    private static void comparator(){
        if(OM != null) {

            boolean isManager = currentUser.position.equals("Manager");
            int groupID = currentUser.groupID;

            EmployeeList = OM.getEmployees();
            List<Project> projectList = OM.getProjects();
            List<Task> taskList = OM.getTasks();
            List<WorkLog> workLogList = OM.getWorkLogs();
            MessageList = OM.getMessages();

            Project newProj;
            Project oldProj;
            for (int i = 0; i < projectList.size(); i++) {
                newProj = projectList.get(i);
                if (ProjectList.size() > i) {
                    oldProj = ProjectList.get(i);
                    if (newProj.projectID == oldProj.projectID) {
                        ProjectList.set(i, newProj);
                        if (!newProj.name.equals(oldProj.name)) {
                            if (isManager || groupID == newProj.groupID) {
                                Dashboard.updateProjectLine(newProj);
                            }
                        }
                    } else {
                        if (projectList.size() > i + 1 && projectList.get(i + 1).equals(oldProj)) {
                            ProjectList.add(i, newProj);
                            if (isManager || groupID == newProj.groupID) {
                                Dashboard.insertProjectLine(newProj, projectList.get(i + 1));
                            }
                        } else {
                            ProjectList.remove(i);
                            i--;
                            if (isManager || groupID == newProj.groupID) {
                                Dashboard.removeProjectLine(oldProj);
                            }
                        }
                    }
                } else {
                    ProjectList.add(newProj);
                    if (isManager || groupID == newProj.groupID) {
                        Dashboard.addProjectLine(newProj);
                    }
                }
            }


            int userID = currentUser.employeeID;
            Task newTask;
            Task oldTask;
            for (int i = 0; i < taskList.size(); i++) {
                newTask = taskList.get(i);
                if (TaskList.size() > i) {
                    oldTask = TaskList.get(i);
                    if (newTask.taskID == oldTask.taskID) {
                        TaskList.set(i, newTask);
                        if (!newTask.name.equals(oldTask.name)) {
                            if (isManager || newTask.employees.contains(String.valueOf(userID))) {
                                Dashboard.updateTaskLine(newTask);
                            }
                        }
                    } else {
                        if (taskList.size() > i + 1 && taskList.get(i + 1).equals(oldTask)) {
                            TaskList.add(i, newTask);
                            if (isManager || newTask.employees.contains(String.valueOf(userID))) {
//                                Dashboard.insertTaskLine(newTask, taskList.get(i + 1));
                            }
                        } else {
                            TaskList.remove(i);
                            i--;
                            if (isManager || newTask.employees.contains(String.valueOf(userID))) {
                                Dashboard.removeTaskLine(oldTask);
                            }
                        }
                    }
                } else {
                    TaskList.add(newTask);
                    if (isManager || newTask.employees.contains(String.valueOf(userID))) {
                        Dashboard.addTaskLine(newTask);
                    }
                }
            }

            WorkLog newWorklog;
            WorkLog oldWorklog;
            if (WorkLogList.size() != workLogList.size()) {
                WorkLogList = workLogList;
                Dashboard.reRenderWorklogPanes();
            } else {
                for (int i = 0; i < workLogList.size(); i++) {
                    newWorklog = workLogList.get(i);
                    oldWorklog = WorkLogList.get(i);
                    if(oldWorklog.equals(newWorklog)){
                        WorkLogList = workLogList;
                        Dashboard.reRenderWorklogPanes();
                        break;
                    }

                }
            }
        }
    }

    public static void getServerData(OdinModel OM, String username) {/*
        List<Task> holdTasks;
        currentUser = OM.getEmployee_Username(username);
        ProjectList = OM.getProjects_GroupID(currentUser.groupID);
        TaskList = new ArrayList<>();
        for (Project project : ProjectList) {
            holdTasks = OM.getTasks_ProjectID(project.projectID);
            for(Task task : holdTasks) TaskList.add(task);
        }
        WorkLogList = OM.getWorkLogs_EmployeeID(currentUser.employeeID);
        MessageList = OM.getMessages_RecipientID(currentUser.recipientID);
    }*/

//        currentUser = OM.getEmployee_Username(username);
//        EmployeeList = OM.getEmployees();
//        ProjectList = OM.getProjects();
//        TaskList = OM.getTasks();
//        WorkLogList = OM.getWorkLogs();
//        MessageList = OM.getMessages();
    }
}

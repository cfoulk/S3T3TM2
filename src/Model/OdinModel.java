package Model;

import Server.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OdinModel implements OdinInterface
{
    OdinServer OS;

    public OdinModel() throws IOException, SQLException {
        OS = new OdinServer();
    }

    //Returns the employee's ID number on success.
    //Returns -1 if the username does not exist.
    //Returns -2 if the username exists, but the password is wrong.
    public int getUserID(String userName, String password) {
        Employee emp;
        try {
            emp = OS.getEmployee(userName);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        if (emp.passwordCheck(password)) return emp.employeeID;
        return -2;
    }

    public boolean editEmployee(int employeeID, String name, String position, int groupID, String username, String password)
    {
        Employee emp;
        try
        {
            emp = OS.getEmployee(employeeID);
            if(emp != null)
            {
                OS.editEmployee(employeeID, name, position, groupID, username, password);
                return true;
            }
        }
        catch(Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean editProject(int projectID, String name, String dueDate, int groupID, int projectLeadID, String description, String status) {
        return false;
    }

    public boolean editTask(int taskID, String name, String dueDate, int employeeID, int projectID, String description, int size) {
        return false;
    }

    public boolean editWorkLog(int logID, String employeeID, String entryType, int taskID, String description) {
        return false;
    }

    public boolean addEmployee(String name, String position, int groupID, String username, String password)
    {
        Employee emp;
        try
        {
            emp = OS.getEmployee(username);
            if (emp == null)
            {
                OS.addEmployee(name, position, groupID, username, password);
                return true;
            }
        }
        catch(Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean addProject(String name, String dueDate, int groupID, int projectLeadID, String description, String status)
    {
        Project proj;
        Employee lead;
        try
        {
            lead = OS.getEmployee(projectLeadID);
            if(lead != null && lead.position.compareTo("Project Lead") == 0)
            {
                OS.addProject(name, Date.valueOf(dueDate), groupID, projectLeadID, description, status);
                return true;
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean addTask(String name, String dueDate, int employeeID, int projectID, String description, int size) {
        return false;
    }

    public boolean addWorkLog(String employeeID, String entryType, int taskID, String description) {
        return false;
    }

    public Employee getEmployee(int employeeID) {
        Employee ret;
        try { ret = OS.getEmployee(employeeID); }
        catch (Exception e) { return null; }
        return ret;
    }

    public Project getProject(int projectID) {
        Project ret;
        try { ret = OS.getProject(projectID); }
        catch (Exception e) { return null; }
        return ret;
    }

    public Task getTask(int taskID) {
        Task ret;
        try { ret = OS.getTask(taskID); }
        catch (Exception e) { return null; }
        return ret;
    }

    public WorkLog getLog(int logID) {
        WorkLog ret;
        try { ret = OS.getWorkLog(logID); }
        catch (Exception e) { return null; }
        return ret;
    }

    public List<Employee> getEmployees() {
        List<Employee> ret;
        try { ret = OS.getEmployees(); }
        catch (Exception e) { return null; }
        return ret;
    }

    public List<Employee> getEmployeesGroup(int groupID) {
        List<Employee> ret;
        try { ret = OS.getEmployees(groupID); }
        catch (Exception e) { return null; }
        return ret;
    }

    public List<Project> getProjects() {
        List<Project> projects = null;
        try { projects = OS.getProjects(); }
        catch(Exception e) { return null; }
        return projects;
    }

    public List<Project> getProjectsGroup(int groupID) {
        return null;
    }

    public List<Project> getProjectsLead(int projectLeadID) {
        return null;
    }

    public List<Project> getProjectsStatus(String status) {
        return null;
    }

    public List<Task> getTasks() {
        return null;
    }

    public List<Task> getTasksProject(int projectID) {
        return null;
    }

    public List<Task> getTasksEmployee(int employeeID) {
        return null;
    }

    public List<WorkLog> getLogs() {
        return null;
    }

    public List<WorkLog> getLogsEmployee(int employeeID) {
        return null;
    }

    public List<WorkLog> getLogsTask(int taskID) {
        return null;
    }

    private void print() {
        //TODO shorter print statement
    }

    public void closeConnection()
    {
        try {
            OS.con.close();
            OS.stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
package Server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OdinServer
{
    final String FILENAME = "ServerInfo.txt";
    public Connection con;
    public Statement stmt;

    public OdinServer()
    {
        try
        {
            this.con = connect();
            this.stmt = con.createStatement();
        }
        catch(Exception e){ e.printStackTrace(); }
    }

    public Connection connect() throws Exception
    {
        StringTokenizer stk;
        Connection con;
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(FILENAME));
        stk = new StringTokenizer(reader.readLine(), "\t");
        con = DriverManager.getConnection(stk.nextToken(), stk.nextToken(), stk.nextToken());
        reader.close();
        return con;
    }

    public List<Employee> getEmployees() throws Exception
    {
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM employees;");
        List<Employee> employees = new ArrayList<>();
        while(myRS.next()) employees.add(new Employee(myRS));
        myRS.close();
        return employees;
    }

    public List<Employee> getEmployees(int groupID) throws Exception
    {
        List<Employee> ret = new ArrayList<>();
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM employees WHERE GroupID = " + groupID + ";");
        while(myRS.next()) ret.add(new Employee(myRS));
        myRS.close();
        return ret;
    }

    public Employee getEmployee(int employeeID) throws Exception
    {
        Employee ret;
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM employees WHERE EmployeeID = " + employeeID + ";");
        if(myRS.next())
        {
            ret = new Employee(myRS);
            this.stmt.close();
            myRS.close();
            return ret;
        }
        return null;
    }

    public Employee getEmployee(String username) throws Exception
    {
        Employee ret;
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM employees WHERE Username = '" + username + "';");
        if(myRS.next())
        {
            ret = new Employee(myRS);
            this.stmt.close();
            myRS.close();
            return ret;
        }
        return null;
    }

    public List<Project> getProjects() throws Exception
    {
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM projects;");
        List<Project> projects = new ArrayList<>();
        while(myRS.next()) projects.add(new Project(myRS));
        myRS.close();
        return projects;
    }

    public Project getProject(int projectID) throws Exception
    {
        Project ret;
        ResultSet myRS = this.stmt.executeQuery("SELCT * FROM projects WHERE ProjectID = " + projectID + ";");
        if(myRS.next())
        {
            ret = new Project(myRS);
            this.stmt.close();
            myRS.close();
            return ret;
        }
        return null;
    }

    public List<Task> getTasks() throws Exception
    {
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM tasks;");
        List<Task> tasks = new ArrayList<>();
        while(myRS.next()) tasks.add(new Task(myRS));
        myRS.close();
        return tasks;
    }

    public List<Task> getTasks(int projectID) throws Exception
    {
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM tasks WHERE ProjectID = " + projectID + ";");
        List<Task> tasks = new ArrayList<>();
        while(myRS.next()) tasks.add(new Task(myRS));
        myRS.close();
        return tasks;
    }

    public Task getTask(int taskID) throws Exception
    {
        Task ret;
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM tasks WHERE TaskID = " + taskID + ";");
        if(myRS.next())
        {
            ret = new Task(myRS);
            this.stmt.close();
            myRS.close();
            return ret;
        }
        return null;
    }

    public List<WorkLog> getWorkLogs() throws Exception
    {
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM worklogs;");
        List<WorkLog> workLogs = new ArrayList<>();
        while(myRS.next()) workLogs.add(new WorkLog(myRS));
        myRS.close();
        return workLogs;
    }

    public List<WorkLog> getWorkLogs(int employeeID) throws Exception
    {
        ResultSet myRS =
                this.stmt.executeQuery("SELECT * FROM worklog WHERE EmployeeID = " + employeeID + ";");
        List<WorkLog> workLogs = new ArrayList<>();
        while(myRS.next()) workLogs.add(new WorkLog(myRS));
        myRS.close();
        return workLogs;
    }

    public WorkLog getWorkLog(int workLogID) throws Exception
    {
        WorkLog ret;
        ResultSet myRS = this.stmt.executeQuery("SELECT * FROM worklogs WHERE LogID = " + workLogID + ";");
        if(myRS.next())
        {
            ret = new WorkLog(myRS);
            this.stmt.close();
            myRS.close();
            return ret;
        }
        return null;
    }

    public void addEmployee(String name, String position, int groupID, String username, String password) throws Exception
    {

        this.stmt.executeUpdate("INSERT INTO employees (Name, Position, GroupID, Username, Password) " +
                        "VALUES ('" + name + "', '" + position + "', " + groupID + ", '" + username + "', '" + password + "');");
        this.stmt.close();
    }

    public void addProject(String name, String dueDate, int groupID, int projectLeadID, String description, String status) throws Exception
    {
        this.stmt.executeUpdate("INSERT INTO projects (Name, DueDate, GroupID, ProjectLeadID, Description, Status) " +
                "VALUES ('" + name + "', '" + dueDate + ", " + groupID + ", " + projectLeadID + ", '" + description + "', '" + status + "');");
        this.stmt.close();
    }

    public void addTasks(String name, String dueDate, int employeeID, int projectID, String description, int size) throws Exception
    {
        this.stmt.executeUpdate("INSERT INTO tasks (Name, DueDate, ProjectID, EmployeeID, Description, Size) " +
            "VALUES ('" + name + "', '" + dueDate + "', " + projectID + ", " + employeeID + ", '" + description + "', '" + size + "');");
        this.stmt.close();
    }

    public void addWorkLog(String employeeID, String entryType, int taskID, String description) throws Exception
    {
        this.stmt.executeUpdate("INSERT INTO WorkLog (EmployeeID, EntryType, TaskID, Description) " +
            "VALUES (" + employeeID + ", '" + entryType + "', " + taskID + ", '" + description + "');");
        this.stmt.close();
    }


    //Edit functions
    public void editEmployee (int employeeID, String name, String position, int groupID, String username, String password) throws Exception
    {
        this.stmt.executeUpdate(  "UPDATE employees SET " +
                "Name = '" + name + "', " +
                "Position = '" + position + "', " +
                "GroupID =  " + groupID  + ", " +
                "Username =  '"  + username + "', " +
                "Password = '" + password + "', " +
                "WHERE EmployeeID = " + employeeID + ";");
        this.stmt.close();
    }

    public void editProject (int projectID, String name, String dueDate, int groupID, int projectLeadID, String description, String status) throws Exception
    {
        this.stmt.executeUpdate ( "UPDATE projects SET " +
                "Name = '" + name + "', " +
                "DueDate = " + dueDate + "', " +
                "GroupID = " + groupID + ", " +
                "ProjectLeadID = " + projectLeadID + ", " +
                "Description = '" + description + "', " +
                "Status = '" + status + "' " +
                "WHERE ProjectID = " + projectID + ";");
        this.stmt.close();
    }

    public void editTasks (int taskID, String name, String dueDate, int employeeID, int projectID, String description, int size) throws Exception
    {
        this.stmt.executeUpdate("Update tasks SET " +
                "Name = '" + name + "', " +
                "Duedate = '" + dueDate + "', " +
                "EmployeeID = " + employeeID + ", " +
                "ProjectID = " + projectID + ", " +
                "Description = '" + description + "', " +
                "Size = " + size + ", " +
                "WHERE TaskID = " + taskID + ";");
        this.stmt.close();
    }

    public void editWorkLog (int logID, String employeeID, String entryType, int taskID, String description) throws Exception
    {
        this.stmt.executeUpdate("UPDATE work log SET " +
                "EmployeeID = " + employeeID + ", " +
                "EntryType = '" + entryType + "', " +
                "TaskID = " + taskID + ", " +
                "Description = '" + description + "', " +
                "WHERE LogID = " + logID + ";" );
        this.stmt.close();
    }
}
import java.io.*;
import java.sql.*;
import java.util.*;

public class OdinModel
{
	//I'm being told that this needs to be static, anyone know why?
	final String FILENAME = "ServerInfo.txt";
	
	public static void main(String[] args) throws Exception
	{
		OdinModel OM = new OdinModel();
		OM.appMain(args);
	}
	
	public void appMain(String[] args)
	{
		Connection myConn = null;
		Statement myStmt = null;
		List<Employee> employees = new ArrayList<Employee>();
		try
		{
			myConn = connect();
			myStmt = myConn.createStatement();
			employees = getEmployees(myStmt);
			employees.forEach(p->System.out.println(p.employeeLine()));
			myConn.close();
			myStmt.close();
		}catch (Exception e){ e.printStackTrace(); } 
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
	
	List<Employee> getEmployees(Statement myStmt) throws Exception
	{
		ResultSet myRs = myStmt.executeQuery("SELECT * FROM employees;");
		List<Employee> employees = new ArrayList<Employee>();
		while(myRs.next()) employees.add(new Employee(myRs));
		myRs.close();
		return employees;
	}
}

class Employee
{
	int employeeID;
	int groupID;
	String name;
	String position;
	String password;
	
	Employee(ResultSet myRS) throws Exception
	{
		this.employeeID = myRS.getInt("EmployeeID");
		this.groupID = myRS.getInt("GroupID");
		this.name = myRS.getString("Name");
		this.position = myRS.getString("Position");
		this.password = myRS.getString("Password");
	}
	
	String employeeLine()
	{
		return (this.employeeID + "\t" + this.name + "\t" + this.position + "\t" + this.groupID);
	}
}

class Project
{
	
}

class Task
{
	
}

class WorkLog
{
	
}
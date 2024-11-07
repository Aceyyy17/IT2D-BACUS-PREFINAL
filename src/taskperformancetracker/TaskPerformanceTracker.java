package taskperformancetracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskPerformanceTracker {
    
    Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
    String response;
  
    do {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n----------------------------------------");
    System.out.print("| Task and Performance Tracker System   |");
    System.out.println("\n----------------------------------------");
    System.out.println("1. Add Employee");
    System.out.println("2. View Employees");
    System.out.println("3. Update Employee");
    System.out.println("4. Delete Employee");
    System.out.println("5. Add Task");
    System.out.println("6. View Tasks");
    System.out.println("7. Update Task");
    System.out.println("8. Delete Task");
    System.out.println("9. Assign Task to Employee");
    System.out.println("10. Exit");

    System.out.print("Enter Action: ");
    int action = sc.nextInt();
    
    TaskPerformanceTracker tracker = new TaskPerformanceTracker();

    switch (action) {
        
    case 1:
        
    tracker.viewEmployees();
    tracker.addEmployee();
    tracker.viewEmployees();
    break;
    
    case 2:
        
    tracker.viewEmployees();
    break;
    
    case 3:
        
    tracker.viewEmployees();
    tracker.updateEmployee();
    tracker.viewEmployees();
    break;
    
    case 4:
   
    tracker.viewEmployees();
    tracker.deleteEmployee();
    tracker.viewEmployees();
    break;
    
    case 5:
    tracker.viewTasks();    
    tracker.addTask();
    tracker.viewTasks();
    break;
    case 6:
        
    tracker.viewTasks();
    break;
    
    case 7:
    tracker.viewTasks();    
    tracker.updateTask();
    tracker.viewTasks();
    break;
    
    case 8:
    tracker.viewTasks();    
    tracker.deleteTask();
    tracker.viewTasks();
    break;
    
    case 9:
        
    tracker.assignTaskToEmployee();
    break;
    
    case 10:
        
    System.out.println("Exiting...");
    return;
    
    
    default:
    System.out.println("Invalid action. Please try again.");
    }

    System.out.print("Do you want to continue? (yes or no): ");
    response = sc.next();

    } while (response.equalsIgnoreCase("yes"));

    System.out.println("Thank you, for using the system!");
    }

    
    public void addEmployee() {
    Scanner sc = new Scanner(System.in);
    Config conf = new Config(); 
    System.out.print("Enter employee First name: ");
    String fname = sc.nextLine();
    System.out.print("Enter employee Last name: ");
    String lname = sc.nextLine();
    System.out.print("Enter employee age: ");
    int age = sc.nextInt();
    System.out.print("Enter employee salary: ");
    double salary = sc.nextDouble();
    sc.nextLine();

  
    String sql = "INSERT INTO tbl_employee (emp_fname, emp_lname, emp_age, emp_salary) VALUES (?, ?, ?, ?)";
    conf.addRecord(sql, fname, lname, age, salary);

    System.out.println("Employee added successfully!");
}


    
    public void viewEmployees() {
    Config conf = new Config();
    String votersQuery = "SELECT * FROM tbl_employee";
    String[] votersHeaders = {"Employee ID", "Employee First Name ", "Employee Last Name ", "Age", "Salary"};
    String[] votersColumns = {"emp_id", "emp_fname", "emp_lname", "emp_age", "emp_salary"};

    conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }

    
public void updateEmployee() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter employee ID to update: ");
    int id = sc.nextInt();
    sc.nextLine();
   
    System.out.print("Enter new First name: ");
    String newFname = sc.nextLine();
    System.out.print("Enter new Last name: ");
    String newLname = sc.nextLine();
    System.out.print("Enter new age: ");
    int newAge = sc.nextInt();
    System.out.print("Enter new salary: ");
    double newSalary = sc.nextDouble();
    sc.nextLine();
        
    System.out.println("Employee updated successfully!");

    String qry = "UPDATE tbl_employee SET emp_fname = ?, emp_lname = ?, emp_age = ?, emp_salary = ? WHERE emp_id = ?";
    Config conf = new Config();
    conf.updateRecord(qry, newFname, newLname, newAge, newSalary, id);
 
}


    
    public void deleteEmployee() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter employee ID to delete: ");
    int id = sc.nextInt();
    sc.nextLine();
        
    String qry = "DELETE FROM tbl_employee WHERE emp_id= ?";
    Config conf = new Config();
    conf.deleteRecord(qry, id);
    }
    
    public void addTask() {
    Scanner sc = new Scanner(System.in);
    Config conf = new Config();

    System.out.print("Enter task name: ");
    String taskName = sc.nextLine();
    System.out.print("Enter task d  escription: ");
    String taskDescript = sc.nextLine();
    System.out.print("Enter task status (e.g., Pending, In Progress, Completed): ");
    String taskStatus = sc.nextLine();

    String sql = "INSERT INTO tbl_task (task_name, task_descript, task_status) VALUES (?, ?, ?)";
    conf.addRecord(sql, taskName, taskDescript, taskStatus);

        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
    Scanner sc = new Scanner(System.in);
    Config conf = new Config();
        
        
    String taskQuery = "SELECT * FROM tbl_task";
    String[] taskHeaders = {"Task ID", "Task Name", "Task Description", "Task Status"};
    String[] taskColumns = {"task_id", "task_name", "task_descript", "task_status"};

    conf.viewRecords(taskQuery, taskHeaders, taskColumns);
    }

    public void updateTask() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter task ID to update: ");
    int taskId = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter new task name: ");
    String newTaskName = sc.nextLine();
    System.out.print("Enter new task description: ");
    String newTaskDescription = sc.nextLine();
    System.out.print("Enter new task status: ");
    String newTaskStatus = sc.nextLine();

    String qry = "UPDATE tbl_task SET task_name = ?, task_descript = ?, task_status = ? WHERE task_id = ?";
    Config conf = new Config();
    conf.updateRecord(qry, newTaskName, newTaskDescription, newTaskStatus, taskId);

    System.out.println("Task updated successfully!");
    }

    public void deleteTask() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter task ID to delete: ");
    int taskId = sc.nextInt();

    String qry = "DELETE FROM tbl_task WHERE task_id = ?";
    Config conf = new Config();
    conf.deleteRecord(qry, taskId);

    System.out.println("Task deleted successfully!");
    }

    public void assignTaskToEmployee() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter employee ID to assign task: ");
    int empId = sc.nextInt();
    System.out.print("Enter task ID to assign: ");
    int taskId = sc.nextInt();

    String qry = "INSERT INTO tbl_employee & tbl_task (emp_id, task_id) VALUES (?, ?)";
    Config conf = new Config();
    conf.addRecord(qry, empId, taskId);

    System.out.println("Task assigned to employee successfully!");
    }
}




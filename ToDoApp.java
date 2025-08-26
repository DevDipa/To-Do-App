import java.util.Scanner;

class Task {
    private int id;
    public String description;
    public String deadline;
    public String status;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static void welcomeMessage() {
        System.out.println("*****************************************");
        System.out.println("*Hello, there! Welcome to my To-do App:)*");  
        System.out.println("*****************************************"); 
        System.out.println();
    }

    public static int displayMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("-----------------------------------");
        System.out.println("|1. Create a task                 |");
        System.out.println("|2. View the list                 |");
        System.out.println("|3. Update the list               |");
        System.out.println("|4. Delete a task                 |");
        System.out.println("|5. Exit                          |");
        System.out.println("-----------------------------------");

        Scanner obj = new Scanner(System.in);

        System.out.print("Your choice (1-5):");
        int choice = obj.nextInt();
        obj.close();
        return choice;
    }

    public void createTask() {
        System.out.println("***************");
        System.out.println("*Create a Task*");
        System.out.println("***************");
        System.out.println();
        System.out.println("Please enter the following:");
        System.out.println("-----------------------------------");
        
        Scanner obj = new Scanner(System.in);

        System.out.print("Id:");
        setId(obj.nextInt());
        obj.nextLine();
        System.out.println("Description (max length: 25):");
        this.description = obj.nextLine();
        System.out.println("Deadline (yyyy/mm/dd):");
        this.deadline = obj.nextLine();
        System.out.println("Status (Pending/Done):");
        this.status = obj.nextLine();
        obj.close();
       
         
    }

    public static void viewList() {
        
    }

    public static void updateList() {
        
    }

    public static void deleteTask() {
        
    }

}


public class ToDoApp { 
    public static void main(String[] args) {
            Task.welcomeMessage();
            int choice = Task.displayMenu();
           

            switch(choice) {
            case 1: 
                Task objT = new Task();
                objT.createTask();
                break;

            case 2:
                Task.viewList();
                break;

            case 3:
                Task.updateList();
                break;

            case 4:
                Task.deleteTask();
                break;

            case 5:
                System.out.println();
                System.out.println("*****************************");
                System.out.println("*Have a good day! Toodles...*");
                System.out.println("*****************************");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input:(\n Redirecting you to the Main Menu...");
                Task.displayMenu();
            }
             
    }
}
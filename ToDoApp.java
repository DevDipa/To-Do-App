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

    public static void displayMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("-----------------------------------");
        System.out.println("|1. Create a task                 |");
        System.out.println("|2. View the list                 |");
        System.out.println("|3. Update the list               |");
        System.out.println("|4. Delete a task                 |");
        System.out.println("|5. Exit                          |");
        System.out.println("-----------------------------------");
        System.out.print("Your choice (1-5):");
    }

    public void createTask() {
              
         
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
            Task.displayMenu();
            
            Scanner obj = new Scanner(System.in);
            int choice = obj.nextInt();

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
            obj.close();      
    }
}
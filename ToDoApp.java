import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

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
        return choice;
    }

    public void createTask() {
        System.out.println();
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
       
        try {
            File file = new File("ToDoList.txt");

            if (file.length() == 0) {
            FileWriter writer1 = new FileWriter("ToDoList.txt");
            writer1.write("******************************To-Do******************************\n");
            writer1.write("_________________________________________________________________\n");
            writer1.write("| Id |          Description          |   Deadline    |  Status  |\n");
            writer1.write("_________________________________________________________________\n");
            writer1.close(); 
            }   
       } catch (IOException e) {
             System.out.println("Sorry, unable to adorn the file 'ToDoList.txt'. ERROR: " + e);
         } 


      try {
            FileWriter writer2 = new FileWriter("ToDoList.txt", true);
            writer2.write("| " + id + "  | " + description + "            | " + deadline + "    | " + status + "\n" );
            writer2.close(); 
            System.out.println("-----------------------------------");   
            System.out.println("Task added successfully!");
      } catch (IOException e) {
             System.out.println("Sorry, unable to write to the file 'ToDoList.txt'. ERROR: " + e);
        } finally {
               System.out.println("Exiting the program...");
               System.exit(1);
          }

     
    }

    public static void viewList() {
        
        try {
            File read = new File("ToDoList.txt");
            Scanner obj = new Scanner(read);

            while (obj.hasNextLine()) {
                String data = obj.nextLine();
                System.out.println(data);
            }
            obj.close();
            System.out.println("_________________________________________________________________");
            System.out.println("That's it for now:)");
        } catch (FileNotFoundException e) {
              System.out.println("Sorry, unable to read the list. ERROR: " + e);
          } finally {
                System.out.println("Exiting the program...");
                System.exit(1);
          }
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
                System.out.println("Invalid input:(\n Exiting the program...");
                Task.displayMenu();
            }
                
    }
}
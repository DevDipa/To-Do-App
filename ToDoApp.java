import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
        
 
    public void updateList() {
        System.out.println();
        System.out.println("*****************");
        System.out.println("*Update the List*");
        System.out.println("*****************");
        System.out.println();
        System.out.print("Please enter the Id of the task to update:");
        
        Scanner obj = new Scanner(System.in);
        String idUpdate = obj.nextLine();
        boolean idFound = false;

        ArrayList<String> lines = new ArrayList<>(); //to store the list's content

    try {
        File reader = new File("ToDoList.txt");
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] parts = data.split("\\|");

            if (parts.length > 1 && parts[1].trim().equals(idUpdate)) {
                idFound = true;

                System.out.println("\nHere's your task " + idUpdate + ":");
                System.out.println(data);

                Scanner update = new Scanner(System.in);
                System.out.print("New Id: ");
                String newId = update.nextLine();
                System.out.print("New description: ");
                String newDescription = update.nextLine();
                System.out.print("New deadline (yyyy/mm/dd): ");
                String newDeadline = update.nextLine();
                System.out.print("New status (Pending/Done): ");
                String newStatus = update.nextLine();

                data = "| " + newId + "  | " + newDescription + "            | " + newDeadline + "    | " + newStatus;
            }

            lines.add(data);
        }
        scanner.close();

        // to overwrite the list
        FileWriter writer = new FileWriter("ToDoList.txt");
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();

        if (idFound) {
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("There's no task with the id " + idUpdate + ".");
        }

    } catch (FileNotFoundException e) {
        System.out.println("Sorry, unable to retrieve the list. ERROR: " + e);
    } catch (IOException e) {
        System.out.println("Error updating file: " + e);
    } finally {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}

    public void deleteTask() {
        System.out.println();
        System.out.println("***************");
        System.out.println("*Delete a Task*");
        System.out.println("***************");
        System.out.println();
        System.out.print("Please enter the Id of the task to delete:");
        
        Scanner obj = new Scanner(System.in);
        String idDelete = obj.nextLine();
        boolean idFound = false;

        ArrayList<String> lines = new ArrayList<>(); 


    try {
        File reader = new File("ToDoList.txt");
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] parts = data.split("\\|");

            if (parts.length > 1 && parts[1].trim().equals(idDelete)) {
                idFound = true;

                System.out.println("\nHere's your task " + idDelete + ":");
                System.out.println(data);
                 System.out.println("_________________________________________________________________");
                System.out.print("Are you sure you want to delete? (y/n):");
                String str = obj.nextLine();
                if (str.equals("y")) {
                   continue;
                } 
            }

            lines.add(data);
        }
        scanner.close();

        FileWriter writer = new FileWriter("ToDoList.txt");
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();

        if (idFound) {
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("There's no task with the id " + idDelete + ".");
        }

    } catch (FileNotFoundException e) {
        System.out.println("Sorry, unable to retrieve the list. ERROR: " + e);
    } catch (IOException e) {
        System.out.println("Error deleting file: " + e);
    } finally {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
        
}

public class ToDoApp { 
    public static void main(String[] args) {
            Task.welcomeMessage();
            int choice = Task.displayMenu();
           
            Task task = new Task();

            switch(choice) {
            case 1: 
                task.createTask();
                break;

            case 2:
                Task.viewList();
                break;

            case 3:
                task.updateList();
                break;

            case 4:
                task.deleteTask();
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
                System.exit(0);
            }
                
    }
}
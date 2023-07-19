package vzap.com.views;

import java.util.Scanner;
import java.sql.Date;
import java.util.List;
import model.Client;
import vzap.com.controller.LibrarySystemController;

public class LibrarySystemView
{

    private Scanner input = null;
    private LibrarySystemController libSysC = null;

    public LibrarySystemView()
    {
        input = new Scanner(System.in);
        libSysC = new LibrarySystemController();
    }

    public void getMenuChoice()
    {
        while (true)
        {
            System.out.println("Welcome to the Library System!");

            System.out.println("\nPlease select an option:");
            System.out.println("1. Add Client");
            System.out.println("2. Update Client");
            System.out.println("3. Delete Client");
            System.out.println("4. Get Client By ID");
            System.out.println("5. Display All Clients");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline character

            switch (choice)
            {
                case 1:
                    addClient();
                    getMenuChoice();
                case 2:
                    updateClient();
                    getMenuChoice();
                case 3:
                    deleteClient();
                    getMenuChoice();
                case 4:
                    getClientById();
                    getMenuChoice();
                case 5:
                    displayAllClients();
                    getMenuChoice();
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option selected");
                    getMenuChoice();
            }
        }
    }

    public void addClient()
    {
        System.out.println("Enter new client details: ");
        System.out.print("Client ID: ");
        int clientID = input.nextInt();
        input.nextLine(); // consume newline character
        System.out.print("First name: ");
        String firstName = input.nextLine();
        System.out.print("Surname: ");
        String surname = input.nextLine();
        System.out.print("Date of birth (yyyy-mm-dd): ");
        String dobString = input.nextLine();
        Date dob = Date.valueOf(dobString);
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        Client client = new Client(clientID, firstName, surname, dob, username,
                password);
        String message = libSysC.addClient(client);
        System.out.println(message);
    }

    public void getClientByID()
    {
        System.out.print("Enter client ID: ");
        int clientID = input.nextInt();
        input.nextLine(); // consume newline character
        Client client = libSysC.getClientByID(clientID);
        if (client != null)
        {
            System.out.println("First name: " + client.getFirstName());
            System.out.println("Surname: " + client.getSurname());
            System.out.println("Date of birth: " + client.getDob());
            System.out.println("Username: " + client.getUsername());
            System.out.println("Password: " + client.getPassword());
        }
        else
        {
            System.out.println("No such client exists");
        }
    }

    public void displayAllClients()
    {
        System.out.println("All clients:");
        List<Client> clients = libSysC.getAllClients();
        for (Client client : clients)
        {
            System.out.println(client.toString());
        }
    }

    public void deleteClient()
    {
        System.out.println("Enter client ID for delete: ");
        System.out.print("Client ID: ");
        int clientID = input.nextInt();
        input.nextLine(); // consume newline character
        String message = libSysC.deleteClient(clientID);
        System.out.println(message);
    }

    public void updateClient()
    {

        System.out.println("Enter client ID for update: ");
        System.out.print("Client ID: ");
        int clientID = input.nextInt();
        input.nextLine(); // consume newline character
        Client client = libSysC.getClientByID(clientID);
        this.displayClient(client);
        System.out.println("*-----------------------------------------------*");
        System.out.println(
                "Now Add all the fields again changing those you wish to change.");
        System.out.print("First name: ");
        String firstName = input.nextLine();
        System.out.print("Surname: ");
        String surname = input.nextLine();
        System.out.print("Date of birth (yyyy-mm-dd): ");
        String dobString = input.nextLine();
        Date dob = Date.valueOf(dobString);
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        client = new Client(clientID, firstName, surname, dob, username,
                password);
        String message = libSysC.updateClient(client);
        System.out.println(message);
    }

    public void getClientById()
    {
        System.out.println("Enter client ID: ");
        System.out.print("Client ID: ");
        int clientID = input.nextInt();
        input.nextLine();
        Client client = libSysC.getClientByID(clientID);
        if (client != null)
        {
            this.displayClient(client);
        }
        else
        {
            System.out.println("No such client exists...");
        }
    }

    public void exit()
    {
        libSysC.exit();
    }

    private void displayClient(Client client)
    {
        System.out.println("Client details:");
        System.out.println("Client ID: " + client.getClientID());
        System.out.println("First name: " + client.getFirstName());
        System.out.println("Surname: " + client.getSurname());
        System.out.println("Date of birth: " + client.getDob());
        System.out.println("Username: " + client.getUsername());
        System.out.println("Password: " + client.getPassword());
    }

    public static void main(String[] args)
    {
        new LibrarySystemView().getMenuChoice();
    }
}

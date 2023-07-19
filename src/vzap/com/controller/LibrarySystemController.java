package vzap.com.controller;

import java.util.List;
import model.Client;
import vzap.com.daos.ClientDAO_Impl;

public class LibrarySystemController
{

    private ClientDAO_Impl clientDAO = null;
    private String message = null;

    public LibrarySystemController()
    {
        clientDAO = new ClientDAO_Impl();
    }

    public String addClient(Client client)
    {
        message = clientDAO.addClient(client);
        return message;
    }

    public String deleteClient(int clientID)
    {
        message = clientDAO.deleteClient(clientID);
        return message;
    }

    public String updateClient(Client client)
    {
        message = clientDAO.updateClient(client);
        return message;
    }

    public Client getClientByID(int clientID)
    {
        return clientDAO.getClientById(clientID);
    }

    public List<Client> getAllClients()
    {
        List<Client> clients;
        return clientDAO.getAllClients();
    }

    public void exit()
    {
        clientDAO.exit();
    }
}

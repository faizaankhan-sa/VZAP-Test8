package vzap.com.daos;

import java.util.List;
import model.Client;

public interface ClientDAO_Interface
{

    public String addClient(Client client);

    public String updateClient(Client client);

    public String deleteClient(int clientID);

    public Client getClientById(int id);

    public List<Client> getAllClients();

    public void exit();

}

//Faizaan Khan 3 May 2023

package vzap.com.daos;

//imports  4 marks
import model.Client;
import vzap.com.utils.MySQL_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClientDAO_Impl implements ClientDAO_Interface {

    private MySQL_Connection mySQLConnection = null;
    private Connection connection = null;
    private List<Client> list;

    public ClientDAO_Impl() // 4 marks
    {
        mySQLConnection = new MySQL_Connection();
        connection = mySQLConnection.getConnection();
    }

    @Override
    public String addClient(Client client) // 18 marks
    {
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO clients VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, client.getClientID());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getSurname());
            preparedStatement.setString(4, String.valueOf(client.getDob()));
            preparedStatement.setString(5, client.getUsername());
            preparedStatement.setString(6, client.getPassword());
            preparedStatement.executeUpdate();
            return "Client added successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Client not added";
        }
    }

    @Override
    public String updateClient(Client client) // 16 marks
    {
        PreparedStatement preparedStatement;
        String sql = "UPDATE clients SET firstName=?, surname=?, dob=?, username=?, password=? WHERE clientID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, String.valueOf(client.getDob()));
            preparedStatement.setString(4, client.getUsername());
            preparedStatement.setString(5, client.getPassword());
            preparedStatement.setInt(6, client.getClientID());
            preparedStatement.executeUpdate();
            return "Client updated successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Client not updated";
        }
    }

    @Override
    public String deleteClient(int clientID)// 7 marks
    {
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM clients WHERE clientID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, clientID);
            preparedStatement.executeUpdate();
            return "Client deleted successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Client not deleted";
        }
    }

    @Override
    public List<Client> getAllClients() // 14
    {
        String sql = "SELECT * FROM clients";
        List<Client> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                list.add(new Client(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }



    @Override
    public Client getClientById(int clientID) // 20
    {
        String sql = "SELECT * FROM clients WHERE clientID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,clientID);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            return new Client(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void exit() // 4
    {
        mySQLConnection.closeConnection();
    }
}   //Total 87



















package vzap.com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

public class BookDAO_Impl implements BookDAO_Interface
{

    private Connection connection;

    public BookDAO_Impl()
    {

    }

    @Override
    public List<Book> getAllBooks() throws SQLException
    {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try ( PreparedStatement statement = connection.prepareStatement(query);
              ResultSet resultSet = statement.executeQuery())
        {
            while (resultSet.next())
            {
                int isbn = resultSet.getInt("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                Book book = new Book(isbn, title, author, description);
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public Book searchBookByISBN(int isbn) throws SQLException
    {
        Book book = null;
        String query = "SELECT * FROM books WHERE isbn=?";
        try ( PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, isbn);
            try ( ResultSet resultSet = statement.executeQuery())
            {
                if (resultSet.next())
                {
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String description = resultSet.getString("description");
                    book = new Book(isbn, title, author, description);
                }
            }
        }
        return book;
    }

    @Override
    public void addBook(Book book) throws SQLException
    {
        String query
                = "INSERT INTO books (isbn, title, author, description) VALUES (?, ?, ?, ?)";
        try ( PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getDescription());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateBook(Book book) throws SQLException
    {
        String query
                = "UPDATE books SET title=?, author=?, description=? WHERE isbn=?";
        try ( PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getDescription());
            statement.setInt(4, book.getIsbn());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteBook(int isbn) throws SQLException
    {
        String query = "DELETE FROM books WHERE isbn=?";
        try ( PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, isbn);
            statement.executeUpdate();
        }
    }
}

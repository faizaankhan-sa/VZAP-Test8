package vzap.com.daos;

import java.sql.SQLException;
import java.util.List;
import model.Book;

public interface BookDAO_Interface
{

    void addBook(Book book) throws SQLException;

    void updateBook(Book book) throws SQLException;

    void deleteBook(int isbn) throws SQLException;

    Book searchBookByISBN(int isbn) throws SQLException;

    List<Book> getAllBooks() throws SQLException;
}

package model;

public class Book
{

    private int isbn;
    private String title;
    private String author;
    private String description;

    public Book(int isbn, String title, String author, String description)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public int getIsbn()
    {
        return isbn;
    }

    public void setIsbn(int isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", author="
                + author + ", description=" + description + '}';
    }

}

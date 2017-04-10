package bat.example;
// Generated 23-Feb-2017 18:35:49 by Hibernate Tools 3.5.0.Final

/**
 * BookInfo generated by hbm2java
 */
public class BookInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer bookId;
	private String name;
	private int edition;
	private String category;
	private String author;
	private String publisher;
	private int quantity;

	public BookInfo()
	{
	}

	public BookInfo(String name, int edition, String category, String author, String publisher, int quantity)
	{
		this.name = name;
		this.edition = edition;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public Integer getBookId()
	{
		return this.bookId;
	}

	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getEdition()
	{
		return this.edition;
	}

	public void setEdition(int edition)
	{
		this.edition = edition;
	}

	public String getCategory()
	{
		return this.category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getAuthor()
	{
		return this.author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getPublisher()
	{
		return this.publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public int getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

}
package bat.example;
// Generated 23-Feb-2017 18:35:49 by Hibernate Tools 3.5.0.Final

/**
 * Librarian generated by hbm2java
 */
public class Librarian implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int userId;
	private String name;
	private String password;
	private String email;

	public Librarian()
	{
	}

	public Librarian(int userId, String name, String password, String email)
	{
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public int getUserId()
	{
		return this.userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

}

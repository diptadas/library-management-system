package bat.example;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class DBOperation {

	public static boolean studentReg(int studentId, String name, String dept, String password, String email)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Student student = new Student(studentId, name, dept, password, email);

			session.persist(student);
			transaction.commit();

			session.close();

			return true;

		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public static Student checkStudentPass(int studentId, String password)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			Student student = (Student) session.get(Student.class, new Integer(studentId));

			session.close();

			if (student.getPassword().equals(password)) return student;
			else
				return null;

		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static Librarian checkLibrarianPass(int userId, String password)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			Librarian librarian = (Librarian) session.get(Librarian.class, new Integer(userId));

			session.close();

			if (librarian.getPassword().equals(password)) return librarian;
			else
				return null;

		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static boolean updateStudent(int studentId, String name, String password, String email)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Student student = (Student) session.get(Student.class, new Integer(studentId));

			if (student == null)
			{
				session.close();
				return false;
			}

			student.setName(name);
			student.setPassword(password);
			student.setEmail(email);

			session.persist(student);
			transaction.commit();

			session.close();

			return true;

		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateLibrarian(int userId, String name, String password, String email)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Librarian librarian = (Librarian) session.get(Librarian.class, new Integer(userId));

			if (librarian == null)
			{
				session.close();
				return false;
			}

			librarian.setName(name);
			librarian.setPassword(password);
			librarian.setEmail(email);

			session.persist(librarian);
			transaction.commit();

			session.close();

			return true;

		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<BookInfo> searchBook(String bookName)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			Criteria criteria = session.createCriteria(BookInfo.class).add(Restrictions.like("name", "%" + bookName + "%"));

			List<BookInfo> results = criteria.list();

			session.close();

			return results;

		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static boolean insertBook(String name, int edition, String category, String author, String publisher, int quantity)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			BookInfo bookInfo = new BookInfo(name, edition, category, author, publisher, quantity);

			session.persist(bookInfo);
			transaction.commit();

			session.close();

			return true;

		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public static boolean issueBook(int studentId, int bookId, Date dateIssue)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			BookInfo bookInfo = (BookInfo) session.get(BookInfo.class, new Integer(bookId));

			if (bookInfo.getQuantity() > 0)
			{
				bookInfo.setQuantity(bookInfo.getQuantity() - 1);
				session.persist(bookInfo);

				IssueInfo issueInfo = new IssueInfo(studentId, bookId, dateIssue);
				session.persist(issueInfo);

				transaction.commit();
				session.close();

				return true;
			}

			session.close();

			return false;

		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public static boolean returnBook(int studentId, int bookId, Date dateReturn)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			IssueInfo issueInfo = (IssueInfo) session.get(IssueInfo.class, new Integer(bookId));

			if (issueInfo != null && issueInfo.getDateReturn() == null)
			{
				BookInfo bookInfo = (BookInfo) session.get(BookInfo.class, new Integer(bookId));
				bookInfo.setQuantity(bookInfo.getQuantity() + 1);
				session.persist(bookInfo);

				issueInfo.setDateReturn(dateReturn);
				session.persist(issueInfo);

				transaction.commit();
				session.close();

				return true;
			}

			session.close();

			return false;

		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Object[]> studentStatus(int studentId)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			//Criteria criteria = session.createCriteria(BookInfo.class).add(Restrictions.eq("student_id", studentId)).add(Restrictions.eq("date_return", null));
			//List<IssueInfo> results = criteria.list();

			List<Object[]> results = session.createQuery("select a.bookId, b.name, a.dateIssue from IssueInfo a, BookInfo b where a.bookId = b.bookId and a.dateReturn is null and a.studentId = " + studentId).list();

			session.close();

			return results;

		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<IssueInfo> bookStatus(int bookId)
	{
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			Criteria criteria = session.createCriteria(IssueInfo.class).add(Restrictions.eq("bookId", bookId)).add(Restrictions.isNull("dateReturn"));

			List<IssueInfo> results = criteria.list();

			session.close();

			return results;

		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}

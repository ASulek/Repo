import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
	
	private List<Book> books;
	public static long idRef;
	
	public Library (){
		books = new ArrayList<>();
		idRef = 0;
	}
	
	// Add book to Library
	public void addBook(String titleR, int yearR, String authorR){
		//generate new ID
		idRef++;
		// Check if there are more copies of book with this title, year and author in library
		List<Book> foundBooks = books.stream()
				.filter(b -> b.getTitle().equalsIgnoreCase(titleR) && b.getYear() == yearR && b.getAuthor().equalsIgnoreCase(authorR))
				.collect(Collectors.toList());
		//If there is we add only id with new copy
		if(foundBooks.size()>0)
			foundBooks.get(0).addTheSameBook(idRef);
		// If there not exist this book we add to library first one
		else
			books.add(new Book(titleR, yearR, authorR, idRef));
	}
	
	// Remove book from Library by ID
	public boolean removeBookOfId(long idR){
		int i=0;
		boolean flag = false;
		// We are looking for book with idR
		while(i<books.size() && !flag){
			flag = books.get(i).getIdBookNameLend().containsKey(idR);
			if (!flag) i++;
		}
		if (flag){
			if(books.get(i).getIdBookNameLend().get(idR).equals("")){ // String"" means that book is not lent
				if(books.get(i).getIdBookNameLend().size()==1) // if there is only one copy of this book we remove book form Library
					books.remove(i);
				else{
					books.get(i).getIdBookNameLend().remove(idR); //if there are more copy of this book, we remove only this with idR
					books.get(i).setNumberOfAvailable(books.get(i).getNumberOfAvailable()-1);
				}
				System.out.println("\nBook is removed.");	
				return true;
			}
			else{
				System.out.println("\nIt is not possible to remove this book. It is currently lent.");
				return false;
			}
		}
		else{
			System.out.println("\nIt is not possible to remove this book. Book wiht this ID is not exist.");
			return false;
		}
	}
	
	//List all books in Library
	public void listBooks(){	
		System.out.println("\nList of books:");
		for(int i=0;i<books.size(); i++)
			System.out.println(i+1+". Title: " + books.get(i).getTitle() + ", Year: " + books.get(i).getYear() + ", Author: " + books.get(i).getAuthor() + ", Available books: " + books.get(i).getNumberOfAvailable() + ", Indexes of books: " + books.get(i).getIdBookNameLend().keySet());
	}
	
	//Find book by different criteria
	public List<Book> findBooks(String titleR, int yearR, String authorR){
		List<Book> results = books.stream()
								.filter(b -> b.getTitle().equalsIgnoreCase(titleR) && b.getYear() == yearR && b.getAuthor().equalsIgnoreCase(authorR))
								.collect(Collectors.toList());
		System.out.println("\nList of sarching by title, year and author:");
		for(int i=0; i<results.size(); i++)
			System.out.println(i+1+". Title: " + results.get(i).getTitle() + ", Year: " + results.get(i).getYear() + ", Author: " + results.get(i).getAuthor() + ", Available books: " + results.get(i).getNumberOfAvailable() + ", Indexes of books: " + results.get(i).getIdBookNameLend().keySet());
											
		return results;
	}
	public List<Book> findBooks(String titleR, int yearR){
		List<Book> results = books.stream()
								.filter(b -> b.getTitle().equalsIgnoreCase(titleR) && b.getYear() == yearR)
								.collect(Collectors.toList());
		System.out.println("\nList of sarchingby title and year:");
		for(int i=0; i<results.size(); i++)
			System.out.println(i+1+". Title: " + results.get(i).getTitle() + ", Year: " + results.get(i).getYear() + ", Author: " + results.get(i).getAuthor() + ", Available books: " + results.get(i).getNumberOfAvailable() + ", Indexes of books: " + results.get(i).getIdBookNameLend().keySet());
		
		return results;
	}
	public List<Book> findBooks(String titleR, String authorR){
		List<Book> results = books.stream()
								.filter(b -> b.getTitle().equalsIgnoreCase(titleR) && b.getAuthor().equalsIgnoreCase(authorR))
								.collect(Collectors.toList());
		System.out.println("\nList of sarching by title and author:");
		for(int i=0; i<results.size(); i++)
			System.out.println(i+1+". Title: " + results.get(i).getTitle() + ", Year: " + results.get(i).getYear() + ", Author: " + results.get(i).getAuthor() + ", Available books: " + results.get(i).getNumberOfAvailable() + ", Indexes of books: " + results.get(i).getIdBookNameLend().keySet());
												
		return results;
	}
	
	public List<Book> findBooks( int yearR, String authorR){
		List<Book> results = books.stream()
								.filter(b ->  b.getYear() == yearR && b.getAuthor().equalsIgnoreCase(authorR))
								.collect(Collectors.toList());
		System.out.println("\nList of sarching by year and author::");
		for(int i=0; i<results.size(); i++)
			System.out.println(i+1+". Title: " + results.get(i).getTitle() + ", Year: " + results.get(i).getYear() + ", Author: " + results.get(i).getAuthor() + ", Available books: " + results.get(i).getNumberOfAvailable() + ", Indexes of books: " + results.get(i).getIdBookNameLend().keySet());
												
		return results;
	}
	public List<Book> findBooks(String titleR){
		List<Book> results = books.stream()
								.filter(b -> b.getTitle().equalsIgnoreCase(titleR) )
								.collect(Collectors.toList());
		System.out.println("\nList of sarching by title:");
		for(int i=0; i<results.size(); i++)
			System.out.println(i+1+". Title: " + results.get(i).getTitle() + ", Year: " + results.get(i).getYear() + ", Author: " + results.get(i).getAuthor() + ", Available books: " + results.get(i).getNumberOfAvailable() + ", Indexes of books: " + results.get(i).getIdBookNameLend().keySet());
												
		return results;
	}
	
	public List<Book> findBooks(int yearR){
		List<Book> results = books.stream()
								.filter(b ->  b.getYear() == yearR)
								.collect(Collectors.toList());
		System.out.println("\nList of sarching by year:");
		for(int i=0; i<results.size(); i++)
			System.out.println(i+1+". Title: " + results.get(i).getTitle() + ", Year: " + results.get(i).getYear() + ", Author: " + results.get(i).getAuthor() + ", Available books: " + results.get(i).getNumberOfAvailable() + ", Indexes of books: " + results.get(i).getIdBookNameLend().keySet());
												
		return results;
	}
	
	public List<Book> findBooksByAuthor(String authorR){
		List<Book> results = books.stream()
								.filter(b -> b.getAuthor().equalsIgnoreCase(authorR))
								.collect(Collectors.toList());
		System.out.println("\nList of sarching by author:");
		for(int i=0; i<results.size(); i++)
			System.out.println(i+1+". Title: " + results.get(i).getTitle() + ", Year: " + results.get(i).getYear() + ", Author: " + results.get(i).getAuthor() + ", Available books: " + results.get(i).getNumberOfAvailable() + ", Indexes of books: " + results.get(i).getIdBookNameLend().keySet());
								
		return results;
	}
	
	// Lend book by get ID of book and name of person, who want to lend
	public boolean lendBookOfId(long idR, String name){
		int i=0;
		boolean flag = false;
		while(i<books.size() && !flag){
			flag = books.get(i).getIdBookNameLend().containsKey(idR);
			if (!flag) i++;
		}
		if (flag){
			if(books.get(i).getIdBookNameLend().get(idR).equals("")){ // String"" means that book is not lent
				books.get(i).getIdBookNameLend().put(idR,name); 
				books.get(i).setNumberOfAvailable(books.get(i).getNumberOfAvailable()-1);
				System.out.println("\n" + name + " lent book of ID: " + idR);	
				return true;
			}
			else{
				System.out.println("\nIt is not possible to lend book with ID: "+ idR + ". It is currently lent by " + books.get(i).getIdBookNameLend().get(idR) +".");
				return false;
			}
		}
		else{
			System.out.println("\nIt is not possible to lend book with ID: "+ idR + ". Book wiht this ID is not exist.");
			return false;
		}
	}

	public void seeDetailsOfBookById(long idR){
		int i=0;
		boolean flag = false;
		while(i<books.size() && !flag){
			flag = books.get(i).getIdBookNameLend().containsKey(idR);
			if (!flag) i++;
		}
		if (flag)
			System.out.println("\nDatails of book with ID: " + idR+ "\nTitle: " + books.get(i).getTitle()  + ", Author: " + books.get(i).getAuthor() + ", Year: " + books.get(i).getYear()+ (books.get(i).getIdBookNameLend().get(idR).equals("")?", is available.":". Not available. Lent by "+books.get(i).getIdBookNameLend().get(idR) +"." ) );
		else
			System.out.println("\nBook whith this ID is not exist.");
	}

}

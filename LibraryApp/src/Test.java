
public class Test {
	
	public static void main(String[] args){
		
		// Create the Library
		Library MyLibrary = new Library();
		
		//Add new books
		MyLibrary.addBook("Charlie And The Chocolate Factory", 2012, "Roald Dahl");
		MyLibrary.addBook("The Hobbit", 2012, "John Ronald Reuel Tolkien");
		MyLibrary.addBook("The Hobbit", 2012, "John Ronald Reuel Tolkien");
		MyLibrary.addBook("The Hobbit", 2012, "John Ronald Reuel Tolkien");
		MyLibrary.addBook("The Lord Of The Rings", 2013, "John Ronald Reuel Tolkien");
		MyLibrary.addBook("The Lord Of The Rings", 2013, "John Ronald Reuel Tolkien");
		MyLibrary.addBook("Pride and Prejudice", 2010, "Jane Austen");
		MyLibrary.addBook("Pride and Prejudice", 2012, "Jane Austen");
		MyLibrary.addBook("Sense and Sensibility", 2013, "Jane Austen");
		MyLibrary.addBook("Emma", 2013, "Jane Austen");
		MyLibrary.addBook("Winnie the Pooh", 2008, "Alan Alexander Milne");
		MyLibrary.addBook("Winnie the Pooh", 2008, "Alan Alexander Milne");
		MyLibrary.addBook("Winnie the Pooh", 2012, "Alan Alexander Milne");
		MyLibrary.addBook("The Count of Monte Cristo", 2011, "Alexandre Dumas");
		MyLibrary.addBook("Jane Eyre", 2006, "Charlotte Bronte");
		MyLibrary.addBook("Alice's Adventures In Wonderland", 2015, "Lewis Carroll");
		MyLibrary.addBook("Anne Of Green Gables", 2016, "LM Montgomery");
		MyLibrary.addBook("A Christmas Carol", 2010, "Charles Dickens");
		MyLibrary.addBook("A Tale Of Two Cities", 2018, "Charles Dickens");
		MyLibrary.addBook("Don Quixote", 2009, "Miguel De Cervantes");
		MyLibrary.addBook("Robinson Crusoe", 2011, "Daniel Defoe");
		MyLibrary.addBook("Gulliver's Travels", 2012, "Jonathan Swift");
		
		//List all book in Library
		MyLibrary.listBooks();
		
		//Search by different criteria
		MyLibrary.findBooks("The Lord Of The Rings", 2013, "John Ronald Reuel Tolkien"); //find by title, year, author
		MyLibrary.findBooks(2013, "Jane Austen"); //by year and author
		MyLibrary.findBooks("Winnie the Pooh"); // find by title
		MyLibrary.findBooksByAuthor("Jane Austen"); //find by author
		MyLibrary.findBooks(2012); //find by year
		MyLibrary.findBooks(1990); //not exist
		
		
		//Lend a book
		MyLibrary.lendBookOfId(2, "Anna Lucia");
		MyLibrary.lendBookOfId(2, "Mark Swing"); //try to lend book with is already lent
		
		//Remove book
		MyLibrary.removeBookOfId(2);
		MyLibrary.removeBookOfId(100);
		MyLibrary.removeBookOfId(19);
		
		//See details of the book
		MyLibrary.seeDetailsOfBookById(2); //is lent
		MyLibrary.seeDetailsOfBookById(18); //is not lent
		MyLibrary.seeDetailsOfBookById(100); //is not exist
		
		
	}

}

import java.util.HashMap;
import java.util.Map;


public class Book {
	private String title;
	private int year;
	private String author;
	private Map<Long, String> idBookNameLend; // Id of book and name of person who lent. If book is available String is ""
	private int numberOfAvailable;
	private int numberOfLend;
	
	public Book(String titleR, int yearR, String authorR, long idR ){
		title = titleR;
		year = yearR;
		author = authorR;
		idBookNameLend = new HashMap<>();
		idBookNameLend.put(idR, "");
		setNumberOfAvailable(1);
		setNumberOfLend(0);
	}
	
	// If there is another copy of the same book (the same title, year, author) add id of new copy
	public void addTheSameBook(long idR){
		idBookNameLend.put(idR, "");  //set that book is not lend
		numberOfAvailable++;
	}
	
	// getter and setter
	public Map<Long, String> getIdBookNameLend(){
		return idBookNameLend;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfAvailable() {
		return numberOfAvailable;
	}

	public void setNumberOfAvailable(int numberOfAvailable) {
		this.numberOfAvailable = numberOfAvailable;
	}

	public int getNumberOfLend() {
		return numberOfLend;
	}

	public void setNumberOfLend(int numberOfLend) {
		this.numberOfLend = numberOfLend;
	}

}

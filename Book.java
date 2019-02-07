/*
 *Nicholas Trujillo
 *January 28, 2019
 *CS 272
 *Lab Assignment #1
 */


public class Book {
	
	private String BookTitle;
	private int AuthorNumber;
	private String[] BookAuthor; 
	private String ISBN;
	
public Book() {
	BookTitle = null;
	ISBN = null;
	AuthorNumber = 0;
	BookAuthor = new String[3];
}
public Book (String _title) {
	BookTitle = _title;
	ISBN = null;
	AuthorNumber = 0;
	BookAuthor = new String[3];
}
public Book (Object obj) {
	if(obj != null) {
		if(obj instanceof Book) {
			Book Book1 = (Book)obj;
			BookTitle = Book1.getTitle();
			AuthorNumber = Book1.getAuthorNumber();
			for(int x = 0; x < 3; x++) {
				BookAuthor[x] = Book1.BookAuthor[x];
			}
			ISBN = Book1.getISBN();
		}
	}
}


	

public String getTitle() {
	return BookTitle;
}
public int getAuthorNumber() {
	return AuthorNumber;
}
public String getISBN() {
	return ISBN;
}
public void setBookTitle(String _title) {
	BookTitle = _title;
}
public void setISBN(String _isbn) {
	ISBN = _isbn;
}

//AddAuthor Method
public boolean addAuthor (String _author) {
	
	if(AuthorNumber < 3) {
		BookAuthor[AuthorNumber]= _author;
		AuthorNumber++;
		return true;
	}
	else {
		return false;
	}
}

//Equals Method
public boolean equals(Object obj) {
	if(obj instanceof Book) {
		Book book = (Book)obj;
		return(book.ISBN == ISBN);
	}
	else {
		return false;
	}
}
//getAllAuthors Method
public static String[] getAllAuthors(Book b1, Book b2) {
	String[] tempArray = new String[6];
	
	for(int x = 0; x < b1.getAuthorNumber(); x++) {
		tempArray[x]= b1.BookAuthor[x];
	}
	for(int x = 0; x < b2.getAuthorNumber(); x++) {
       if(tempArray[x].equals(b2.BookAuthor[x])) {
    	   tempArray[x]= b2.BookAuthor[x];
       }else {
    	   tempArray[tempArray.length-1-x]=b2.BookAuthor[x];
       }
      }
	return tempArray;
     }

// toString Method
public String toString() {
	return "Title: " + BookTitle + "\n" + "ISBN: " + ISBN + "\n" + "Number of Authors: " + AuthorNumber + "\n" + "Author(s): " + this.BookAuthor[0] + " " + this.BookAuthor[1] + " " + this.BookAuthor[2]; 
	}


//Main Method
public static void main(String[]args) {
	Book book1 = new Book("One");
	Book book2 = new Book("Two");
	Book book3 = new Book("Three");
	
	//Setting the ISBN
	book1.setISBN("1366206");
	book2.setISBN("800635946");
	book3.setISBN("1366206");
	
	//Setting the Book Titles
	book1.setBookTitle("Love, Simon");
	book2.setBookTitle("Harry Potter");
	
	//Adding Authors to the book objects
	book1.addAuthor("Becky Albertalli");
	book1.addAuthor("Nick Robinson");
	book2.addAuthor("J. K. Rowling");
	book2.addAuthor("Daniel Radcliffe");
	
	//Testing the toString method.
	System.out.println("Testing the toString method:");
	System.out.println(book1.toString());
	System.out.println();
	System.out.println(book2.toString());
	System.out.println();
	
	//Testing the getAllAuthors method
	System.out.println("Testing the getAllAuthors method:");
	for(int x= 0; x < 6; x++) {
		System.out.println(getAllAuthors(book1,book2)[x]);
	}
	//Testing the equals method
	System.out.println();
	System.out.println("Testing the equals method:");
	System.out.println(book1.equals(book2));
	System.out.println(book1.equals(book3));

  }
}
	
	
	
	


/**
 * Implements a Library Object that acts as an array to hold Book objects with helper methods.
 * An array type Book is created to hold books in a single array.
 * There are methods to interact with Library and the Books stored inside.
 * Library is a growable bad data structure with an initial capacity of 4 that
 * grows automatically.
 * @author Sahreb Aamir
  */

public class Library {
         private Book[] books; // array-based implementation of the bag data structure
         private int numBooks; // the number of books currently in the bag
         private static final int DEFAULT_SIZE = 4; // Creating constant for size of array and its constant increment
         private static final int SERIAL_NUMBER = 10001; // initial serial number
         public static final int FEBDAY = 28;

    /**
     * Default constructor for creating a Library object.
     * A Library is an array that holds Book Objects.
     * It starts with an initial size of 4 with zero books.
     */
    public Library()
        {
                this.books = new Book[DEFAULT_SIZE];
                this.numBooks = 0;

        }

    /**
     * Method to find a book's index within the Library array.
     * Given a book find() looks for the index of the Book within
     * current Library array of Books that matches the given Book's
     * serial number.
     * @param book is passed a Book Object
     * @return integer value of index of book within Library array.
     */
    private int find(Book book)
        {
            for (int i=0; i<this.books.length; i++){
                if(this.books[i].equals(book)){
                    return i;
                }
            }
            return -1;

        }

    /**
     * Method used to increase the size of the Library array by four.
     * grow() creates a new array that is four indexes larger
     * than the previous array.
     */
    private void grow()
        {
                Book[] increase = new Book[this.numBooks + DEFAULT_SIZE];       //Create new array that is size of previous array plus 4
                for(int i = 0; i< this.books.length; i++){
                        increase[i]=this.books[i];
                }                                                               //Copy old array in new larger array
                this.books = increase;                                          //Change pointer of old array to pointer to the new array

        }

    /**
     * Allows other classes to get the starting serial number for this library.
     * @return integer of starting serial number.
     */
    public int getSerialNumber(){
             return SERIAL_NUMBER;
        }


    /**
     * Allows other classes to access the array that holds the Book Objects.
     * @return Book array that holds the books in the Library.
     */
    public Book[] getBooks(){
             return books;
        }

    /**
     * Adds a Book object to the Book array Library.
     * @param book is passed that will be added to the Library.
     */
    public void add(Book book)
        {

            for (int i=0; i < this.books.length; i++) {
                if(this.books[i] == null){
                    break;
                }
                if (i == this.books.length - 1) {
                    grow();
                }// if i gets to the end of array without find a null spot, create a larger array
            }// Make sure Book array is not full before adding another book
            for( int i=0; i<this.books.length; i++){
                if(this.books[i] == null){
                    this.books[i] = book;
                    numBooks++;
                    break;
                }
            } // Find first spot in array that is empty and place new book there
        }

    /**
     * Allows other classes to get the number of books within the Library.
     * @return integer of books within the library.
     */
    public int getNumBooks(){
             return numBooks;
        }

    /**
     * Shifts the null spot within the Book array to the end of the array.
     * Moves all books after the null spot down one index within the array.
     * @param deleted integer index value where remove created a null index.
     */
    public void shift(int deleted)
        {
            for(int i = deleted; i < this.books.length-1 ; i++){
                this.books[i]=this.books[i+1];
                this.books[i+1] = null;
            }
        }

    /**
     * Removes a book from the array.
     * Find the book's index using find.
     * Deletes the Book object from its index and replaces it with null.
     * decreases number of books by one if successful.
     * @param book Passed Book Object that will be deleted.
     * @return true if successful, return false if cannot find book.
     */
    public boolean remove(Book book)
        {
            int i= find(book);
            if(i==-1){
                return false;   //couldn't find the book
            }
            this.books[i]=null;
            shift(i);
            numBooks--;
            return true;

        }//Checks if book exist, according to serial number, if it does make spot null, shift books, then return true, else not true

    /**
     * Checks if book is checked out or not.
     * If not checked out then checks it out.
     * @param book Passed Book object that is requested to be checked out.
     * @return true if checked out. False if not found or already checked out.
     */
    public boolean checkOut(Book book)
        {
            if(book.getCheckedOut()){
                return false;
            }//if book is checked out return false
            else {
                book.setCheckedOut(true);
                return true;
            }//if book not checked out then set book to checked out and return true

        }

    /**
     *Attempts to return the passed book back into the library.
     * Checks the book in the library and checks the status of checked out.
     * @param book Book object that holds the checkedOut variable.
     * @return true if the book was successfully returned, false is book doesnt exist or never checked out.
     */
    public boolean returns(Book book)
        {
            if(book.getCheckedOut()){
                book.setCheckedOut(false);
                return true;
            }//returns book and unchecks it out.
            else{
                return false;
            }//book was no checked out so cannot return it

        }

    /**
     * Prints all books in library in current order to terminal.
     */
    public void print()
        {
            for(int i =0; i<numBooks; i++){
                System.out.println(this.books[i].toString());
            }
        } //print the list of books

    /**
     * Print the list of books by datePublished (ascending).
     * First sort the library in ascending order then print
     * to terminal.
     */
    public void printByDate()
        {
            int n = numBooks;
            Book temp;
                for (int i = 0; i < n; i++) {
                    for (int j = 1; j < (n - i); j++) {
                        if (this.books[j - 1].getDatePublished().getYear() > this.books[j].getDatePublished().getYear()) { //if year greater
                            temp = this.books[j - 1];
                            this.books[j - 1] = this.books[j];
                            this.books[j] = temp;
                        }
                        if (this.books[j - 1].getDatePublished().getYear() == this.books[j].getDatePublished().getYear()) {
                            if (this.books[j - 1].getDatePublished().getMonth() > this.books[j].getDatePublished().getMonth()) {    //if month greater of same year
                                temp = this.books[j - 1];
                                this.books[j - 1] = this.books[j];
                                this.books[j] = temp;
                            }
                            if (this.books[j - 1].getDatePublished().getMonth() == this.books[j].getDatePublished().getMonth()) {
                                if (this.books[j - 1].getDatePublished().getDay() > this.books[j].getDatePublished().getDay()) {    //if day greater of same month and year
                                    temp = this.books[j - 1];
                                    this.books[j - 1] = this.books[j];
                                    this.books[j] = temp;
                                }
                            }
                        }
                    }
                }
            print();

        }

    /**
     * Prints the list of books by serial number (ascending).
     * First sort library in ascending serial number of books
     * then print to terminal.
     */
    public void printByNumber()
        {
            int n =numBooks;
            for(int i=1; i<n;++i){
                Book key = this.books[i];
                int j =i-1;
                while(j>=0 && Integer.parseInt(this.books[j].getNumber())>Integer.parseInt(key.getNumber())){
                    this.books[j+1]=this.books[j];
                    j--;
                }
                this.books[j+1]=key;
            }
            print();

        }//print the list of books by number (ascending)

}

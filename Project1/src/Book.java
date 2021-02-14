/**
 * Implements an Encapsulated Book object with helper methods.
 * The book object holds its own serial number, name of the book,
 * status if book is checked out, and the date the book was published.
 * This class also has a helper method leapYear() and two overridden
 * methods equals() and toString().
 * @author Sahreb Aamir
 */
public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;
    private static final int QUARTER = 4;
    private static final int CENTURY= 100;
    private static final int QUADRICENTENNIAL = 400;

    /**
     * Constructor for Book object with no parameters.
     * Only checkedOut is explicitly set to false
     * within the constructor.
     */
    public Book()
    {
        this.checkedOut=false;

    }

    /**
     * Helper method for calculating if it is a leap year.
     * A year is given and the method will calculate
     * if the year is a leapYear or not.
     * @param year to be checked for leap year.
     * @return true if it is a leap year, false if not a leap year.
     */
    public static boolean leapYear(int year){
        if(year%QUARTER==0){
            if(year%CENTURY==0){
                if(year%QUADRICENTENNIAL==0) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    /**
     * Allows other classes to access the book's serial number.
     * @return the number of the book.
     */
    public String getNumber(){
        return number;
    }

    /**
     * Allows other classes to access the book's name.
     * @return the name of the book
     */
    public String getName(){
        return name;
    }

    /**
     * Allows other classes to access the books checked out status.
     * @return if checked out, false if not checked out.
     */
    public boolean getCheckedOut(){
        return checkedOut;
    }

    /**
     * Allows other classes to access the books published date.
     * @return Date Object that holds date published information.
     */
    public Date getDatePublished(){
        return datePublished;
    }

    /**
     * Allows other classes to set the serial number of the book.
     * @param sNum String number that will be the new book serial number.
     */
    public void setNumber(String sNum){
        number = sNum;
    }

    /**
     * Allows other classes to set the name of the book.
     * @param sName String name that will become the name of the book.
     */
    public void setName(String sName){
        name= sName;
    }

    /**
     * Allows other classes to set the checked out status of the book.
     * @param sCheckedOut boolean value to set if book is checked out or not.
     */
    public void setCheckedOut(boolean sCheckedOut){
        checkedOut= sCheckedOut;
    }

    /**
     * Allows other classes to set the Date Published of the book.
     * @param sDatePublished Date Object that contains the year,month, and day.
     */
    public void setDatePublished(Date sDatePublished){
        datePublished = sDatePublished;
    }

    /**
     * Checks if two books objects have the same serial code.
     * @param obj passed a pointer to a book object.
     * @return true if serial code of two books are the same, false otherwise.
     */
    @Override
    public boolean equals(Object obj)
    {
        Book temp = (Book) obj;
        int num1 = Integer.parseInt(this.number);
        int num2 = Integer.parseInt(temp.number);
        if(num1==num2){
            return true;
        }
        return false;
    }

    /**
     * Used to convert all the information of the Book object into a string.
     * @return String containing all the information of the book separated by ::
     */
    @Override
    public String toString() {
        if (checkedOut) {
            return "Book#" + this.number + "::" + this.name + "::" + this.datePublished.getMonth() + "/" + this.datePublished.getDay() + "/" + this.datePublished.getYear() + "::" + "is checked out.";
        } else {
            return "Book#" + this.number + "::" + this.name + "::" + this.datePublished.getMonth() + "/" + this.datePublished.getDay() + "/" + this.datePublished.getYear() + "::" + "is available.";
        }
    }
}

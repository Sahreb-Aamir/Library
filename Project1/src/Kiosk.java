import java.util.Scanner;

/**
 * The interface class for the user. Contains the run method
 * which will be used for taking input from the user
 * and processing user commands.
 * @author Sahreb Aamir
 */
public class Kiosk {

    /**
     * Process command lines from the console and provide library services.
     * Uses methods and variables within the Library, Book, and Date classes
     * to complete the requests from the command line. Can take input to
     * Add, Remove, Checkout, Return, and Print list of books within library.
     */
    public void run() {
        Scanner scan = new Scanner(System.in);
        Library lib = new Library();
        int serialNumber = lib.getSerialNumber();


        while (true) {

            String input;
            if (scan.hasNextLine()) {
                input = scan.nextLine();
            } else {
                continue;
            }// checks if line has data, if it doesn't then nothing happens.



            String[] str = input.split(","); //Split the next line by the ,'s
            int tokens = input.split(",").length; //# of tokens



            if (str[0].equals("A")) {               //to add books into library
                if(tokens==2){                      //if no date provided
                    Book book = new Book();
                    book.setName(str[1]);
                    Date date = new Date();
                    if(!date.isValid()) {
                        System.out.println("Invalid Date!");
                        continue;
                    }
                    book.setDatePublished(date);
                    book.setNumber(Integer.toString(serialNumber));
                    serialNumber++;
                    lib.add(book);
                    System.out.println(str[1] + " added to the library.");
                    continue;
                }
                else if(tokens==3){
                    Book book = new Book();
                    book.setName(str[1]);
                    Date date = new Date(str[2]);
                    if(!date.isValid()) {
                        System.out.println("Invalid Date!");
                        continue;
                    }
                    book.setDatePublished(date);
                    book.setNumber(Integer.toString(serialNumber));
                    serialNumber++;
                    lib.add(book);
                    System.out.println(str[1] + " added to the library.");
                    continue;
                }
                else{
                    System.out.println("Invalid command!");
                    continue;
                }

            }

            else if (str[0].equals("R")) {
                boolean rCheck = false;
                boolean rException = false;
                if(tokens==2) {
                    for (int j = 0; j < lib.getBooks().length; j++) {
                        try {
                            if (Integer.parseInt(lib.getBooks()[j].getNumber()) == Integer.parseInt(str[1])) { //if we find the book then remove
                                boolean check = lib.remove(lib.getBooks()[j]);
                                if (check) {                                                                   //removed successfully
                                    System.out.println("Book#" + str[1] + " removed.");
                                    rCheck = true;
                                    break;
                                }
                            }
                        }
                        catch (NullPointerException e){
                            System.out.println("Unable to remove, the library does not have this book.");
                            rException = true;
                            break;
                        }
                    }
                    if (!rCheck && !rException) {
                        System.out.println("Unable to remove, the library does not have this book.");    //if book not found
                        continue;

                    }
                }
                else{
                    System.out.println("Invalid Command.");
                    continue;
                }

            }






            else if (str[0].equals("O")){
                boolean oCheck = false;
                boolean oException = false;
                if(tokens ==2){
                    for(int j = 0; j< lib.getBooks().length; j++ ){
                        try {
                            if (Integer.parseInt(lib.getBooks()[j].getNumber()) == Integer.parseInt(str[1])) { //if we find the book then remove
                                boolean check = lib.checkOut(lib.getBooks()[j]);
                                if (check) {                                                                   //removed successfully
                                    System.out.println("You've checked out Book#" + str[1] + ". Enjoy!");
                                    oCheck = true;
                                    break;
                                }
                            }
                        }catch (NullPointerException e){
                            System.out.println("Book#"+str[1]+" is not available.");
                            oException = true;
                            break;
                        }
                    }
                    if (!oCheck && !oException) {
                        System.out.println("Book#"+str[1]+" is not available.");    //if book not found
                        continue;

                    }
                }
                else{
                    System.out.println("Invalid Command.");
                    continue;
                }
            }





            else if (str[0].equals("I")){
                boolean iCheck = false;
                boolean iException = false;
                if(tokens ==2){
                    for(int j = 0; j< lib.getBooks().length; j++ ){
                        try {
                            if (Integer.parseInt(lib.getBooks()[j].getNumber()) == Integer.parseInt(str[1])) { //if we find the book then remove
                                boolean check = lib.returns(lib.getBooks()[j]);
                                if (check) {                                                                   //removed successfully
                                    System.out.println("Book#" + str[1] + " return has completed. Thanks!");
                                    iCheck = true;
                                    break;
                                }
                            }
                        }catch(NullPointerException e){
                            iException = true;
                            System.out.println("Unable to return Book#"+str[1]);
                            break;
                        }
                    }
                    if (!iCheck && !iException) {
                        System.out.println("Unable to return Book#"+str[1]);    //if book not found
                        continue;

                    }

                }
                else{
                    System.out.println("Invalid Command.");
                    continue;
                }
            }



            else if (str[0].equals("PA")){
                if(lib.getNumBooks()==0){
                    System.out.println("Library catalog is empty!");
                    continue;
                }
                System.out.println("**List of books in the library");
                lib.print();
                System.out.println("**End of list");
            }



            else if (str[0].equals("PD")){
                if(lib.getNumBooks()==0){
                    System.out.println("Bookshelf is empty!");
                    continue;
                }
                System.out.println("**List of books by the dates published");
                lib.printByDate();
                System.out.println("**End of list");
            }


            else if (str[0].equals("PN")){
                if(lib.getNumBooks()==0){
                    System.out.println("Bookshelf is empty!");
                    continue;
                }
                System.out.println("**List of books by the book numbers");
                lib.printByNumber();
                System.out.println("**End of list");
            }



            else if (str[0].equals("Q")){
                System.out.println("Kiosk session ended.");
                break;
            }
            else if (str[0].equals("")){
                continue;
            }
            else{
                System.out.println("Invalid command!");
            }
        }

    }
}
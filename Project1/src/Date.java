import java.util.Calendar;

/**
 *Implements a Encapsulated Date object with a method to check if date is valid.
 * The Date object holds the data for Year, Month and Day. Class has setter and getter methods
 * because of encapsulation. The isValid() method checks if the date entered by user is correct.
 * @author Sahreb Aamir
 */
public class Date {
        private int year;
        private int month;
        private int day;

        /**
         * Constructor for Date Object with Date string parameter given.
         * When date is passed as a string to create Date object then the
         * year, month and day are initialized to given value.
         * @param date String that holds the date in format mm/dd/year
         */
        public Date(String date)
        {
                String[] str = date.split("/");
                this.year = Integer.parseInt(str[2]);
                this.month = Integer.parseInt(str[0]);
                this.day = Integer.parseInt(str[1]);
        }

        /**
         * Constructor for Date Object with no given parameters.
         * When date is not passed the date object is set to the
         * current date.
         */
        public Date()
        {
                this.year = Calendar.getInstance().get(Calendar.YEAR);
                this.month = Calendar.getInstance().get(Calendar.MONTH)+1;
                this.day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        }
        /**
         * Allows other classes to access value of month from Date Object.
         * @return month of current Date Object in form of integer.
         */
        public int getMonth(){
                return this.month;
        }

        /**
         * Allows other classes to access value of day from Date Object.
         * @return day of current Date Object in form of integer.
         */
        public int getDay(){
                return this.day;
        }

        /**
         * Allows other classes to access value of day from Date Object.
         * @return year of current Date Object in form of integer.
         */
        public int getYear(){
                return this.year;
        }

        /**
         *Checks if the Date object passed is a valid date.
         * Checks if the date is between year 1900 and current day.
         * Date also must have current number of days for the month
         * it is in. Month also must be possible.
         * @return true if date is credible, false  if not.
         */
        public boolean isValid()
        {
                if(this.day<Calendar.getInstance().getMinimum(Calendar.DAY_OF_MONTH) || this.day>Calendar.getInstance().getMaximum(Calendar.DAY_OF_MONTH)){
                        return false;
                }//Checks # of days for January, March, May, July, August, October, and December
                if(this.month>Calendar.DECEMBER+1 || this.month < Calendar.JANUARY+1){
                        return false;
                }

                if(this.year < 1900){
                        return false;
                }//books cannot be older than 1900

                if(this.year > Calendar.getInstance().get(Calendar.YEAR)){
                        return false;
                }//Checks if year greater than today's date

                if(this.year == Calendar.getInstance().get(Calendar.YEAR)){
                        if(this.month > Calendar.getInstance().get(Calendar.MONTH)+1){
                                return false;
                        }
                        if(this.month == Calendar.getInstance().get(Calendar.MONTH)+1){
                                if(this.day > Calendar.getInstance().get(Calendar.DAY_OF_MONTH)){
                                        return false;
                                }
                        }
                 }//Checks if month and day are greater than today's date

                switch(this.month){
                        case Calendar.APRIL+1:
                                if(this.day>Calendar.getInstance().getMaximum(Calendar.DAY_OF_MONTH)-1){
                                        return false;
                                }
                        case Calendar.JUNE+1:
                                if(this.day>Calendar.getInstance().getMaximum(Calendar.DAY_OF_MONTH)-1){
                                        return false;
                                }
                        case Calendar.SEPTEMBER+1:
                                if(this.day>Calendar.getInstance().getMaximum(Calendar.DAY_OF_MONTH)-1){
                                        return false;
                                }
                        case Calendar.NOVEMBER+1:
                                if(this.day>Calendar.getInstance().getMaximum(Calendar.DAY_OF_MONTH)-1){
                                        return false;
                                }
                }//Checks # of day against months with 30 days

                if (this.month==Calendar.FEBRUARY+1) {
                        if(Book.leapYear(this.year)){
                                if(this.day>Library.FEBDAY+1){
                                        return false;
                                }//29 days if leap year
                        }
                        else{
                                if(this.day>Library.FEBDAY){
                                        return false;
                                }//28 days if not leap year
                        }
                }//Checks # of day against correct number of days in February

                return true; //if all checks are completed then date must be valid
        }

        /**
         * Testbed to test while developing if the isValid() method works.
         * Using different test cases it checks thoroughly the isValid() method
         * by passing different dates to it, some valid and some not valid.
         * @param args
         */
        public static void main(String[] args){
              Date test = new Date("1/15/1895");
              System.out.println("Test Case #1, published around 1900");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("1/1/1900");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("1/1/1901");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }


              System.out.println("Test Case #2, published in future");
              test = new Date("2/5/2020");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("2/9/2021");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("2/25/2021");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }


              System.out.println("Test Case #3, published outside month range");
              test = new Date("0/14/2015");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("5/21/2019");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("13/20/2020");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }


              System.out.println("Test Case #4, days more than 31");
              test = new Date("1/9/2021");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("3/31/2020");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("12/35/2020");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                       System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }


              System.out.println("Test Case #5, the days in a month with a limit of 30");
              test = new Date("4/27/2006");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("6/30/2009");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("9/31/2016");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }


              System.out.println("Test Case #6, February and Leap Years");
              test = new Date("2/25/2013");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("2/28/2011");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("2/29/2015");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("2/15/2020");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("2/29/2012");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }
              test = new Date("2/31/2008");
              if(test.isValid()){
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is valid");
              }
              else{
                      System.out.println(test.getMonth()+"/"+test.getDay()+"/"+test.getYear()+" is not valid");
              }

        }


}

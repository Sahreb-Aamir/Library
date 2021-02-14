# Library
Implement an array-based container class Library and use it to hold the information of a list
of books owned by a library. An instance of the Library class is a growable bag data structure with an initial capacity
of 4, and automatically grows (increases) the capacity by 4 whenever it is full


A,Programming in Java,11/20/2019
A is a command for adding a book to the library, followed by the name of the book, and the date published. If the
bag is full, the bag automatically grows the capacity by 4. A serial number will be automatically generated to create
the book instance with the name and the date published. The serial number is a five-digit number starting 10001,
which will be increased by 1 for each subsequent instance of Book. The date will always be in mm/dd/yyyy format.
However, you must check if the date is valid with the isValid() method in the Date class (see page #3 below.)
Display “Invalid Date!” if the date is invalid; otherwise, display “Programming in Java added to the
bag.” on the console when the book is added.

• Removing a book
R,10005
R is a command for removing a book from the library given a book’s serial number. If the book doesn’t exist,
display "Unable to remove, the library does not have this book."; otherwise, display
“Book#10005 removed.”.


• Checking out a book
O,10005
O is a command for checking out a book from the library. If the library doesn’t own the book, or the book has
already been checked out, display “Book#1005 is not available.”, otherwise, display “You’ve
checked out Book#10005. Enjoy!”.


• Returning a book
I,10005
I is a command for returning a book to the library. If the book doesn’t belong to the library, or the book is not
checked out, display "Unable to return Book#10005.”, otherwise, display “"Book#10005 return
has completed. Thanks!"


• Printing the library catalog
PA //output the list of books to the console with the current sequence
PD //output the list of books by the dates published in ascending order
PN //output the list of books by the book numbers in ascending order
• Q command will stop the program and display "Kiosk session ended."



Sample input : 

pa

a

pd

AA

PP

RR

PA

PD

PN

A,Programming in Java,3/20/2010

A,Software Methodology,4/1/2018

A,Artificial Intelligence,12/01/2005

A,Linear Algebra,1/31/2020

A,Clean Code,3/31/2010

A,Pro Git,4/30/2018

A,Design Patterns,5/30/1996

A,Data Science,2/29/2008

PA

PD

PN

A,Programming in C++,3/20/2011

A,Object Oriented Analysis and Design,4/30/2018

A,Refactoring,1/31/2005

A,Java for Dummies,1/31/2020

A,Database Management Systems,2/28/2010

A,eXtreme Programming,2/10/2010

A,Doing Agile Right,5/30/1996

A,Data Structure with Java,2/29/2008

PA

r,10012

R,10012

R,10012

PA

o,10012

O,10012

i,10012

I,10012

O,10015

O,10015

PA

i,10015

I,10015

PA

PD

R,10005

PA

A,A fun book,31/2/2000

A,A fun book,13/2/2020

A,A fun book,2/29/2021

A,A fun book,2/29/2009

A,A fun book,4/31/2009

A,A fun book,3/32/2009

A,A fun book,3/31/1800

A,A fun book,10/30/2022

A,A fun book,3/30/2021

Q



Sample output: 

Invalid command!

Invalid command!

Invalid command!

Invalid command!

Invalid command!

Invalid command!

Library catalog is empty!

Bookshelf is empty!

Bookshelf is empty!

Programming in Java added to the library.

Software Methodology added to the library.

Artificial Intelligence added to the library.

Linear Algebra added to the library.

Clean Code added to the library.

Pro Git added to the library.

Design Patterns added to the library.

Data Science added to the library.

**List of books in the library.

Book#10001::Programming in Java::3/20/2010::is available.

Book#10002::Software Methodology::4/1/2018::is available.

Book#10003::Artificial Intelligence::12/1/2005::is available.

Book#10004::Linear Algebra::1/31/2020::is available.

Book#10005::Clean Code::3/31/2010::is available.

Book#10006::Pro Git::4/30/2018::is available.

Book#10007::Design Patterns::5/30/1996::is available.

Book#10008::Data Science::2/29/2008::is available.

**End of list

**List of books by the dates published.

Book#10007::Design Patterns::5/30/1996::is available.

Book#10003::Artificial Intelligence::12/1/2005::is available.

Book#10008::Data Science::2/29/2008::is available.

Book#10001::Programming in Java::3/20/2010::is available.

Book#10005::Clean Code::3/31/2010::is available.

Book#10002::Software Methodology::4/1/2018::is available.

Book#10006::Pro Git::4/30/2018::is available.

Book#10004::Linear Algebra::1/31/2020::is available.

**End of list

**List of books by the book numbers.

Book#10001::Programming in Java::3/20/2010::is available.

Book#10002::Software Methodology::4/1/2018::is available.

Book#10003::Artificial Intelligence::12/1/2005::is available.

Book#10004::Linear Algebra::1/31/2020::is available.

Book#10005::Clean Code::3/31/2010::is available.

Book#10006::Pro Git::4/30/2018::is available.

Book#10007::Design Patterns::5/30/1996::is available.

Book#10008::Data Science::2/29/2008::is available.

**End of list

Programming in C++ added to the library.

Object Oriented Analysis and Design added to the library.

Refactoring added to the library.

Java for Dummies added to the library.

Database Management Systems added to the library.

eXtreme Programming added to the library.

Doing Agile Right added to the library.

Data Structure with Java added to the library.

**List of books in the library.

Book#10001::Programming in Java::3/20/2010::is available.

Book#10002::Software Methodology::4/1/2018::is available.

Book#10003::Artificial Intelligence::12/1/2005::is available.

Book#10004::Linear Algebra::1/31/2020::is available.

Book#10005::Clean Code::3/31/2010::is available.

Book#10006::Pro Git::4/30/2018::is available.

Book#10007::Design Patterns::5/30/1996::is available.

Book#10008::Data Science::2/29/2008::is available.

Book#10009::Programming in C++::3/20/2011::is available.

Book#10010::Object Oriented Analysis and Design::4/30/2018::is available.

Book#10011::Refactoring::1/31/2005::is available.

Book#10012::Java for Dummies::1/31/2020::is available.

Book#10013::Database Management Systems::2/28/2010::is available.

Book#10014::eXtreme Programming::2/10/2010::is available.

Book#10015::Doing Agile Right::5/30/1996::is available.

Book#10016::Data Structure with Java::2/29/2008::is available.

**End of list

Invalid command!

Book# 10012 removed.

Unable to remove, the library does not have this book.

**List of books in the library.

Book#10001::Programming in Java::3/20/2010::is available.

Book#10002::Software Methodology::4/1/2018::is available.

Book#10003::Artificial Intelligence::12/1/2005::is available.

Book#10004::Linear Algebra::1/31/2020::is available.

Book#10005::Clean Code::3/31/2010::is available.

Book#10006::Pro Git::4/30/2018::is available.

Book#10007::Design Patterns::5/30/1996::is available.

Book#10008::Data Science::2/29/2008::is available.

Book#10009::Programming in C++::3/20/2011::is available.

Book#10010::Object Oriented Analysis and Design::4/30/2018::is available.

Book#10011::Refactoring::1/31/2005::is available.

Book#10013::Database Management Systems::2/28/2010::is available.

Book#10014::eXtreme Programming::2/10/2010::is available.

Book#10015::Doing Agile Right::5/30/1996::is available.

Book#10016::Data Structure with Java::2/29/2008::is available.

**End of list

Invalid command!

Book#10012 is not available.

Invalid command!

Unable to return Book#10012.

You've checked out Book#10015. Enjoy!

Book#10015 is not available.

**List of books in the library.

Book#10001::Programming in Java::3/20/2010::is available.

Book#10002::Software Methodology::4/1/2018::is available.

Book#10003::Artificial Intelligence::12/1/2005::is available.

Book#10004::Linear Algebra::1/31/2020::is available.

Book#10005::Clean Code::3/31/2010::is available.

Book#10006::Pro Git::4/30/2018::is available.

Book#10007::Design Patterns::5/30/1996::is available.

Book#10008::Data Science::2/29/2008::is available.

Book#10009::Programming in C++::3/20/2011::is available.

Book#10010::Object Oriented Analysis and Design::4/30/2018::is available.

Book#10011::Refactoring::1/31/2005::is available.

Book#10013::Database Management Systems::2/28/2010::is available.

Book#10014::eXtreme Programming::2/10/2010::is available.

Book#10015::Doing Agile Right::5/30/1996::is checked out.

Book#10016::Data Structure with Java::2/29/2008::is available.

**End of list

Invalid command!

Book#10015 return has completed. Thanks!

**List of books in the library.

Book#10001::Programming in Java::3/20/2010::is available.

Book#10002::Software Methodology::4/1/2018::is available.

Book#10003::Artificial Intelligence::12/1/2005::is available.

Book#10004::Linear Algebra::1/31/2020::is available.

Book#10005::Clean Code::3/31/2010::is available.

Book#10006::Pro Git::4/30/2018::is available.

Book#10007::Design Patterns::5/30/1996::is available.

Book#10008::Data Science::2/29/2008::is available.

Book#10009::Programming in C++::3/20/2011::is available.

Book#10010::Object Oriented Analysis and Design::4/30/2018::is available.

Book#10011::Refactoring::1/31/2005::is available.

Book#10013::Database Management Systems::2/28/2010::is available.

Book#10014::eXtreme Programming::2/10/2010::is available.

Book#10015::Doing Agile Right::5/30/1996::is available.

Book#10016::Data Structure with Java::2/29/2008::is available.

**End of list

**List of books by the dates published.

Book#10007::Design Patterns::5/30/1996::is available.

Book#10015::Doing Agile Right::5/30/1996::is available.

Book#10011::Refactoring::1/31/2005::is available.

Book#10003::Artificial Intelligence::12/1/2005::is available.

Book#10008::Data Science::2/29/2008::is available.

Book#10016::Data Structure with Java::2/29/2008::is available.

Book#10014::eXtreme Programming::2/10/2010::is available.

Book#10013::Database Management Systems::2/28/2010::is available.

Book#10001::Programming in Java::3/20/2010::is available.

Book#10005::Clean Code::3/31/2010::is available.

Book#10009::Programming in C++::3/20/2011::is available.

Book#10002::Software Methodology::4/1/2018::is available.

Book#10010::Object Oriented Analysis and Design::4/30/2018::is available.

Book#10006::Pro Git::4/30/2018::is available.

Book#10004::Linear Algebra::1/31/2020::is available.

**End of list

Book# 10005 removed.

**List of books in the library.

Book#10007::Design Patterns::5/30/1996::is available.

Book#10015::Doing Agile Right::5/30/1996::is available.

Book#10011::Refactoring::1/31/2005::is available.

Book#10003::Artificial Intelligence::12/1/2005::is available.

Book#10008::Data Science::2/29/2008::is available.

Book#10016::Data Structure with Java::2/29/2008::is available.

Book#10014::eXtreme Programming::2/10/2010::is available.

Book#10013::Database Management Systems::2/28/2010::is available.

Book#10001::Programming in Java::3/20/2010::is available.

Book#10009::Programming in C++::3/20/2011::is available.

Book#10002::Software Methodology::4/1/2018::is available.

Book#10010::Object Oriented Analysis and Design::4/30/2018::is available.

Book#10006::Pro Git::4/30/2018::is available.

Book#10004::Linear Algebra::1/31/2020::is available.

**End of list

Invalid Date!

Invalid Date!

Invalid Date!

Invalid Date!

Invalid Date!

Invalid Date!

Invalid Date!

Invalid Date!

Invalid Date!

Kiosk session ended.


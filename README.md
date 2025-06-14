# HR

JAVA PROGRAM AND TECHNICAL DOC
The development of the Java application tests the following learning outcomes:
•	Create programs that apply advanced programming techniques and object-oriented concepts.
•	Follow best practice, industry standards, professional ethics, diagram designing, programming and documentation conventions during the programming process.

All files which you wish to submit must be placed into a single ZIP file (with extension of .zip) submitted on Moodle.
The following files should be present:
•	NetBeans project
•	javaDoc HTML site

CODE-PRESENTATION REQUIREMENTS
The code must compile and execute successfully in the Java 8 SDK. Your code files must compile without any error messages if they are to be considered by the marker when deciding on the grade to be awarded. The marker does not have time to debug your code, and the marker might not give feedback comments regarding code which does not compile.
Please keep in mind the following things regarding the presentation of code assignments:
•	All code should be indented properly to show that you understand the structure of the code.
•	Commenting should be present, and relevant. Any style of commenting is permitted, but it should be neither excessive nor too minimal.
•	Provide an explanation of the purpose of each class, attribute, method, and method parameter, in a manner that is obvious to the reader of your code. These descriptions are to be done using the Javadoc style. The preferred style for methods is to use the headings of Name, Purpose, Input, Output and Effect and the javadoc tags of @param and @return to describe the method's place and use within the system. @param refers to parameters passed in, @return is the value sent back to the caller.  The tag of @version can be used in the Javadoc comment of classes.
/** Name:  setUpperLimit
* @author  Mohammed Ali
* Purpose/description: to set the highest valid number of greyhounds
*          allowed to run in the race
* @param   upperLimit - the maximum number of greyhounds allowed.
*          Don't make it too excessive or else the dogs will trample
*          each other
* @return  true - if the number is acceptable, false otherwise.
*/
public boolean setUpperLimit(int upperLimit)
throws DogsAlreadyInRaceException
{ ... }

SUBMISSION REQUIREMENTS
All files that you wish to be marked, must be placed into a single ZIP file, named project_YourClassNumber_YourGroupNumber and submitted to Moodle.
At minimum, the following files (if they are attempted) should be present:
•	The Java code file containing main()
•	The Java code files containing all the other classes required for your program to compile and run.

You do not need to submit any of the text files provided for you, as the marker will have their own.
Also, you need to include an electronic version of the IT Assignment Coversheet as an indication that the work is your own work. The work submitted must be your own work/group work. 
 
FUNCTIONAL REQUIREMENTS: 
CONTEXT/BACKGROUND INFORMATION (CI)
The following sections describe some of the information processing and data reporting requirements of the system, and also sets the context in which the system will operate. You may find that you need to read through the whole description several times in order to get a full sense of the system you need to create.
Large businesses often have hundreds or even thousands of employees. These employees may work at a variety of physical locations. A person usually works at just one place. They are generally attached to a particular department. 
In some businesses, the amount of pay a person is entitled to receive for the standard year is based on a particular standard rate of pay as decided in a business-wide agreement of pay scales. 
Scale/Level	Annual Amount 
1	BD44,245.75
2	BD48,670.32
3	BD53,537.35
4	BD58,891.09
5	BD64,780.20
6	BD71,258.22
7	BD80,946.95
8	BD96,336.34

What that means, for example, is that if Harriet Smith is employed at the level 3 pay scale, she will have received a total of BD53,357.35 by the end of the year. If Peter Jones is also employed at the same pay scale level, he will be paid the exact same amount. No-one can receive any amount different to the values listed above.
Note: It is very important to use the same version or newer version of Netbeans as is installed in the computer lab.
FUNCTIONAL REQUIREMENTS OF THE SYSTEM
The key requirements to be satisfied by the program you produce for the assignment are as follows:
•	The program should provide a graphical user interface to the functionality (Req-1)
•	An ability to add new departments to the system (Req-2)
•	An ability to add new employees to the system (Req-3)
•	An ability to alter an employee’s details (Req-4)
•	An ability to alter the details of a department (Req-5)
•	An ability to assign an employee to a particular department (Req-6)
•	An ability to designate a department employee as the head of the department (Req-7)
•	An ability to delete departments (Req-8)
•	An ability to delete employees (Req-9)
•	An ability to see a list of employees currently assigned to a particular department (Req-10)
•	An ability to produce a report about the amounts to be paid fortnightly (Req-11)
•	An ability to remember all information between consecutive runs of the program (Req-12)
•	An ability to initialise a brand new installation of the system with some pre-determined data (Req-13)
•	An ability to exit the program (Req-14)
•	The program should include Exception handling (Req-15)
•	Separation of Business Logic from Graphics UI Logic (Req-16)

In the sections which follow, the expectations will be elaborated.

Req-1: The program should provide a graphical user interface to the functionality 
You are to develop a program that presents frames with buttons, text fields, etc. to the user, and which responds to events generated by the user interacting with the GUI. It must be possible to perform all main functions described in the other requirements. You are expected to be able to use all the graphical components that are covered in Unit 6. You may need to refer to the Java API Documentation for details about the methods pertaining to some of the GUI components.
You should make use of each of the following somewhere in your program:
•	JTextField
•	JPanel
•	JButton
•	JRadioButton 
•	JComboBox
•	JFrame

You are allowed to use other components too, but must ensure the above are used in at least one place.

Req-2: An ability to add new departments to the system 
The program must allow you to create new departments. Each department has a name, a location (e.g. “Sydney” or “Tokyo”) and a department ID. That is the only information required at creation time. Additionally, departments will have a list of employees who work for them. One employee may be designated to be the ‘head’ of the department, i.e. a person who will oversee the running of the department on a daily basis. All department information read in from the user must be validated.

Req-3: An ability to add new employees to the system
The program must allow you to create new employees. Each employee has a first name, a surname/family name, a gender (M/F), an employee-ID number, a living address and an initial pay level. 
An employee must not be created if any of its information is not supplied, or is invalid. You should ensure that the data entered by the user is sensible and complete, before recording the details permanently in the system, i.e. data validation must be carried out on the data entered.
No two persons can have the same ID number. It may be best to let the program allocate ID numbers to people. The ID numbers are intended to help with searching for a particular employee, particularly if two or more people have the same names. When an employee no longer works at the company, they may be deleted from the system. But the ID cannot be re-used for another person even if the person to whom it was assigned is no longer working for the company.

Req-4: An ability to alter an employee’s details
Because a person can move house, or marry and change their name, or receive a change to their pay level, most of this information must be alterable, and so the user must be able to make the relevant changes to an employee’s details when necessary. (The only information that does not need to be changed is the ID number). The application should provide the ability to search for an employee and display their details. The user should then be able to edit these details and save the new employee details. Make sure to provide the user with a message to indicate the outcome of the edits.

Req-5: An ability to alter the details of a department
The name or location of a department may change. The user must be able to make the relevant changes to the details of a department when necessary (The only information that does not need to be changed is the department ID number). The application should provide the ability to search for a department and display its details. The user should then be able to edit these details and save the new department details. Make sure to provide the user with a message to indicate the outcome of the edits.

Req-6: Ability to assign an employee to a particular department
The program must allow the user to assign employees to work for a particular department. An employee can only be in one department at a time. If an employee is assigned to a new department, they must be removed from their original department. An employee can only be re-assigned to a different department if they are not the head of a department. If a department head is to be assigned to a different department, they must be removed from the department head position and the role must be assigned to someone else in that department. Since there are potentially many departments and many employees in the system, it would be best if you can use a JComboBox to present lists of employees/departments for the user to select. Otherwise, you can just ask them to input the details using a text field. 



Req-7: Ability to designate an employee as the department’s head.
The program must allow the user to designate an employee as being the head for a department. There can only be one head of a department. There is a restriction that the head of a department must be someone who is already an employee of that department, and they must remain assigned to that department for as long as they are the head (i.e. they cannot switch to another department).
It is not necessary for a department to have a head at all moments that the program is running. In fact, as soon as a department is created, before any employees are assigned to the department, it will not have a head.

Req-8: An ability to delete departments
Sometimes organisations re-design themselves and some departments are no longer required. The program must allow for the ability to delete a department from the system. However, before deleting a department it must ensure that there are no employees in the department.

Req-9: An ability to delete employees
Sometimes individual employees leave the company, so you need to delete their details from the system. The application must provide the ability to delete an employee from a department. 

Req-10: Ability to see a list of employees currently assigned to a particular department 
It must be possible for the program to display a list of all employees currently assigned to a selected department of the user’s choosing. The details to display include the name and id of the employee and their amount of annual pay. 
You should use a JCombox to display the list of all departments so the user can easily choose one. You should use a JTextArea, (possibly with a JScrollBar and JScrollPanel), in order to display the employee information for the chosen department.

Important – For Requests 4 to 10: There will be more marks allocated if you incorporate the use of a JComboBox where appropriate as opposed to a textbox.

Req-11: An ability to produce a pay report.
Every fortnight, the payroll department needs to pay employees 1/26th of their annual salary. To do this, they require a report which specifies for each department, for each employee within the department, how much is due to be paid that fortnight.
They are very particular about the format of the report. These are their requirements:
1.	The report must be in a plain-text file, named ‘payroll.txt’, so that they can print it on a printer. 
2.	It must group employees by department. 
3.	For each employee, the name, id and 2 week pay should be printed.
4.	A total amount for each department should be displayed at the end of the department’s employee list.
5.	A total amount for the company should be displayed at the end of the company report.

Req-12: An ability to remember all information between consecutive runs of the program
The data which is entered into the program or altered while it is running needs to be retained for future times that the program is run. To achieve this, you are expected to use object serialization to ensure all objects representing information about departments and employees are stored to a file before the program is exited. Then the next time the program is started, you should bring the objects from that file back into memory to re-establish the system’s state as it was prior to exiting.

Req-13: An ability to initialise a brand new installation of the system with some 
pre-determined data
In order that the program is useable by both yourself and the marker, and to save you from having to enter lots of data to set-up the system every time you run the program after a major change to the programming, you should provide a mechanism for a ‘Clean Start’. You are being provided with a plain-text file (“startup.txt”), which contains details about some departments and employees, which can be used to initially populate the system with useful data. The marker will use a similar file (but with different content), to test your program.
Notes: 
•	The id number of each department and employee is not included in the startup file. This is to allow the program to create the id numbers.
The organisation of the text file is the following:
•	Each line of the file will contain one item of data.
•	The first line of the file is an integer stating how many ‘department’ records will immediately follow.
•	Then there are that many department records

For each department record, the organisation of the text file is the following:
•	The first line will say the name of the department.
•	The next line is the location of the department.
•	The next line is an integer stating how many ‘employees’ immediately follow – these employees belong to this department.
•	Then there are that many employee records.

For each employee record, the organisation of the text file’s lines is the following:
•	The first line will be the first name of the employee
•	The next line will be the last name of the employee (assume every employee of this company has a first and last name) 
•	The next line will be either capital M or capital F, signifying the gender
•	The next line will be the address where the employee lives
•	The next line is a number representing the salary scale for that employee

Your program should be designed to load this file only if it is the ‘first’ run, i.e. it should not load it after having serialized data from a previous run. The intention is that you would throw-away the file after using it, however you will find that sometimes after re-compiling your source code, it won’t like reading the serialized data.

Req-14: An ability to exit the program

The program must allow the user to choose when to exit from it, i.e. frames must contain an exit button. Don’t forget to save the data.


Req-15: The program should include Exception handling
Make sure to include sufficient exception handling in your code. Implement at least 3 different types of exceptions in your code. E.g., anywhere you are looping through an array structure, you could handle any ‘ArrayIndexOutOfBounds’ exceptions that may occur. Also, you should take care to ensure that constructors and ordinary methods do not accept null-values for parameters when these are expecting objects. In such cases, the most appropriate exception is NullPointerException (to be consistent with the behaviour of classes in the Java Class library). 
 (Do not worry about making exceptions for application domain classes, i.e. your user interface classes.)

Req 16: Separation of Business Logic from Graphics UI Logic.
As explained in module 2 of the unit, you should design classes such that they can be classified as sitting in one of four domains (foundation, architecture, business or application domain). What this means for your assignment is that the code which represents information should be separate from the code which runs the user interface. Please take care to make separate classes for business-logic and for graphics/UI-logic. 

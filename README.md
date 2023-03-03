# Spring-java-final-test
final assessment at 3/3/2023 2:00 to 3:00 PM



Employee Management System is a restful web service. Here we have to implement these endpoints so that the user can perform the CRUD opertion on Employee Entity.



1./api/v1/employees GET - This endpoint will return all the employees in a list. If there is no employee data available it should return Http status 204.

2./api/v1/employees POST - this enpoint will return the employee resource got created with assigned id.The response status should be 201. It should return 400 status, if client send request data wrongly.

3./api/v1/employees/id GET - this end point will return the employee object associated with the id. It will return EmployeeNotFoundException with status 404. (Note: Use ExceptionHandling for Rest services)

4./api/v1/employees/id PUT - this end point will return the updated Employee object. If updation is unsuccessful will throw status 500.

5./api/v1/employees/id DELETE - this end point should return the deleted object.



Here is the Employee entity. and the corresponding table is Emp_TB(Use H2 in memory Database)

Java Properties    DataType         DB Column Name

employeeid         long              - ID

firstname          String              FNAME

lastname           String              LNAME

department         String              DEPT

designation        String              DESG

salary             Double              SALARY


1.The Entity class.

2.The Entity data should be validated.

3.firstname,lastname should contain only alphabets.

4.firstname,lastname,department,designation,salary can ot be null.

5.salary can not be a negative number and it should greater than  20000.

6.provide the corresponding validation message.



These are the classes and interfaces you have to create.

1.EmployeeAPI - controller

2.Employee - Entity

3.EmplyeeRequestDto - DTO

4.EmployeeResponseDto - DTO

5.EmployeeService - service interface

6.EmployeeServiceImpl - implementation class

7.EmployeeRepo - repository interface extending JpaRepository

8.EmployeeNotFoundException - An userdefined exception class

9.EmployeeExceptionHandler - A centarl exception class to handle exception. 

 

# Java Stream Code Task For DataOrb

<img src="screenshots/dataorb.jpg" alt="Main Information" width="200" height="200">

## Description
<ul style="list-style-type:disc">
  <li>It is an example of Payroll Processing System</li>
  <li>It accepts the employees data from the client in either plain text format (.txt) manage the employee life cycle starting from date of onboarding to date of exit</li>
  <li>How does the example look like
      <ul>
        <li>All code written is based on Java</li>
        <li>Reading values from txt file and store all them into collection named Map</li>
        <li>Get the result with respect to the different kinds of operations like grouping by one or multi fields, mapping object to dto(data transfer object), sorting by one field and other processes by the usage of java streams</li>
      </ul>
  </li>
</ul>

### Description of the Methods
<table style="width:100%">
  <tr>
    <th>Method</th>
    <th>Description</th>
  </tr>
  <tr>
      <td>getTotalNumberOfEmployeesInOrganization</td>
      <td>Show the total number of employees in the organization</td>
  </tr>
  <tr>
      <td>getMonthWiseFollowingDetails</td>
      <td>Show the total number of employees who joined the organization and exited from it/td>
  </tr>
  <tr>
      <td>getMonthlySalaryReport</td>
      <td>Show the salary report accoring to month containing Month, total Salary and lastly total Employees</td>
  </tr>
  <tr>
      <td>getEmployeeWiseFinancialReport</td>
      <td>Show the employee financial report containing employee id, employee name, employee surname and lastly total amount paid</td>
  </tr>
  <tr>
      <td>getMonthlyAmountReleasedReport</td>
      <td>Show monthly amount relased report containing month, total amount and lastly total employees</td>
  </tr>
  <tr>
      <td>getYearlyFinancialReport</td>
      <td>Show yearly financial report containing event, employee id, event date and lastly event value</td>
  </tr>
</table>


### Usage of Technology
* Java 19

### 🔨 Run the App

<b>1 )</b> Clone project from github
```
    File 
      -> New 
         -> Project from Version Control
           -> Paste the git url and Click Clone
```
<b>2 )</b> Click "Run"

### Resources which I've used to build the example during the project

    1)  10 Examples of Stream API in Java 8 - count + filter + map + distinct + collect() Examples
        https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html

    2)  Java 8 Stream - Java Stream
        https://www.digitalocean.com/community/tutorials/java-8-stream

    3)  Java 8 Tutorials
        https://mkyong.com/tutorials/java-8-tutorials/

    4)  Java 8 Tutorials
        https://mkyong.com/tutorials/java-8-tutorials/

    5)  Java Stream Group By
        https://www.davidvlijmincx.com/posts/java_stream_group_by/

    6)  Collectors teeing() method examples
        https://howtodoinjava.com/java12/collectors-teeing-example/

    7)  Java - Using Collectors.teeing() Examples
        https://www.woolha.com/tutorials/java-using-collectors-teeing-examples

    8)  Teeing, a hidden gem in the Java API
        https://blog.frankel.ch/teeing-java-api/

    9)  Java 8 Read File With try-with-resources
        https://nirajsonawane.github.io/2018/05/24/Java-8-Read-File-With-try-with-resources/

    10) Formatting with Java DateTimeFormatter
        https://howtodoinjava.com/java/date-time/java8-datetimeformatter-example/
       
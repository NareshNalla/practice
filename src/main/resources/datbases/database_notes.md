# Database
Duplicate Values in Multiple Columns:
SELECT OrderID, ProductID, COUNT(*)
FROM OrderDetails
GROUP BY OrderID, ProductID
HAVING COUNT(*)>1

************************************
SQL query to find second highest salary?

SELECT name, MAX(salary) AS salary
FROM employee
WHERE salary < (SELECT MAX(salary)
FROM employee);
SELECT * FROM employee
WHERE salary= (SELECT DISTINCT(salary)
FROM employee ORDER BY salary LIMIT 3,1);

Generic query will be

SELECT * FROM employee
WHERE salary= (SELECT DISTINCT(salary)
FROM employee ORDER BY salary LIMIT n-1,1);

******************************************
Joines:
SELECT StudentCourse.COURSE_ID, Student.NAME, Student.AGE FROM Student
INNER JOIN StudentCourse
ON Student.ROLL_NO = StudentCourse.ROLL_NO;

SELECT Student.NAME,StudentCourse.COURSE_ID
FROM Student
LEFT JOIN StudentCourse ON StudentCourse.ROLL_NO = Student.ROLL_NO;

SELECT Student.NAME,StudentCourse.COURSE_ID
FROM Student
RIGHT JOIN StudentCourse ON StudentCourse.ROLL_NO = Student.ROLL_NO;

SELECT Student.NAME,StudentCourse.COURSE_ID
FROM Student
FULL JOIN StudentCourse ON StudentCourse.ROLL_NO = Student.ROLL_NO;

cross join: Cross join allows us to join each and every row of both the tables. It is similar to the cartesian product that joins all the rows.
SELECT Student.NAME, Student.AGE, StudentCourse.COURSE_ID
FROM Student CROSS JOIN StudentCourse;

selfjoin: Self-join allows us to join a table itself. It is useful when a user wants to compare the data (rows) within the same table.
SELECT a.ROLL_NO , b.NAME
FROM Student a, Student b
WHERE a.ROLL_NO < b.ROLL_NO;

select n1.name, n2.name
from Student n1 inner join Student n2
on rollno n1 = rollno n2

**************************
SELECT
name
FROM
cities
ORDER BY
name DESC;
**************************
selfjoin elimiate duplicates from row1 row 2 whre row1, row to are same colum.
SELECT  DISTINCT t1.team , t2.team FROM Teams t1 ,Teams t2
where (t1.id > t2.id);
****************************
SELECT gen_title, AVG(mov_time), COUNT(gen_title)
FROM movie
NATURAL JOIN  movie_genres
NATURAL JOIN  genres
GROUP BY gen_title;
*****************************
SELECT COUNT(mg.genre_id) AS movieCount, g.name
FROM MOVIE_GENRE mg, GENRE g
WHERE mg.genre_id = g.id
GROUP BY mg.genre_id;
  **************************
What is index ?

what is clusterd index?
what is non-clustered index?

***************************************
DynamoDB:
DynamoDB is a NoSQL database provided by AWS, and in the same way as MongoDB or Cassandra, it is very suitable to boost horizontal scalability and increase development speed.
Fast and consistent.
Provides access control.
Enables Event Driven Programming
Tables. Catalog
Items. Group of attributes
Attributes. Data elements
Partition Key. Mandatory, Key-Value access pattern. Determines data distribution
Sort Key. Optional. Model 1:N relationships. Enables rich query capabilities
of Spring Data. This module supports:

CRUD operations for DynamoDB entities.
Lookup strategy from query method names (only supported from 5.1.0-SNAPSHOT).
Integration with custom repositories.
Spring annotations.
REST support via spring-data-rest.
@EnableDynamoDBRepositories(basePackages = "org.smartinrubio.springbootdynamodb.repository")
@Value("${amazon.dynamodb.endpoint}")
private String amazonDynamoDBEndpoint;
@Value("${amazon.dynamodb.region}")
private String amazonDynamoDBRegion;
AmazonDynamoDBClientBuilder
.standard()
.withCredentials(amazonAWSCredentialsProvider())
.withRegion(Regions.US_WEST_2)
.build();
Data
@DynamoDBTable(tableName = "Hotels")
public class Hotel {
@DynamoDBHashKey
@DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
private String id;
@DynamoDBAttribute
private String name;
@DynamoDBTypeConverted(converter = GeoTypeConverter.class)
private Geo geo;
****************************************
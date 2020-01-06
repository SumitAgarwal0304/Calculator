# Calculator
Maven Calculator Project With Spring Security

There are three end points to the app
1) /calculator/multiplication
2) /calculator/subtraction
3) /calculator/equal

These end point can only be accessed is the user_name = admin and password = password is given.

The input parameter for all the request is Json.
The structure of Json is {"numbers":["1","3"]}. For multiplication more than 2 numbers can be added to the array list.

Proper Junits has also been added for this application.
The excpetion has been handeled by help of controller Advice.



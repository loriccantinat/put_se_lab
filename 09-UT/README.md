Loric CANTINAT ER-2194

# Question 3.1 : 

If we replace @BeforeEach with @BeforeAll, the tests will not run. This is because JUnit requires that methods annotated with @BeforeAll be declared as static. Furthermore, using @BeforeEach is preferable because it ensures that the calculator object is properly reset before each test, preventing one test from influencing the results of another.

# Question 4.1 : 
- test1 will be a “Failure”: This occurs when an assertion fails (the expected result does not match the actual result).  
- test2 will be an “Error”: This occurs when an unexpected exception (other than an assertion error) is thrown during execution.

# Question 4.2 :

JUnit considers a test to have failed when it receives an object of type AssertionError (or a subclass).

# Question 5.1 : 

This is known as white-box testing because this method relies on analyzing the program's internal structure, architecture, and source code. Unlike black-box testing, which focuses solely on inputs and outputs against specifications without examining the code, white-box testing requires an examination of algorithms and control flows. Since we must directly examine the `calculate` method to identify all possible execution paths (logical branches), this is clearly white-box testing.

# Question 5.2 : 

There are 4 possible paths in the `calculate` method:  
- Path 1 (Subscriber): The customer is a subscriber (`isSubscriber()` is true). The method immediately returns 0.0.
- Path 2 (Loyalty SILVER): The customer is not a subscriber, but their loyalty level is SILVER. They receive a 10% discount.
- Path 3 (Loyalty GOLD): The customer is not a subscriber, and their level is not SILVER, but GOLD. They receive a 20% discount.
- Path 4 (Standard): The customer is not a subscriber and is neither SILVER nor GOLD. They pay the full price (startingPrice).

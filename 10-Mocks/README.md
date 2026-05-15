Loric CANTINAT ER-2194

# QUESTION 2.1 :
We need to convert the “passive” mock into an “active” mock. This means it should be able to track method calls. To do this, we add state variables or a chronological list within the MyDatabase class to record each call to the connect(), queryAll(), and close() methods. After executing loadExpenses(), the test can then use assertions to verify not only whether the methods were called the correct number of times, but also whether the specific order (connection, then query, then close) was followed, thereby detecting the absence of a call to close() if a call to connect() was made before.

# QUESTION 5.1 : 
Yes, the order of rules is crucial in Mockito. When a method is called on a mocked object, Mockito iterates through the configuration rules (when) from the most recent to the oldest (in the reverse order of how they are written in the code) to find the first one that matches the provided arguments. For the test to work correctly, you must therefore always declare the most general behaviors first and the specific exceptions last.

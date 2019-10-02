# Coding-Task

Revolut-task
-----------------------------------------------------------------

Simple design and implement a RESTful API (Inmemoery backing implementation) for money transfers between accounts.


Implementation details
----------------------------------------------------
Build tool - Maven

Resp Api - Spark

Testing - JUnit

JDk - Above 9

Development Tool - eclipse/STS


Running application
-------------------------------------------------------------
To run application you need to install maven. Next, call from the command line:

Used spark-core inbuild jetty - Run Main program which will initilise everything with publish API. 


Jetty default run on - 4567 port - Once you run the program will be visible in console


If port argument is not defined will be used 1234 by default.



Published Api
----------------------------------------------------------

**GET**:		/accounts - gets all accounts

**POST**:		http://{host/IP}:{port}/account?custName={value}&bal={value}- Please creates account with initial balance

**GET**:	 /account/{account_id} - gets account by id 

**POST**: 	http://{host/IP}:{port}/transfer?transfer?fromAcc={value}&toAcc={value}&amount={value} - transfers money between accounts

**GET**:		/transfers - gets all transfer details

**GET**:		/transfer/{trans_id} - gets account by id

Feature: End to End Return Ticket Booking Functionality


	Scenario Outline:  validate round trip
		Given Login to url  "https://www.makemytrip.com/" 
		#As OTP is generating everytime to login,we cant automate otp.
		#And click on Login or CreateAccount Btn
		#And login to the application
		#|username             |password |
		#|lipsatest05@gmail.com|test@0510|
		When click on "<Trip>" radiobutton
		And Enter Flight from "<From City>" to "<To City>"
		And enter depature date as "<Depature Date>"
		And enter return date as "<Return Date>"
		And enter  adult as "<No of Adult>" and  enter childern as "<No of Child>"
		And click on apply button
		And click on search button
		Then Verify result page appeared with Flight details from "<From City>" to "New Delhi"
		When Select the Popular Filters option as "<Filter Option>"
		And Click on the Book Now option
		Then Verify Fare Details page appeared
		When Click on the Continue button on Fare details screen
		Then Verify Review your booking page appeared in different tab
		And Fare summary section appeared on the page 
	Examples:
	|Trip				|From City		|To City		|Depature Date			|Return Date				|No of Adult|No of Child|Filter Option|
# |Round Trip	|Mumbai				|Delhi			|Today							|Tomorrow						|2					|1					|Non Stop			|
	|Round Trip	|Mumbai				|Delhi			|9/September/2021		|12/December/2021		|2					|1					|Non Stop			|
		
#Terkwaz Assignment:

##Contents:
A maven java project that uses TestNG, Selenium (Web), RestAssured(Rest APIs), and ExtentResport(Reporting).
<br>A plug-in (surefire) helps in running the tests.

##Code structure:
![altText](CodePackages.png "Code Packages")

##Test grouping:
Tests are put into 3 test sets (Tests in TestNG way)

*   GoogleSearch test.
*   Herokuapp tests.
*   API-CatFacts test.

##web package: 
Contains web based tests.

##api package:
Contains api based tests.

##configs:
Handling some configuration data.<br>
Just a singleton for holding the configurations.

> The folder configs contains a properties file that hold some test data and configurations that is self explaining.
   

##core:
Base classes for web and api tests.<br>
Base class for all test bases basically handles the extent report initialization.

##Pages:
Pages needed for WEB POM representation.

##Utils:
Simple utility for screen capturing.

##Pre-requests:
Java[1.8] and maven are installed.
Selenium webdrivers for [ChromeDriver](https://chromedriver.chromium.org/downloads "ChromeDriver") and [firefox/geckodriver](https://github.com/mozilla/geckodriver/releases "ff driver")  are installed (the executables are in system path).

**resources** folder contains an image "./resources/quality.png" used in the upload test. 

##Running:
on the project root type:<br>
	
	mvn clean test

By default the code uses chrome.<br>
you can change it to firefox by adding a browser parameter to testng.xml like:
	<parameter name="browser" value="firefox" />
	
##The outputs are:
*	**Results.html** is the extent robot format
*	**test-output** folder for the standard TestNG reports.
*	_screenshots_ folder for the web tests screenshots. 




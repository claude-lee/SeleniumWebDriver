Next Steps:
-----------------------
- 1. Setp solution and project (2 projects? Tests and TestFramework?)
- 2. Create sample test
- 3. Create Smoke tests
- can login
- can create new post
- can edit an existing page
- smoke tests
- easy to create and they test a large area of the system


Gettimg started with Selenium IDE in Firefox:
----------------------------------
- seleniumhq.org 
- downloads tab 
- download Selenium IDE (Firefox will automatically detect that you're trying to install a plug in) 

Once installed you can open Firefox, go to Web Developer and click Selenium IDE. Here you can record test cases and export test case as Java JUnit test case.

WAIT
------
WebDriverWait wait until
WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id<locator>));


SELENIUM and Eclipse
----------------------------------------

Add External Jars to Java build path
Now you need to add selenium webdriver’s jar files in to Java build path.

a) Right click on Project ‘OnlineStore‘ > Select Properties > Java build path. Then navigate to Libraries tab and click Add External JARs.

Selenium-Jar-1

b) Add Selenium Java jar, you may add the source file too.
- selenium-java-2.40.0.jar

c) Add all the jars from the libs folder as well


XPath - Firebug
-----------------------------------
So in order to figure out the XPath, 
- open up Firefox, go to Web Developer
- go to Get More Tools, click on Firebug and add that as a plug in
- once you have Firebug installed, go to your page and right click on element 
- click Inspect Element with Firebug
- Will show HTML here, (Firefox better than Chrome for that)
- right click on any element, do Copy XPath
- paste this !! done !!

Remote
------------------------------------
In order to run test cases remotely:
- cd C:\Program Files (x86)\selenium-java-2.45.0>
- java -jar selenium-server-standalone-2.45.0.jar

Grid mode / Hub mode:
--------------------------------------
In order to run test cases remotely:
- cd C:\Program Files (x86)\selenium-java-2.45.0>
- java -jar selenium-server-standalone-2.45.0.jar -role hub
- open firefox on http://localhost:4444/grid/console
- open another command prompt
- cd C:\Program Files (x86)\selenium-java-2.45.0>
- java -jar selenium-server-standalone-2.45.0.jar -role node -hub http://localhost:4444/grid/register


More info
------------------------------------------
code.google.com/p/selenium/wiki/Grid2
- browser version
- json format
- ...


Connect to Mac through VNC

Getting up to BAT
-------------------------------
Black Box Automation Testing (BAT)
Blog Series:
http://simpleprogrammer.com/getting-up-to-bat-series/

Page ObjectModel
--------------------
Map Objects from Pages to framework

Rule
----
- never require a test declare a variable
- never require a test to use the new keyword or create a new object
- never require the test to manage state on their own
- never expose the browser or document object model (DOM) to the test or let them manipulate it directly
- always reduce the number of parameters for API calls when possible (not many parameters in methods)
- always use default values instead of requireing a parameter when possible
- prefer to make the API easierto use over the internals of the APIless complex
- prefer using enumerations and constants when requiring the test to pass in primitive types. 
(makes the input bounded when possible) No Strings but Enums!!

Best Practices
--------------------------------
- use static methods! In test framework that is ok
- Ease of use more important than maintainability
- use DSL Domain Specific Languages
- internal DSL
- external DSL (whole new languale, too much work)
- HOW to report the result of the test?? 
LoginPage.Goto();
LoginPage.Login("Joe", "$securePassweord")
- Test should only fail if specific thing I am testing 
- something else is failed then it should be a test error



Continuous Integration
----------------------------------
- Have a plan and stick to it
- Run tests as part of a build
- Run tests locally
- Report results
- Break builds


True DSL
-----
check out ANTLR


Scaling out
-------------------------
- run in parallel
- split tests in groups
- have some data preset in database and rely on that data
 (that makes tests faster)
 - Sauce Labs
 
Working with agile
----------------------------------
- make the automated test part of the agile process
- passing all automated tests in part of criteria


<<<<<<< HEAD
Code coverage
-----------------

1. EclEmma: In eclipse -> Help -> Marketplace -> install EclEmma
- Just run not to automate

2. Cobertura: more complicated, to automate
- http://cobertura.github.io/cobertura/


Infinite Test 
-----------------
- runs the corresponding tests when code is updated
http://infinitest.github.io/
- drag and drop to eclipse window -> install in Marketplace

Stub
-------------
- interface 
- stub class to implement interface which gives dummy data

JMock
-----------
- http://www.jmock.org/download.html, download jar Binary JARs
- copy to Utilities libraries
- eclipse , Java Build Path, Order and Export, before JUnit, 


TDD
-------------------
- TDD, where did it all go wrong
http://vimeo.com/68375232
- Integration tests are a scam -JB Rainsberger
http://www.infoq.com/presentations/integration-tests-scam
- The Art of Unit Testing - Roy Osherove
http://www.manning.com/osherove


Refactor
----------
- small steps
- run tests after each step
- no new features or bug fixes
- stop at the goal
- minimize time in broken state


Code Analysis
--------------------------
ctrl + 1


Moving code
--------------
select line and alt + UP to move line up


Browser Versions
------------------------------
- not nesessary to have on every browser
- only smoke tests on different platforms/browsers
- rest on one platform/browser and alternate from time to time

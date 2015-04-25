

SELENIUM and Eclipse
----------------------------------------

Add External Jars to Java build path
Now you need to add selenium webdriver’s jar files in to Java build path.

a) Right click on Project ‘OnlineStore‘ > Select Properties > Java build path. Then navigate to Libraries tab and click Add External JARs.

Selenium-Jar-1

b) Add Selenium Java jar, you may add the source file too.
- selenium-java-2.40.0.jar

c) Add all the jars from the libs folder as well


XPath
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


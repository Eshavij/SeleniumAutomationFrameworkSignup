# SeleniumAutomationFrameworkSignup

SubmittedBy: Esha Vij

This project SeleniumAutomationFramework is a framework based on Selenium WebDriver,Maven and TestNG. We run the project  using TestNG as testng.xml is the”driver" which drives several test cases which are automated using selenium code. In this Code we are  running multiple test cases from multiple classes using xml  file . The project has got two main  test classes-VerifyPage and VerifyPageLinkTest  which are defined in src/test/java folder in test package to test opening of browser, test to verify title  of every page  and buttons (login/signup) on that page,test to verify signup success and failure . The signup page  at last  navigates to successfully sign Up if the  email id is valid  or otherwise shows failure if the email id is duplicate or invalid. This project framework also includes user defined exceptions , utils, page class,page objects, properties for different page objects.The Global dependencies are  defined in the maven pom.xml file for the project. 
This project framework runs for chrome browser whenever it  is run from testiNG . There is separate util class  in pages package which defines Properties object initialization , wait visibility and emailed file which is dynamically entered at run time and a navigate back method which navigates back to login page.


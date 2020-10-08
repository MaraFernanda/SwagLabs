# Project using Java + Selenium + TestNG + Log4J + WebDriver + Gradle + POM

## Prerequisites:
jdk8 installed

Gradle installed (Download link: https://gradle.org/releases/) - 6.5.1 Version used in this project

IntelliJ installed  (Download link: https://www.jetbrains.com/idea/download/#section=windows)


## Configuration and Setup:
1. Set the environment Variables (GRADLE and JAVA).
    Open ‘Edit environment variables for your account’, use ‘User variables’ and click on New button for create a new Variable.
    For Name enter GRADLE_HOME and for Value enter Gradle directory. 
    Select ‘PATH environment variable’ and hit on edith, now click on new, then write %GRADLE_HOME%\bin as reference for the bin folder.
    For add the Java variables follow the same steps, create the variable as JAVA_HOME and add the path, C:\Program Files\Java\openjdk1.8.0_232, then edith the Path for add %JAVA_HOME%\bin

2. Download this example with: git clone https://github.com/MaraFernanda/SwagLabs.git
    
3. Optional - If you want receive the results report to your email go to the next file and add your email account, you can add multiple accounts separating them by a comma: config/email_reporter/email_recipients.txt, you can also change the account that sends the mail go to EmailTestResults.ps1 and change $EmFrom, $username and $pwd
   Allow access to insecure applications, it is necessary to send and receive emails. Use the following link for both accounts: https://myaccount.google.com/lesssecureapps?pli=1                                                                                                                                                                                                                             


## Options to run the project:
1. Go to the folder where you downloaded the project and run the file **Project_Execution.bat**
   This will run the project and send an email with the report results to the configured accounts.
   
2. Open the project and run the next file: **./src/test/java/TestNG_SwagLabs_All.xml**
   NOTE: Keep in mind that with this action you will not receive mail.
   
  
   

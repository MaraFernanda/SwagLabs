
REM this line is to run All test cases from TestNG_MiGestion_All.xml
CMD /C gradlew test -PTestNG_SwagLabs_All.xml

REM send the email report
powershell .\config\email_reporter\EmailTestResults.ps1

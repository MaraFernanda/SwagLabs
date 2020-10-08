$EmFrom = "fa720574@gmail.com"
$username = "fa720574@gmail.com"
$pwd = "TestAccount1."
$EMAIL_RECIPIENT_FILE = ".\config\email_reporter\email_recipients.txt"
$email_recipiants = Get-Content $EMAIL_RECIPIENT_FILE
$Server = "smtp.gmail.com"
$port = 587
$Subj = "Execution Report - SWAGLABS PROJECT"
$Bod = "A new report has been created. Please find the report attached."
$Att = ".\build\reports\tests\test\emailable-report.html"
$securepwd = ConvertTo-SecureString $pwd -AsPlainText -Force
$cred = New-Object -TypeName System.Management.Automation.PSCredential -ArgumentList $username, $securepwd
Send-MailMessage -To ($email_recipiants -split ',') -From $EmFrom -Body $Bod -Subject $Subj -Attachments $Att -SmtpServer $Server -port $port -UseSsl  -Credential $cred

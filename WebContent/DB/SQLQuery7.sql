
select Status.StatusAccountId,Department.DepartmentId, LanguageScore.LanguageScoreId,LanguageScore.EmployeeId,AccountName,FullName,DepartmentName,LanguageName,Score,Date,Note 
from LanguageScore join Language on Language.LanguageTypeId= LanguageScore.LanguageTypeId
join Account on Account.EmployeeId = LanguageScore.EmployeeId
join Department on Department.DepartmentId = Account.DepartmentId
join Status on Status.StatusAccountId = Account.StatusAccountId


select LanguageScore.LanguageScoreId,LanguageScore.EmployeeId,AccountName,FullName,DepartmentName,LanguageName,Score,Date,Note from LanguageScore join Language on Language.LanguageTypeId= LanguageScore.LanguageTypeId join Account on Account.EmployeeId = LanguageScore.EmployeeId join Department on Department.DepartmentId = Account.DepartmentId join Status on Status.StatusAccountId = Account.StatusAccountId where AccountName like N'%%' and FullName like N'%%' and Score like N'%%' and  Account.DepartmentId like N'%1%' and Account.StatusAccountId like N'%%'  

select Status.StatusAccountId,Department.DepartmentId,LanguageScore.LanguageScoreId,LanguageScore.EmployeeId,AccountName,FullName,DepartmentName,LanguageName,Score,Date,Note 
from LanguageScore join Language on Language.LanguageTypeId= LanguageScore.LanguageTypeId join Account on 
Account.EmployeeId = LanguageScore.EmployeeId join Department on Department.DepartmentId = Account.DepartmentId 
join Status on Status.StatusAccountId = Account.StatusAccountId where 
 FullName like N'%Linh%' or Score like '%0%'
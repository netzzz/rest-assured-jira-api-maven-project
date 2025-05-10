### Jira API Testing Project written using REST Assured and POM Design Pattern   
Project Validates end-to-end workflow for interacting with the Jira REST API using REST Assured.  

* [Overview](#overview)  
* [Instructions to Execute the Test Suite](#instructions-to-execute-the-test-suite)  
* [Test Log and Test Report](#test-log-and-test-report)  
* [API Documentation](#api-documentation)  

### Overview
Test Case covers the following API operations:  
 * Adding a new Jira issue to a specified project  
 * Uploading an attachment to the newly created issue  
 * Retrieving the issue details to verify successful creation  
 * Deleting the issue to ensure cleanup and test idempotency  
  
### Instructions to Execute the Test Suite: 
1) Clone the Repository  
2) Open the Project in an IDE  
3) Update the Maven Project  
4) Install TestNG (if not already installed)  
5) Create a Jira Account and Project:  
   Set up a Jira account and create a Jira project specifically for testing purposes
6) Modify the baseURI String in JiraApiTestMethods:  
   Update the baseURI to reflect the Jira site name created in previous step
7) Add User Environment Variable 'SECRET_KEY' with value '1223315678594234'
8) Follow the official [Basic auth for REST APIs](https://developer.atlassian.com/cloud/jira/platform/basic-auth-for-rest-apis/) guide to generate an authorization token.  
9) Use EncryptionUtil.encrypt() method to Encrypt Authorization Token generated in previous step
10) Update the JiraApiData.returnAuthorizationToken() Method:  
   Ensure the method references your Encrypted Jira Project Key   
11) Execute the Test Suite via the Command Line Terminal:   
```  
mvn -Dlog4j.configurationFile=src\test\resources\loggerconfig\log4j2.xml -Dsurefire.suiteXmlFiles=src\test\resources\suites\JiraApiRegressionSuite.xml test
```
  
### Test Log and Test Report   
* After each run, Test Log is stored in a timestamped .log file within the 'test_logs' directory,   
  while the Test Report is stored in a timestamped directory within the 'test_reports' directory.   
* Each report includes an 'html' directory where the simple, colour-coded view of the test results is stored.   
   
### API Documentation  
[Jira API Documentation](https://developer.atlassian.com/cloud/jira/platform/rest/v2/intro/#about)


* Jira API Testing Project written using REST Assured and POM Design Pattern  
  
* Follow these Steps to Run Test on your Machine:  
1) Clone the Repository  
2) Open the Project in an IDE  
3) Update the Maven Project  
4) Install TestNG (if not already installed)  
5) Create a Jira Account and Project:  
   Set up a Jira account and create a Jira project specifically for testing purposes  
6) Follow the official [Basic auth for REST APIs](https://developer.atlassian.com/cloud/jira/platform/basic-auth-for-rest-apis/) guide to generate an authorization token.  
7) Modify the baseURI String in JiraApiTestMethods:  
   Update the baseURI to reflect the Jira site name created in Step 5  
8) Update the addIssue(String, String, String) Method in JiraApiTests:  
   Ensure the method references your Jira Project Key  
9) Modify returnAuthorizationToken() in JiraApiData:  
   Update this method to return the authorization token created in Step 6.  
10) Execute the Test
  
* [Jira API Documentation](https://developer.atlassian.com/cloud/jira/platform/rest/v2/intro/#about)


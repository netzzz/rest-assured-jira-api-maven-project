package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import testmethods.JiraApiTestMethods;

public class JiraApiTests {
	@Test
	public void validateJiraApi() {
		Response addIssue = JiraApiTestMethods.addIssue("<projectKey>","Dropdown not working","Bug");
		JiraApiTestMethods.validateAddIssue(addIssue);
		int addedIssueId = JiraApiTestMethods.getAddedIssueId(addIssue);

		Response addAttachment = JiraApiTestMethods.addAttachment(addedIssueId, "src/test/resources/files/attachment.png");
		JiraApiTestMethods.validateAddAttachment(addAttachment);

		Response getIssue = JiraApiTestMethods.getIssue(addedIssueId);
		JiraApiTestMethods.validateGetIssue(getIssue);

		Response deleteIssue = JiraApiTestMethods.deleteIssue(addedIssueId);
		JiraApiTestMethods.validateDeleteIssue(deleteIssue);
	}
}

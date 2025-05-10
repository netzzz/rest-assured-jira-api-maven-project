package tests;

import org.testng.annotations.Test;

import data.HttpResponseStatusCodes;
import io.restassured.response.Response;
import testmethods.JiraApiTestMethods;

public class JiraApiTests {
	@Test
	public void validateJiraApi() throws Exception{
		Response addIssue = JiraApiTestMethods.addIssue("SCRUM","Dropdown not working","Bug");
		JiraApiTestMethods.validateStatusCodeOfResponse("Add Issue", addIssue, HttpResponseStatusCodes.CREATED);
		int addedIssueId = JiraApiTestMethods.getAddedIssueId(addIssue);

		Response addAttachment = JiraApiTestMethods.addAttachment(addedIssueId, "src/test/resources/files/attachment.png");
		JiraApiTestMethods.validateStatusCodeOfResponse("Add Attachment", addAttachment, HttpResponseStatusCodes.OK);

		Response getIssue = JiraApiTestMethods.getIssue(addedIssueId);
		JiraApiTestMethods.validateStatusCodeOfResponse("Get Issue", getIssue, HttpResponseStatusCodes.OK);

		Response deleteIssue = JiraApiTestMethods.deleteIssue(addedIssueId);
		JiraApiTestMethods.validateStatusCodeOfResponse("Delete Issue", deleteIssue, HttpResponseStatusCodes.NOCONTENT);
	}
}

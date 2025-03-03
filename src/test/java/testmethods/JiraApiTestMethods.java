package testmethods;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import data.HttpResponseStatusCodes;
import data.JiraApiData;
import helperfunctions.HelperFunctions;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraApiTestMethods {
	private static final Logger logger = LogManager.getLogger(JiraApiTestMethods.class.getName());

	private static String baseURI = "https://<JiraSiteName>.atlassian.net";

	// ------------------------
	// Add Issue Methods

	public static Response addIssue(String projectKey, String issueSummary, String issueType) {
		RestAssured.baseURI = baseURI;

		return given().header("Content-Type", "application/json")
				.header("Authorization",JiraApiData.returnAuthorizationToken())
				.body(JiraApiData.returnAddIssueRequestBody(projectKey, issueSummary, issueType))
				.when().post("rest/api/3/issue")
				.then().extract().response();
	}

	public static void validateAddIssue(Response addIssue) {
		Assert.assertEquals(addIssue.getStatusCode(), HttpResponseStatusCodes.CREATED.getCode(),
				String.format("Add Issue Response Status Code is %d as Not Expected", 
						addIssue.getStatusCode()));
		logger.info(String.format("Add Issue Response Status Code is %d as Expected", 
				HttpResponseStatusCodes.CREATED.getCode()));
	}

	public static int getAddedIssueId(Response addIssue) {
		JsonPath addIssueResponseJson = HelperFunctions.convertRestAssuredResponseToJson(addIssue);
		return addIssueResponseJson.getInt("id");
	}

	// ------------------------
	// Add Attachment Methods

	public static Response addAttachment(int issueId, String filePath) {
		RestAssured.baseURI = baseURI;

		return given().header("Authorization", JiraApiData.returnAuthorizationToken())
				.header("X-Atlassian-Token", "no-check").multiPart("file", new File(filePath))
				.post("rest/api/3/issue/" + issueId + "/attachments");
	}

	public static void validateAddAttachment(Response addAttachment) {
		Assert.assertEquals(addAttachment.getStatusCode(), HttpResponseStatusCodes.OK.getCode(),
				String.format("Add Attachment Response Status Code is %d as Not Expected", 
						addAttachment.getStatusCode()));
		logger.info(String.format("Add Attachment Response Status Code is %d as Expected", 
				HttpResponseStatusCodes.OK.getCode()));
	}

	// ------------------------
	// Get Issue Methods

	public static Response getIssue(int issueId) {
		RestAssured.baseURI = baseURI;

		return given().header("Authorization", JiraApiData.returnAuthorizationToken())
				.header("Accept", "application/json").get("rest/api/3/issue/" + issueId);
	}

	public static void validateGetIssue(Response getIssue) {
		Assert.assertEquals(getIssue.getStatusCode(), HttpResponseStatusCodes.OK.getCode(),
				String.format("Get Issue Response Status Code is %d as Not Expected", 
						getIssue.getStatusCode()));
		logger.info(String.format("Get Issue Response Status Code is %d as Expected", 
				HttpResponseStatusCodes.OK.getCode()));
	}

	// ------------------------
	// Delete Issue Methods

	public static Response deleteIssue(int issueId) {
		RestAssured.baseURI = baseURI;
		return given().header("Authorization", JiraApiData.returnAuthorizationToken())
				.header("Accept", "application/json").delete("rest/api/3/issue/" + issueId);
	}

	public static void validateDeleteIssue(Response deleteIssue) {
		Assert.assertEquals(deleteIssue.getStatusCode(), HttpResponseStatusCodes.NOCONTENT.getCode(),
				String.format("Delete Issue Response Status Code is %d as Not Expected", 
						deleteIssue.getStatusCode()));
		logger.info(String.format("Delete Issue Response Status Code is %d as Expected", 
						HttpResponseStatusCodes.NOCONTENT.getCode()));
	}
}

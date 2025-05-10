package testmethods;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;

import data.HttpResponseStatusCodes;
import data.JiraApiData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.requests.addissue.AddIssueRequestBody;
import pojo.requests.addissue.AddIssueRequestBodyFields;
import pojo.requests.addissue.AddIssueRequestBodyIssueTypeField;
import pojo.requests.addissue.AddIssueRequestBodyProjectField;
import utils.HelperFunctions;

public class JiraApiTestMethods {
	private static String baseURI = "https://nemanja-apipractice.atlassian.net";

	public static Response addIssue(String projectKey, String issueSummary, String issueTypeName) throws Exception{
		RestAssured.baseURI = baseURI;

		AddIssueRequestBodyProjectField addIssueRequestBodyProjectField = new AddIssueRequestBodyProjectField(projectKey);
		AddIssueRequestBodyIssueTypeField addIssueRequestBodyIssueTypeField = new AddIssueRequestBodyIssueTypeField(issueTypeName);
		AddIssueRequestBodyFields addIssueRequestBodyFields = new AddIssueRequestBodyFields(addIssueRequestBodyProjectField, 
				issueSummary, addIssueRequestBodyIssueTypeField);

		AddIssueRequestBody addIssueRequestBody = new AddIssueRequestBody(addIssueRequestBodyFields);

		return given().header("Content-Type", "application/json")
				.header("Authorization",JiraApiData.returnAuthorizationToken())
				.body(addIssueRequestBody)
				.when().post("rest/api/3/issue")
				.then().extract().response();
	}

	public static int getAddedIssueId(Response addIssue) {
		JsonPath addIssueResponseJson = HelperFunctions.convertRestAssuredResponseToJson(addIssue);
		return addIssueResponseJson.getInt("id");
	}

	public static Response addAttachment(int issueId, String filePath) throws Exception{
		RestAssured.baseURI = baseURI;

		return given().header("Authorization", JiraApiData.returnAuthorizationToken())
				.header("X-Atlassian-Token", "no-check").multiPart("file", new File(filePath))
				.post("rest/api/3/issue/" + issueId + "/attachments");
	}

	public static Response getIssue(int issueId) throws Exception{
		RestAssured.baseURI = baseURI;

		return given().header("Authorization", JiraApiData.returnAuthorizationToken())
				.header("Accept", "application/json").get("rest/api/3/issue/" + issueId);
	}

	public static Response deleteIssue(int issueId) throws Exception{
		RestAssured.baseURI = baseURI;
		return given().header("Authorization", JiraApiData.returnAuthorizationToken())
				.header("Accept", "application/json").delete("rest/api/3/issue/" + issueId);
	}

	public static void validateStatusCodeOfResponse(String requestName, Response response, 
			HttpResponseStatusCodes expectedResponseStatusCode) {
		Assert.assertEquals(response.getStatusCode(), expectedResponseStatusCode.getCode(),
				String.format("Status Code for %s Request is %d as Not Expected", requestName, response.getStatusCode()));
		HelperFunctions.logToReportAndLog4j(String.format("Status Code for %s Request is %d as Expected", requestName,
				expectedResponseStatusCode.getCode()));
	}
}

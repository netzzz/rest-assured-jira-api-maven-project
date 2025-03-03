package data;

public class JiraApiData {
	public static String returnAddIssueRequestBody(String projectKey, String issueSummary, String issueType) {
		return "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \""+projectKey+"\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \""+issueSummary+"\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \""+issueType+"\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}";
	}

	public static String returnAuthorizationToken() {
		return "<jiraAuthenticationToken>";
	}
}

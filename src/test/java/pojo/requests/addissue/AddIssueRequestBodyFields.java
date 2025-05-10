package pojo.requests.addissue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddIssueRequestBodyFields {

	@JsonProperty("project")
	private AddIssueRequestBodyProjectField project;

	@JsonProperty("summary")
	private String issueSummary;

	@JsonProperty("issuetype")
	private AddIssueRequestBodyIssueTypeField issueType;

	public AddIssueRequestBodyFields() {
	}

	public AddIssueRequestBodyFields(AddIssueRequestBodyProjectField project, String issueSummary,
			AddIssueRequestBodyIssueTypeField issueType) {
		this.project = project;
		this.issueSummary = issueSummary;
		this.issueType = issueType;
	}

	public AddIssueRequestBodyProjectField getProject() {
		return project;
	}

	public void setProject(AddIssueRequestBodyProjectField project) {
		this.project = project;
	}

	public String getIssueSummary() {
		return issueSummary;
	}

	public void setIssueSummary(String issueSummary) {
		this.issueSummary = issueSummary;
	}

	public AddIssueRequestBodyIssueTypeField getIssueType() {
		return issueType;
	}

	public void setIssueType(AddIssueRequestBodyIssueTypeField issueType) {
		this.issueType = issueType;
	}

	@Override
	public String toString() {
		return String.format("{ \"project\": %s, \"summary\": \"%s\", \"issuetype\": %s }", this.project.toString(), this.issueSummary, this.issueType.toString());
	}
}

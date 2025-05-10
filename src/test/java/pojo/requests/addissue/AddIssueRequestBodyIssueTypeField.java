package pojo.requests.addissue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddIssueRequestBodyIssueTypeField {
	@JsonProperty("name")
	private String issueTypeName;

	public AddIssueRequestBodyIssueTypeField() {
	}

	public AddIssueRequestBodyIssueTypeField(String issueTypeName) {
		this.issueTypeName = issueTypeName;
	}

	public void setIssueTypeName(String issueTypeName) {
		this.issueTypeName = issueTypeName;
	}

	public String getIssueTypeName() {
		return this.issueTypeName;
	}

	@Override
	public String toString() {
		return String.format("{ \"name\" : \"%s\" }", this.issueTypeName);
	}
}

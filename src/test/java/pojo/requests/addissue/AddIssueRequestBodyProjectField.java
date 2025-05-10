package pojo.requests.addissue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddIssueRequestBodyProjectField {
	@JsonProperty("key")
	private String projectKey;

	public AddIssueRequestBodyProjectField() {
	}

	public AddIssueRequestBodyProjectField(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	@Override
	public String toString() {
		return String.format("{ \"key\" : \"%s\" }", this.projectKey);
	}
}

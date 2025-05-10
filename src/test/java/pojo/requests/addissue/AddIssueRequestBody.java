package pojo.requests.addissue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddIssueRequestBody {
	@JsonProperty("fields")
	private AddIssueRequestBodyFields addIssueRequestBodyFields;

	public AddIssueRequestBody() {
	}
	
	public AddIssueRequestBody(AddIssueRequestBodyFields addIssueRequestBodyFields) {
		this.addIssueRequestBodyFields = addIssueRequestBodyFields;
	}

	public AddIssueRequestBodyFields getAddIssueRequestBodyFields() {
		return addIssueRequestBodyFields;
	}

	public void setAddIssueRequestBodyFields(AddIssueRequestBodyFields addIssueRequestBodyFields) {
		this.addIssueRequestBodyFields = addIssueRequestBodyFields;
	}

	@Override
	public String toString() {
		return String.format("{ \"fields\" : %s }", this.addIssueRequestBodyFields.toString());
	}
}

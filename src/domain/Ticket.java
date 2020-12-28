package domain;
import java.util.List;

public class Ticket {
	
	// Basic properties
	
	private String id;
	
	private String url;
	
	private String externalId;
	
	private String createdAt;
	
	private String type;
	
	private String subject;
	
	private String description;
	
	private String priority;
	
	private String status;
	
	private List<String> tags;
	
	private Boolean hasIncidents;
	
	private String dueAt;
	
	private String via;
	
	private Long submitterId;
	
	private Long assigneeId;
	
	private Long organizationId;
	
	
	// Relative properties
	
	private User submitter = new User();
	
	private User asignee = new User();

	private Organization organization = new Organization();
	
	
	// Properties for search
	private String fullText;
	
	
	public Ticket() {}
	
	public void buildRelativeInformation(List<User> users, List<Organization> organizations) {
		buildSubmitter(users);
		buildAsignee(users);
		buildOrganization(organizations);
	}
	
	private void buildSubmitter(List<User> users) {
		this.submitter = users.stream()
				.filter(each -> each.getId() == submitterId)
				.findFirst().orElse(new User());
	}
	
	private void buildAsignee(List<User> users) {
		this.asignee = users.stream()
				.filter(each -> each.getId() == assigneeId)
				.findFirst().orElse(new User());
	}
	
	private void buildOrganization(List<Organization> organizations) {
		this.organization = organizations.stream()
				.filter(each -> each.getId() == organizationId)
				.findFirst().orElse(new Organization());
	}

	/**
	 * This method build a fullText property by concat all properties name and their value
	 */
	public void buildFullText() {
		this.fullText = createKeyValue(TicketField.ID.getValue(), id)
				+ createKeyValue(TicketField.URL.getValue(), url)
				+ createKeyValue(TicketField.EXTERNAL_ID.getValue(), externalId)
				+ createKeyValue(TicketField.CREATED_AT.getValue(), createdAt)
				+ createKeyValue(TicketField.TYPE.getValue(), type)
				+ createKeyValue(TicketField.SUBJECT.getValue(), subject)
				+ createKeyValue(TicketField.DESCRIPTION.getValue(), description)
				+ createKeyValue(TicketField.PRIORITY.getValue(), priority)
				+ createKeyValue(TicketField.STATUS.getValue(), status)
				+ createKeyValue(TicketField.SUBMITTER_ID.getValue(), submitterId)
				+ createKeyValue(TicketField.ASSIGNEE_ID.getValue(), assigneeId)
				+ createKeyValue(TicketField.ORGANIZATION_ID.getValue(), organizationId)
				+ createKeyValues(TicketField.TAGS.getValue(), tags)
				+ createKeyValue(TicketField.HAS_INCIDENTS.getValue(), hasIncidents)
				+ createKeyValue(TicketField.DUE_AT.getValue(), dueAt)
				+ createKeyValue(TicketField.VIA.getValue(), via);
	}

	private String createKeyValue(String key, Object value) {
		return key + ": " + value + "; ";
	}
	
	private String createKeyValues(String key, List<String> values) {
		String result = "";
		for(Object value : values)
			result += createKeyValue(key, value);
		
		return result;
	}

	@Override
	public String toString() {
		String basicInformation = "id=" + id + "\n url=" + url + "\n externalId=" + externalId + "\n createdAt=" + createdAt
				+ "\n type=" + type + "\n subject=" + subject + "\n description=" + description + "\n priority=" + priority
				+ "\n status=" + status + "\n tags=" + tags + "\n hasIncidents=" + hasIncidents + "\n dueAt=" + dueAt
				+ "\n via=" + via + "\n submitterId=" + submitterId + "\n assigneeId=" + assigneeId + "\n organizationId="
				+ organizationId + "\n";
		
		String asigneeName = "Asignee name= " + asignee.getName() + "\n";
		String submitterName = "Submitter name= " + submitter.getName() + "\n";
		String organizationName = "Organization name= " + organization.getName();
		
		return basicInformation + asigneeName + submitterName + organizationName;
	}
	
	
	// GETTER - SETTER

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Boolean getHasIncidents() {
		return hasIncidents;
	}

	public void setHasIncidents(Boolean hasIncidents) {
		this.hasIncidents = hasIncidents;
	}

	public String getDueAt() {
		return dueAt;
	}

	public void setDueAt(String dueAt) {
		this.dueAt = dueAt;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public Long getSubmitterId() {
		return submitterId;
	}

	public void setSubmitterId(Long submitterId) {
		this.submitterId = submitterId;
	}

	public Long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
		this.submitter = submitter;
	}

	public User getAsignee() {
		return asignee;
	}

	public void setAsignee(User asignee) {
		this.asignee = asignee;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	
}

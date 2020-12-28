package domain;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

	// Basic properties
	
	private Long id;
	
	private String url;
	
	private String externalId;
	
	private String name;
	
	private String alias;
	
	private String createdAt;
	
	private Boolean active;
	
	private Boolean verified;
	
	private Boolean shared;
	
	private String locale;
	
	private String timezone;
	
	private String lastLoginAt;
	
	private String email;
	
	private String phone;
	
	private String signature;
	
	private List<String> tags;
	
	private Boolean suspended;
	
	private String role;
	
	private Long organizationId;
	
	
	// Relative properties
	
	private List<Ticket> assigneeTickets = new ArrayList<>();
	
	private List<Ticket> submittedTickets = new ArrayList<>();
	
	private Organization organization = new Organization();
	
	
	// Properties for search
	private String fullText;
	
	
	public User() {}
	
	public void buildRelativeProperties(List<Ticket> tickets, List<Organization> organizations) {
		buildAssigneeTickets(tickets);
		buildSubmittedTickets(tickets);
		buildOrganization(organizations);
	}
	
	private void buildAssigneeTickets(List<Ticket> tickets) {
		this.assigneeTickets = tickets.stream()
				.filter(each -> each.getAssigneeId() == id)
				.collect(Collectors.toList());
	}
	
	private void buildSubmittedTickets(List<Ticket> tickets) {
		this.submittedTickets = tickets.stream()
				.filter(each -> each.getSubmitterId() == id)
				.collect(Collectors.toList());
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
		this.fullText = createKeyValue(UserField.ID.getValue(), id)
				+ createKeyValue(UserField.URL.getValue(), url)
				+ createKeyValue(UserField.EXTERNAL_ID.getValue(), externalId)
				+ createKeyValue(UserField.NAME.getValue(), name)
				+ createKeyValue(UserField.ALIAS.getValue(), alias)
				+ createKeyValue(UserField.CREATED_AT.getValue(), createdAt)
				+ createKeyValue(UserField.ACTIVE.getValue(), active)
				+ createKeyValue(UserField.VERIFIED.getValue(), verified)
				+ createKeyValue(UserField.SHARED.getValue(), shared)
				+ createKeyValue(UserField.LOCALE.getValue(), locale)
				+ createKeyValue(UserField.TIMEZONE.getValue(), timezone)
				+ createKeyValue(UserField.LAST_LOGIN_AT.getValue(), lastLoginAt)
				+ createKeyValue(UserField.EMAIL.getValue(), email)
				+ createKeyValue(UserField.PHONE.getValue(), phone)
				+ createKeyValue(UserField.SIGNATURE.getValue(), signature)
				+ createKeyValue(UserField.ORGANIZATION_ID.getValue(), organizationId)
				+ createKeyValues(UserField.TAGS.getValue(), tags)
				+ createKeyValue(UserField.SUSPENDED.getValue(), suspended)
				+ createKeyValue(UserField.ROLE.getValue(), role);
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
		String basicInformation = "id=" + id + "\n url=" + url + "\n externalId=" + externalId + "\n name=" + name + "\n alias=" + alias
				+ "\n createdAt=" + createdAt + "\n active=" + active + "\n verified=" + verified + "\n shared=" + shared
				+ "\n locale=" + locale + "\n timezone=" + timezone + "\n lastLoginAt=" + lastLoginAt + "\n email=" + email
				+ "\n phone=" + phone + "\n signature=" + signature + "\n tags=" + tags + "\n suspended=" + suspended
				+ "\n role=" + role + "\n organizationId=" + organizationId + "\n";
		
		String assigneeTicketSubject = "Assignee ticket subject= " + ticketsToString(assigneeTickets) + "\n";
		String submittedTicketSubject = "Submitted ticket subject= " + ticketsToString(submittedTickets) + "\n";
		String organizationName = "Organziation name= " + organization.getName();
		
		return basicInformation + assigneeTicketSubject + submittedTicketSubject + organizationName;
	}

	private String ticketsToString(List<Ticket> tickets) {
		String result = "";
		for (Ticket ticket : tickets) {
			result += ticket.getSubject() + "; ";
		}
		
		return result;
	}

	
	// GETTER - SETTER
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Boolean getShared() {
		return shared;
	}

	public void setShared(Boolean shared) {
		this.shared = shared;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(String lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Boolean getSuspended() {
		return suspended;
	}

	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public List<Ticket> getAssigneeTickets() {
		return assigneeTickets;
	}

	public void setAssigneeTickets(List<Ticket> assigneeTickets) {
		this.assigneeTickets = assigneeTickets;
	}

	public List<Ticket> getSubmittedTickets() {
		return submittedTickets;
	}

	public void setSubmittedTickets(List<Ticket> submittedTickets) {
		this.submittedTickets = submittedTickets;
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

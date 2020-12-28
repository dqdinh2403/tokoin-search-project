package domain;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Organization {

	// Basic properties
	
	private Long id;
	
	private String url;
	
	private String externalId;
	
	private String name;
	
	private List<String> domainNames;
	
	private String createdAt;
	
	private String details;
	
	private Boolean sharedTickets;
	
	private List<String> tags;
	
	
	// Relative properties
	
	private List<User> users = new ArrayList<>();

	private List<Ticket> tickets = new ArrayList<>();

	
	// Properties for search
	private String fullText;
	
	
	public Organization() {}
	
	public void buildRelativeInformation(List<User> allUsers, List<Ticket> allTickets) {
		buildUsers(allUsers);
		buildTickets(allTickets);
	}
	
	private void buildUsers(List<User> allUsers) {
		this.users = allUsers.stream()
				.filter(each -> each.getOrganizationId() == id)
				.collect(Collectors.toList());
	}
	
	private void buildTickets(List<Ticket> allTickets) {
		this.tickets = allTickets.stream()
				.filter(each -> each.getOrganizationId() == id)
				.collect(Collectors.toList());
	}
	
	/**
	 * This method build a fullText property by concat all properties name and their value
	 */
	public void buildFullText() {
		this.fullText = createKeyValue(OrganizationField.ID.getValue(), id)
				+ createKeyValue(OrganizationField.URL.getValue(), url)
				+ createKeyValue(OrganizationField.EXTERNAL_ID.getValue(), externalId)
				+ createKeyValue(OrganizationField.NAME.getValue(), name)
				+ createKeyValues(OrganizationField.DOMAIN_NAMES.getValue(), domainNames)
				+ createKeyValue(OrganizationField.CREATED_AT.getValue(), createdAt)
				+ createKeyValue(OrganizationField.DETAILS.getValue(), details)
				+ createKeyValue(OrganizationField.SHARED_TICKETS.getValue(), sharedTickets)
				+ createKeyValues(OrganizationField.TAGS.getValue(), tags);
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
		String basicInformation = "id=" + id + "\n url=" + url + "\n externalId=" + externalId + "\n name=" + name
				+ "\n domainNames=" + domainNames + "\n createdAt=" + createdAt + "\n details=" + details
				+ "\n sharedTickets=" + sharedTickets + "\n tags=" + tags + "\n";
		
		String userName = "User name= " + usersToString(users) + "\n";
		String ticketSubject = "Ticket subject= " + ticketsToString(tickets);
		
		return basicInformation + userName + ticketSubject;
	}
	
	private String usersToString(List<User> users) {
		String result = "";
		for (User user : users) {
			result += user.getName() + "; ";
		}
		
		return result;
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

	public List<String> getDomainNames() {
		return domainNames;
	}

	public void setDomainNames(List<String> domainNames) {
		this.domainNames = domainNames;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Boolean getSharedTickets() {
		return sharedTickets;
	}

	public void setSharedTickets(Boolean sharedTickets) {
		this.sharedTickets = sharedTickets;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	
}

package domain;

/**
 * This enum using for field name of Ticket in Json file
 * @author dqdinh
 *
 */
public enum TicketField {
	ID("_id"),
	URL("url"),
	EXTERNAL_ID("external_id"),
	CREATED_AT("created_at"),
	TYPE("type"),
	SUBJECT("subject"),
	DESCRIPTION("description"),
	PRIORITY("priority"),
	STATUS("status"),
	SUBMITTER_ID("submitter_id"),
	ASSIGNEE_ID("assignee_id"),
	ORGANIZATION_ID("organization_id"),
	TAGS("tags"),
	HAS_INCIDENTS("has_incidents"),
	DUE_AT("due_at"),
	VIA("via");
	
	private String value;
	
	private TicketField(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Return a string contain all of field of this enum
	 * @return
	 */
	public static String showAllField() {
		String allValue = "";
		
		for (TicketField each : TicketField.values()) {
			allValue += each.value + "\n";
		}
		
		return allValue;
	}
	
}

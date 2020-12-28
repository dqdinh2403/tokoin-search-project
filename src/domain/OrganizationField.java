package domain;

/**
 * This enum using for field name of Organization in Json file
 * @author dqdinh
 *
 */
public enum OrganizationField {
	ID("_id"),
	URL("url"),
	EXTERNAL_ID("external_id"),
	NAME("name"),
	DOMAIN_NAMES("domain_names"),
	CREATED_AT("created_at"),
	DETAILS("details"),
	SHARED_TICKETS("shared_tickets"),
	TAGS("tags");
	
	private String value;
	
	private OrganizationField(String value) {
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
		
		for (OrganizationField each : OrganizationField.values()) {
			allValue += each.value + "\n";
		}
		
		return allValue;
	}
	
}

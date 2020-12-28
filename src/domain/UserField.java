package domain;

/**
 * This enum using for field name of User in Json file
 * @author dqdinh
 *
 */
public enum UserField {
	ID("_id"),
	URL("url"),
	EXTERNAL_ID("external_id"),
	NAME("name"),
	ALIAS("alias"),
	CREATED_AT("created_at"),
	ACTIVE("active"),
	VERIFIED("verified"),
	SHARED("shared"),
	LOCALE("locale"),
	TIMEZONE("timezone"),
	LAST_LOGIN_AT("last_login_at"),
	EMAIL("email"),
	PHONE("phone"),
	SIGNATURE("signature"),
	ORGANIZATION_ID("organization_id"),
	TAGS("tags"),
	SUSPENDED("suspended"),
	ROLE("role");
	
	private String value;
	
	private UserField(String value) {
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
		
		for (UserField each : UserField.values()) {
			allValue += each.value + "\n";
		}
		
		return allValue;
	}
	
}

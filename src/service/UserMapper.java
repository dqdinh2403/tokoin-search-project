package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import domain.User;
import domain.UserField;

public class UserMapper {
	
	public static final String FILE_NAME = "data\\users.json";
	
	/**
	 * Map data of User from Json Array to List User
	 * @param usersJson
	 * @return
	 */
	public static List<User> map(JSONArray usersJson) {
		List<User> result = new ArrayList<>();
		Iterator<JSONObject> iterator = usersJson.iterator();
		while(iterator.hasNext()) {
			JSONObject userJson = iterator.next();
			User user = new User();
			
			user.setId((Long) userJson.get(UserField.ID.getValue()));
			user.setUrl((String) userJson.get(UserField.URL.getValue()));
			user.setExternalId((String) userJson.get(UserField.EXTERNAL_ID.getValue()));
			user.setName((String) userJson.get(UserField.NAME.getValue()));
			user.setAlias((String) userJson.get(UserField.ALIAS.getValue()));
			user.setCreatedAt((String) userJson.get(UserField.CREATED_AT.getValue()));
			user.setActive((Boolean) userJson.get(UserField.ACTIVE.getValue()));
			user.setVerified((Boolean) userJson.get(UserField.VERIFIED.getValue()));
			user.setShared((Boolean) userJson.get(UserField.SHARED.getValue()));
			user.setLocale((String) userJson.get(UserField.LOCALE.getValue()));
			user.setTimezone((String) userJson.get(UserField.TIMEZONE.getValue()));
			user.setLastLoginAt((String) userJson.get(UserField.LAST_LOGIN_AT.getValue()));
			user.setEmail((String) userJson.get(UserField.EMAIL.getValue()));
			user.setPhone((String) userJson.get(UserField.PHONE.getValue()));
			user.setSignature((String) userJson.get(UserField.SIGNATURE.getValue()));
			
			JSONArray tags = (JSONArray) userJson.get(UserField.TAGS.getValue());
			user.setTags(mapToStrings(tags));
			
			user.setSuspended((Boolean) userJson.get(UserField.SUSPENDED.getValue()));
			user.setRole((String) userJson.get(UserField.ROLE.getValue()));
			user.setOrganizationId((Long) userJson.get(UserField.ORGANIZATION_ID.getValue()));

			user.buildFullText();
			
			result.add(user);
		}
		
		return result;
	}
	
	private static List<String> mapToStrings(JSONArray stringsJson){
		List<String> result = new ArrayList<>();
		Iterator<String> iterator = stringsJson.iterator();
		while(iterator.hasNext()) {
			result.add(iterator.next());
		}
		
		return result;
	}

}

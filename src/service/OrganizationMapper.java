package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import domain.Organization;
import domain.OrganizationField;

public class OrganizationMapper {
	
	public static final String FILE_NAME = "data\\organizations.json";
	
	/**
	 * Map data of Organization from Json Array to List Organization
	 * @param organizationsJson
	 * @return
	 */
	public static List<Organization> map(JSONArray organizationsJson) {
		List<Organization> result = new ArrayList<>();
		Iterator<JSONObject> iterator = organizationsJson.iterator();
		while(iterator.hasNext()) {
			JSONObject organizationJson = iterator.next();
			Organization organization = new Organization();
			
			organization.setId((Long) organizationJson.get(OrganizationField.ID.getValue()));
			organization.setUrl((String) organizationJson.get(OrganizationField.URL.getValue()));
			organization.setExternalId((String) organizationJson.get(OrganizationField.EXTERNAL_ID.getValue()));
			organization.setName((String) organizationJson.get(OrganizationField.NAME.getValue()));
			
			JSONArray domainNames = (JSONArray) organizationJson.get(OrganizationField.DOMAIN_NAMES.getValue());
			organization.setDomainNames(mapToStrings(domainNames));
			
			organization.setCreatedAt((String) organizationJson.get(OrganizationField.CREATED_AT.getValue()));
			organization.setDetails((String) organizationJson.get(OrganizationField.DETAILS.getValue()));
			organization.setSharedTickets((Boolean) organizationJson.get(OrganizationField.SHARED_TICKETS.getValue()));
			
			JSONArray tags = (JSONArray) organizationJson.get(OrganizationField.TAGS.getValue());
			organization.setTags(mapToStrings(tags));
			
			organization.buildFullText();
			
			result.add(organization);
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

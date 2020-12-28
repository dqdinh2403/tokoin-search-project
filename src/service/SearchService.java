package service;

import java.util.List;
import java.util.stream.Collectors;

import domain.Organization;
import domain.Ticket;
import domain.User;

public class SearchService {
	
	private static final String NO_RESULTS = "No results found";
	private static final String BREAK_LINE = "\n===============================================\n";
	
	/**
	 * Search by key-value in list User:
	 * If value is empty -> return users
	 * Else search by fullText of object
	 * @param users
	 * @param key
	 * @param value
	 * @return
	 */
	public static String searchInUsers(List<User> users, String key, String value){
		List<User> searchResult;
		if(value.isEmpty()) {
			searchResult = users;
		}
		else {
			String searchCriteria = key + ": " + value + ";";
			searchResult = users.stream()
					.filter(each -> each.getFullText().contains(searchCriteria))
					.collect(Collectors.toList());
		}
		
		String result = "";
		if(searchResult.isEmpty()) {
			result = NO_RESULTS;
		}else {
			for (User user : searchResult) {
				result += user.toString() + BREAK_LINE;
			}
		}
		
		return result;
	}
	
	/**
	 * Search by key-value in list Ticket:
	 * If value is empty -> return tickets
	 * Else search by fullText of object
	 * @param tickets
	 * @param key
	 * @param value
	 * @return
	 */
	public static String searchInTickets(List<Ticket> tickets, String key, String value){
		List<Ticket> searchResult;
		if(value.isEmpty()) {
			searchResult = tickets;
		}
		else {
			String searchCriteria = key + ": " + value + ";";
			searchResult = tickets.stream()
					.filter(each -> each.getFullText().contains(searchCriteria))
					.collect(Collectors.toList());
		}
		
		String result = "";
		if(searchResult.isEmpty()) {
			result = NO_RESULTS;
		}else {
			for (Ticket ticket : searchResult) {
				result += ticket.toString() + BREAK_LINE;
			}
		}
		
		return result;	
	}
	
	/**
	 * Search by key-value in list Organization:
	 * If value is empty -> return organizations
	 * Else search by fullText of object
	 * @param organizations
	 * @param key
	 * @param value
	 * @return
	 */
	public static String searchInOrganizations(List<Organization> organizations, String key, String value){
		List<Organization> searchResult;
		if(value.isEmpty()) {
			searchResult = organizations;
		}
		else {
			String searchCriteria = key + ": " + value + ";";
			searchResult = organizations.stream()
					.filter(each -> each.getFullText().contains(searchCriteria))
					.collect(Collectors.toList());
		}
		
		String result = "";
		if(searchResult.isEmpty()) {
			result = NO_RESULTS;
		}else {
			for (Organization organization : searchResult) {
				result += organization.toString() + BREAK_LINE;
			}
		}
			
		return result;	
	}

}

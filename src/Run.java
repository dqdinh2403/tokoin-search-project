import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import domain.Organization;
import domain.OrganizationField;
import domain.Ticket;
import domain.TicketField;
import domain.User;
import domain.UserField;
import service.OrganizationMapper;
import service.ReadJsonSimple;
import service.SearchService;
import service.TicketMapper;
import service.UserMapper;

public class Run {
	
	private static final String QUIT_CONTROL = "quit";
	private static final String BREAK_LINE = "===============================================\n";
	
	public static void main(String[] args) throws IOException, ParseException {
		
		// Read data from Json File
		List<Ticket> tickets = readTicketsFromFile();
		List<User> users = readUsersFromFile();
		List<Organization> organizations = readOrganizationsFromFile();

		// Build relative information for data
		for (Ticket ticket : tickets)
			ticket.buildRelativeInformation(users, organizations);
		
		for (User user : users) 
			user.buildRelativeProperties(tickets, organizations);
		
		for (Organization organization : organizations) 
			organization.buildRelativeInformation(users, tickets);
		
		// Start process
		mainStream(tickets, users, organizations);
	}
	
	private static void mainStream(List<Ticket> tickets, List<User> users, List<Organization> organizations) {
		String control = "";
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Type 'quit' to exit any time, Press 'Enter' to continue");
		control = keyboard.nextLine();
		if(QUIT_CONTROL.equals(control))
			System.exit(0);
		
		System.out.println("Select search options:\n \t Press 1 to search\n \t Press 2 to view a list of searchable fields\n \t Type 'quit' to exit");
		control = keyboard.nextLine();
		switch(control) {
		case "1":
			showSearchOption(tickets, users, organizations);
			break;
		case "2":
			showSearchableFields();
			break;
		case QUIT_CONTROL:
			System.exit(0);
		}
		
		System.out.println("Press any key to end");
		keyboard.nextLine();
		keyboard.close();
	}
	
	private static List<Ticket> readTicketsFromFile() throws IOException, ParseException{
		JSONArray ticketsJson = (JSONArray) ReadJsonSimple.readJsonFromFile(TicketMapper.FILE_NAME);
		List<Ticket> tickets = TicketMapper.map(ticketsJson);
		
		return tickets;
	}
	
	private static List<User> readUsersFromFile() throws IOException, ParseException{
		JSONArray usersJson = (JSONArray) ReadJsonSimple.readJsonFromFile(UserMapper.FILE_NAME);
		List<User> users = UserMapper.map(usersJson);
		
		return users;
	}
	
	private static List<Organization> readOrganizationsFromFile() throws IOException, ParseException{
		JSONArray organizationsJson = (JSONArray) ReadJsonSimple.readJsonFromFile(OrganizationMapper.FILE_NAME);
		List<Organization> organizations = OrganizationMapper.map(organizationsJson);
		
		return organizations;
	}
	
	private static void showSearchOption(List<Ticket> tickets, List<User> users, List<Organization> organizations) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Select 1) Users \t 2) Tickets \t 3) Organizations");
		String control = keyboard.nextLine();
		System.out.println("Enter search term");
		String key = keyboard.nextLine();
		System.out.println("Enter search value");
		String value = keyboard.nextLine();
		
		switch (control) {
		case "1":
			System.out.println(SearchService.searchInUsers(users, key, value));
			break;
		case "2":
			System.out.println(SearchService.searchInTickets(tickets, key, value));
			break;
		case "3":
			System.out.println(SearchService.searchInOrganizations(organizations, key, value));
			break;
		}
	}
	
	private static void showSearchableFields() {
		String userSearchableFields = BREAK_LINE + "Search Users with:\n" + UserField.showAllField();
		String ticketSearchableFields = BREAK_LINE + "Search Tickets with:\n" + TicketField.showAllField();
		String organizationSearchableFields = BREAK_LINE + "Search Organizations with:\n" + OrganizationField.showAllField();
		
		System.out.println(userSearchableFields + ticketSearchableFields + organizationSearchableFields);
	}

}
